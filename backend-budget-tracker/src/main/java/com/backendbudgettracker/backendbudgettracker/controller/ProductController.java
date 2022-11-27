package com.backendbudgettracker.backendbudgettracker.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import com.backendbudgettracker.backendbudgettracker.entity.Product;
import com.backendbudgettracker.backendbudgettracker.repository.ImageRepository;
import com.backendbudgettracker.backendbudgettracker.repository.ProductRepository;
import com.backendbudgettracker.backendbudgettracker.security.JwtHelper;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private JwtHelper jwtHelper;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("")
    public List<Product> index() {
        return productRepository.findAll();
    }

    /*
     * create product
     * {
     * "name"
     * "description"
     * "price"
     * }
     */
    @PostMapping("")
    public Product create(@RequestBody Product product, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        if (jwtHelper.getAdminFromRequest(request)) {
            return productRepository.save(product);
        }
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        return null;
    }

    /*
     * adds a picture to a product
     * {
     * "productId"
     * "imgUrl"
     * }
     */
    @PostMapping("/addImage")
    public Product addImage(@RequestBody Map<String, String> params, HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        if (jwtHelper.getAdminFromRequest(request)) {
            Optional<Product> product = productRepository.findById(Long.parseLong(params.get("productId")));
            if (product.isPresent()) {
                Image image = new Image();
                image.setImgUrl(params.get("imgUrl"));
                image.setExternalId(Long.parseLong(params.get("productId")));
                image.setType(Image.Type.PRODUCT);
                imageRepository.save(image);
                return product.get();
            }
            response.sendError(404, "Product not found");
            return null;
        }
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        return null;
    }

    /*
     * update product
     * {
     * "id"
     * "name"
     * "description"
     * "price"
     * }
     */
    @PostMapping("/update")
    public Product update(@RequestBody Product product, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        if (jwtHelper.getAdminFromRequest(request)) {
            Optional<Product> productToUpdate = productRepository.findById(product.getId());
            if (productToUpdate.isPresent()) {
                productToUpdate.get().setName(product.getName());
                productToUpdate.get().setDescription(product.getDescription());
                productToUpdate.get().setPrice(product.getPrice());
                return productRepository.save(productToUpdate.get());
            }
            response.sendError(404, "Product not found");
            return null;
        }
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        return null;
    }

    /*
     * delete product
     * {
     * "id"
     * }
     */
    @PostMapping("/delete")
    public void delete(@RequestBody Product product, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        if (jwtHelper.getAdminFromRequest(request)) {
            Optional<Product> productToDelete = productRepository.findById(product.getId());
            if (productToDelete.isPresent()) {
                productRepository.delete(productToDelete.get());
                return;
            }
            response.sendError(404, "Product not found");
            return;
        }
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        return;
    }
}