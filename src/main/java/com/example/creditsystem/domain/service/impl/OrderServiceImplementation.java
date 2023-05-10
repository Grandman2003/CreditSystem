package com.example.creditsystem.domain.service.impl;

import com.example.creditsystem.domain.repository.OrderRepository;
import com.example.creditsystem.domain.service.OrderService;
import com.example.creditsystem.domain.service.model.ServiceAnswer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImplementation implements OrderService {

    private final OrderRepository orderRepository;
    @Override
    public ServiceAnswer makeOrder() {
        return null;
    }
}
