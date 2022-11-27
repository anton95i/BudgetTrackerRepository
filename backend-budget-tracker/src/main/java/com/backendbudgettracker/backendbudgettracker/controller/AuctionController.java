package com.backendbudgettracker.backendbudgettracker.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import com.backendbudgettracker.backendbudgettracker.entity.Auction;
import com.backendbudgettracker.backendbudgettracker.entity.Product;
import com.backendbudgettracker.backendbudgettracker.repository.AuctionRepository;
import com.backendbudgettracker.backendbudgettracker.repository.ProductRepository;
import com.backendbudgettracker.backendbudgettracker.security.JwtHelper;

@RestController
@RequestMapping("/auction")
@CrossOrigin
public class AuctionController {

    private AuctionRepository auctionRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private JwtHelper jwtHelper;

    public AuctionController(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    /*
     * returns all auctions
     * admin token only
     *
     * @GetMapping("/findAllOpen")
     * public List<Auction> indexOpen(HttpServletRequest request,
     * HttpServletResponse response) throws IOException {
     * if(jwtHelper.getAdminFromRequest(request)) {
     * return auctionRepository.findAll();
     * }
     * response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
     * return auctionRepository.findByStatusNot(Auction.Status.LOCKED);
     * }
     */

    /*
     * returns all auctions with status != LOCKED
     * admin token will receive all auctions
     */
    @GetMapping("")
    public List<Auction> index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Auction> auctions = auctionRepository.findAll(); // PAGINATION !!!
        for (Auction auction : auctions) {
            if (auction.getStatus() == Auction.Status.OPEN
                    && auction.getEndDate().before(new Timestamp(System.currentTimeMillis()))) {
                auction.setStatus(Auction.Status.CLOSED);
                auctionRepository.save(auction);
            }
        }
        if (jwtHelper.getAdminFromRequest(request)) {
            return auctions;
        }
        return auctionRepository.findByStatusNot(Auction.Status.LOCKED);
    }

    /*
     * returns auctions from the user
     */
    @GetMapping("/getMyAuctions")
    public List<Auction> getMyAuctions(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long userId = jwtHelper.getUserIdFromRequest(request);
        List<Auction> auctions = auctionRepository.findAll();
        List<Auction> tempAuctions = new ArrayList<Auction>();
        for (Auction auction : auctions) {
            if (auction.getStatus() == Auction.Status.OPEN
                    && auction.getEndDate().before(new Timestamp(System.currentTimeMillis()))) {
                auction.setStatus(Auction.Status.CLOSED);
                auctionRepository.save(auction);
            }
            if (auction.getUserId() == userId) {
                tempAuctions.add(auction);
            }
        }
        return tempAuctions;
    }

    /*
     * create auction
     * {
     * "title"
     * "startingPrice"
     * "minAmount"
     * "productId"
     * "deliveryDate"
     * "duration" in ms
     * }
     */
    @PostMapping("/create")
    public Auction create(@RequestBody Map<String, String> params, HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        if (params.get("title") == null || params.get("title").equals("")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Title is required");
            return null;
        }
        if (params.get("startingPrice") == null || params.get("startingPrice").equals("")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Starting price is required");
            return null;
        }
        if (params.get("minAmount") == null || params.get("minAmount").equals("")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Min amount is required");
            return null;
        }
        if (params.get("productId") == null || params.get("productId").equals("")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Product id is required");
            return null;
        }
        if (params.get("deliveryDate") == null || params.get("deliveryDate").equals("")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Delivery date is required");
            return null;
        }
        if (params.get("duration") == null || params.get("duration").equals("")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Duration is required");
            return null;
        }
        Auction auction = new Auction();
        auction.setUserId(jwtHelper.getUserIdFromRequest(request));
        auction.setTitle(params.get("title"));
        auction.setStartingPrice(Double.parseDouble(params.get("startingPrice")));
        auction.setMinAmount(Long.parseLong(params.get("minAmount")));
        auction.setProductId(Long.parseLong(params.get("productId")));
        auction.setDeliveryDate(Timestamp.valueOf(params.get("deliveryDate")));
        Timestamp endDate = new Timestamp(System.currentTimeMillis() + Long.parseLong(params.get("duration")));
        auction.setEndDate(endDate);
        Optional<Product> product = productRepository.findById(auction.getProductId());
        if (product.isPresent()) {
            auctionRepository.save(auction);
            return auction;
        }
        response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        return null;
    }

    /*
     * lock/unlock auction
     * admin token only
     * {
     * "auctionId"
     * "status": "OPEN", "CLOSED", "CONFIRMED" or "LOCKED"
     * }
     */
    @PostMapping("/lock")
    public Auction lock(@RequestBody Map<String, String> params, HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        if (jwtHelper.getAdminFromRequest(request)) {
            Long auctionIdParsed = Long.parseLong(params.get("auctionId"));
            Optional<Auction> auctionOptional = auctionRepository.findById(auctionIdParsed);
            if (auctionOptional.isPresent()) {
                auctionOptional.get().setStatus(Auction.Status.valueOf(params.get("status")));
                return auctionRepository.save(auctionOptional.get());
            }
        }
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        return null;
    }

    /*
     * update auction
     * {
     * "auctionId"
     * "title"
     * }
     */
    @PostMapping("/update")
    public Auction update(@RequestBody Map<String, String> params, HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        Long auctionIdParsed = Long.parseLong(params.get("auctionId"));
        Optional<Auction> auctionOptional = auctionRepository.findById(auctionIdParsed);
        if (auctionOptional.isPresent()) {
            Auction auction = auctionOptional.get();
            if (auction.getUserId() == jwtHelper.getUserIdFromRequest(request)) {
                auction.setTitle(params.get("title"));
                return auctionRepository.save(auction);
            }
        }
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        return null;
    }

    /*
     * update auction as admin
     * {
     * "auctionId"
     * "title"
     * }
     */
    @PostMapping("/updateAsAdmin")
    public Auction updateAsAdmin(@RequestBody Map<String, String> params, HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        if (jwtHelper.getAdminFromRequest(request)) {
            Long auctionIdParsed = Long.parseLong(params.get("auctionId"));
            Optional<Auction> auctionOptional = auctionRepository.findById(auctionIdParsed);
            if (auctionOptional.isPresent()) {
                Auction auction = auctionOptional.get();
                auction.setTitle(params.get("title"));
                return auctionRepository.save(auction);
            }
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        return null;
    }
}
