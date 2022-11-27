package com.backendbudgettracker.backendbudgettracker.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.GenerationType;

@Entity
@Data // Lombok - instead of Getters and Setters
public class Image {

    public enum Type {
        PRODUCT, USER;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Type type;

    private Long externalId;

    private String imgUrl;

    @Lob
    @Column
    private String imgData;

}