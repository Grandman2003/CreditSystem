package com.example.creditsystem.data.entity;

import org.springframework.data.annotation.Id;

public class TariffEntity {
    @Id
    String id;
    String type;
    String interestRate;

}
