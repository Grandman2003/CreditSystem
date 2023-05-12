package com.example.creditsystem.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
