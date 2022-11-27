package com.backendbudgettracker.backendbudgettracker.entity;

import java.sql.Timestamp;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity
@Data // Lombok - instead of Getters and Setters
public class Auction {

    public enum Status {
        OPEN, CLOSED, CONFIRMED, LOCKED;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String title;

    private Double startingPrice;

    private Long minAmount;

    private Long productId;

    private Timestamp deliveryDate;

    private Timestamp endDate;

    private Boolean bidden = false;

    private Status status = Status.OPEN;

}