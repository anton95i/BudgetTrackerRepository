package com.backendbudgettracker.backendbudgettracker.entity;

import java.sql.Timestamp;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity
@Data // Lombok - instead of Getters and Setters
public class IncomeAndExpenses {

    public enum Type {
        INCOME, EXPENSE;
    }

    public enum Category {
        FOOD, CLOTHES, ENTERTAINMENT, HOUSING, TRANSPORTATION, HEALTH, EDUCATION, SAVINGS, SALARY, OTHER;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String title;

    private Double amount;

    private Timestamp date;

    private Boolean abo = false;

    private Integer aboInterval;

    private Category category;

    private Type type;

}