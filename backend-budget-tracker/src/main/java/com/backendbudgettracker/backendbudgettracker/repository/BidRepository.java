package com.backendbudgettracker.backendbudgettracker.repository;

import com.backendbudgettracker.backendbudgettracker.entity.Bid;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid, Long> {

    List<Bid> findAllByAuctionId(Long auctionId);

}