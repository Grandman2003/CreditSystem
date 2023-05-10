package com.example.creditsystem.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
public class TariffEntity {
    @Id
    String id;
    String type;
    String interestRate;

}
