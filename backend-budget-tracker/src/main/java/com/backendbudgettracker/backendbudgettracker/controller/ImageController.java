package com.backendbudgettracker.backendbudgettracker.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendbudgettracker.backendbudgettracker.entity.Image;
import com.backendbudgettracker.backendbudgettracker.repository.ImageRepository;
import com.backendbudgettracker.backendbudgettracker.security.JwtHelper;

@RestController
@RequestMapping("/image")
@CrossOrigin
public class ImageController {

    private ImageRepository imageRepository;

    @Autowired
    private JwtHelper jwtHelper;

    public ImageController(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @PostMapping("/findByTypeAndExternalId")
    public List<Image> findByTypeAndExternalId(@RequestBody Map<String, String> params, HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        List<Image> images = imageRepository.findAllByType(Image.Type.valueOf(params.get("type")));
        Long externalId = Long.parseLong(params.get("externalId"));
        List<Image> tmpImages = new ArrayList<Image>();
        for (Image image : images) {
            if (image.getExternalId() == externalId) {
                tmpImages.add(image);
            }
        }
        if (tmpImages == null || tmpImages.isEmpty()) {
            response.sendError(404, "No images found");
        }
        return tmpImages;
    }

    @GetMapping("/getProfilePicture")
    public Image getProfilePicture(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long userId = jwtHelper.getUserIdFromRequest(request);
        List<Image> images = imageRepository.findAllByType(Image.Type.USER);
        for (Image image : images) {
            if (image.getExternalId() == userId) {
                return image;
            }
        }
        response.sendError(404, "No profile picture found");
        return null;
    }

    @PostMapping("/getProductPicture")
    public Image getProductPicture(@RequestBody Map<String, String> params, HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        List<Image> images = imageRepository.findAllByType(Image.Type.PRODUCT);
        for (Image image : images) {
            if (image.getExternalId() == Long.parseLong(params.get("productId"))) {
                return image;
            }
        }
        response.sendError(404, "No product picture found");
        return null;
    }

    @PostMapping("/updateProfilePicture")
    public Image updateProfilePicture(@RequestBody String imgData, HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        Long userId = jwtHelper.getUserIdFromRequest(request);
        if (userId != null) {
            List<Image> images = imageRepository.findAllByType(Image.Type.USER);
            List<Image> tmpImages = new ArrayList<Image>();
            Image oldImage = null;
            for (Image image : images) {
                if (image.getExternalId() == userId) {
                    tmpImages.add(image);
                    oldImage = image;
                }
            }
            if (tmpImages == null || tmpImages.isEmpty()) {
                Image image = new Image();
                image.setImgData(imgData);
                image.setType(Image.Type.USER);
                image.setExternalId(userId);
                imageRepository.save(image);
                return image;
            }
            oldImage.setImgData(imgData);
            imageRepository.save(oldImage);
            return oldImage;
        }
        response.sendError(401);
        return null;
    }
}