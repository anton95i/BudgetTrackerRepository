package com.backendbudgettracker.backendbudgettracker.controller;

import java.io.IOException;
import java.sql.Timestamp;
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
import com.backendbudgettracker.backendbudgettracker.entity.Bid;
import com.backendbudgettracker.backendbudgettracker.repository.AuctionRepository;
import com.backendbudgettracker.backendbudgettracker.repository.BidRepository;
import com.backendbudgettracker.backendbudgettracker.security.JwtHelper;

@RestController
@RequestMapping("/bid")
@CrossOrigin
public class BidController {

    private BidRepository bidRepository;

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private JwtHelper jwtHelper;

    public BidController(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    @GetMapping("")
    public List<Bid> findAll() {
        return bidRepository.findAll();
    }

    /*
     * returns all bids
     * {
     * "auctionId"
     * }
     */
    @PostMapping("/findByAuctionId")
    public List<Bid> findByAuctionId(@RequestBody Map<String, String> params, HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        List<Bid> bids = bidRepository.findAllByAuctionId(Long.parseLong(params.get("auctionId")));
        if (bids == null || bids.isEmpty()) {
            response.sendError(404, "No bids found");
        }
        return bids;
    }

    /*
     * create Bid
     * {
     * "auctionId"
     * "price"
     * "amount"
     * "deliveryDate"
     * }
     */
    @PostMapping("/create")
    public Bid create(@RequestBody Map<String, String> params, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Long auctionId = Long.parseLong(params.get("auctionId"));
        Long userId = jwtHelper.getUserIdFromRequest(request);
        Double price = Double.parseDouble(params.get("price"));
        Long amount = Long.parseLong(params.get("amount"));
        Timestamp deliveryDate = Timestamp.valueOf(params.get("deliveryDate"));
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Optional<Auction> auctionOptional = auctionRepository.findById(auctionId);
        if (!auctionOptional.isPresent()) {
            response.sendError(404, "Auction not found");
            return null;
        }
        Auction auction = auctionOptional.get();
        if (auction.getStatus() != Auction.Status.OPEN) {
            response.sendError(400, "Auction is not open");
            return null;
        }
        if (auction.getUserId() == userId) {
            response.sendError(400, "You can't bid on your own auction");
            return null;
        }
        if (auction.getStartingPrice() < price) {
            response.sendError(400, "Price is too high");
            return null;
        }
        if (auction.getDeliveryDate().before(deliveryDate)) {
            response.sendError(400, "Delivery date is too late");
            return null;
        }
        if (auction.getMinAmount() > amount) {
            response.sendError(400, "Amount is too low");
            return null;
        }
        if (auction.getEndDate().before(timestamp)) {
            response.sendError(400, "Auction is over");
            return null;
        }

        Timestamp fiveMinutesBeforeAuctionEnd = new Timestamp(auction.getEndDate().getTime() - 5 * 60 * 1000);
        if (fiveMinutesBeforeAuctionEnd.before(timestamp)) {
            auction.setEndDate(new Timestamp(timestamp.getTime() + 5 * 60 * 1000));
            auctionRepository.save(auction);
        }

        Bid bid = new Bid();
        bid.setAuctionId(auctionId);
        bid.setUserId(userId);
        bid.setPrice(price);
        bid.setAmount(amount);
        bid.setDeliveryDate(deliveryDate);
        bid.setTimestamp(timestamp);

        auction.setBidden(true);
        auctionRepository.save(auction);
        return bidRepository.save(bid);
    }

    // accept bid
    /*
     * {
     * "bidId"
     * }
     */
    @PostMapping("/accept")
    public void accept(@RequestBody Map<String, String> params, HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        Long userId = jwtHelper.getUserIdFromRequest(request);
        Long bidId = Long.parseLong(params.get("bidId"));

        Optional<Bid> bid = bidRepository.findById(bidId);
        if (!bid.isPresent()) {
            response.sendError(404, "Bid not found");
            return;
        }
        Bid bidEntity = bid.get();
        bidEntity.setConfirmed(true);

        Optional<Auction> auction = auctionRepository.findById(bidEntity.getAuctionId());
        if (!auction.isPresent()) {
            response.sendError(404, "Auction not found");
            return;
        }
        Auction auctionEntity = auction.get();
        auctionEntity.setStatus(Auction.Status.CONFIRMED);

        if (auctionEntity.getStatus() != Auction.Status.OPEN && auctionEntity.getStatus() != Auction.Status.CONFIRMED
                && auctionEntity.getStatus() != Auction.Status.LOCKED) {
            response.sendError(400, "Auction is ready to be finished");
            return;
        }
        if (auctionEntity.getUserId() != userId) {
            response.sendError(400, "You are not the owner of this auction");
            return;
        }

        bidRepository.save(bidEntity);
        auctionRepository.save(auctionEntity);

        response.setStatus(200);
    }
}