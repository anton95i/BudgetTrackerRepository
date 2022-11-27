package com.backendbudgettracker.backendbudgettracker.repository;

import com.backendbudgettracker.backendbudgettracker.entity.Auction;
import com.backendbudgettracker.backendbudgettracker.entity.Auction.Status;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepository extends JpaRepository<Auction, Long> {

    List<Auction> findByStatusNot(Status locked);

}