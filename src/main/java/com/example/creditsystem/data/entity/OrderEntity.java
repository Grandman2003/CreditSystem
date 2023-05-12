package com.example.creditsystem.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;

@Table(name = "loan_order")
public class OrderEntity {
    @Id
    long id;
    String orderId;
    long userId;
    long tariffId;
    double creditRating;
    String status;
    Timestamp timeInsert;
    Timestamp timeUpdate;
}
