package com.backendbudgettracker.backendbudgettracker.entity;

import java.sql.Timestamp;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity
@Data // Lombok - instead of Getters and Setters
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long auctionId;

    private Long userId;

    private Double price;

    private Long amount;

    private Timestamp deliveryDate;

    private Timestamp timestamp;

    private Boolean confirmed = false;

}