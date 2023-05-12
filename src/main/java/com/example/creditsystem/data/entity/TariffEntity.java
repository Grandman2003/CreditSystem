package com.example.creditsystem.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "tariff")
public class TariffEntity {
    @Id
    long id;
    String type;
    String interestRate;

}
