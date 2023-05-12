package com.example.creditsystem.domain.service;

import com.example.creditsystem.domain.service.model.Order;
import com.example.creditsystem.domain.service.model.ServiceAnswer;
import com.example.creditsystem.domain.service.model.Tariff;

import java.util.UUID;

public interface OrderService {
    ServiceAnswer makeOrder(Tariff tariff);
    ServiceAnswer getOrderByUuid(UUID uuid);
    ServiceAnswer deleteOrder(Order order);
}
