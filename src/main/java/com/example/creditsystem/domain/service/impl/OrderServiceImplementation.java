package com.example.creditsystem.domain.service.impl;

import com.example.creditsystem.data.entity.OrderEntity;
import com.example.creditsystem.domain.repository.OrderRepository;
import com.example.creditsystem.domain.service.OrderService;
import com.example.creditsystem.domain.service.model.Order;
import com.example.creditsystem.domain.service.model.ServiceAnswer;
import com.example.creditsystem.domain.service.model.ServiceError;
import com.example.creditsystem.domain.service.model.Tariff;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImplementation implements OrderService {

    private final OrderRepository orderRepository;
    @Override
    public ServiceAnswer makeOrder(Tariff tariff) {
        val newOrder = OrderEntity
                .builder()
                .orderId(UUID.randomUUID().toString())
                .userId(tariff.userId())
                .tariffId(tariff.tariffId())
                .status(Order.Status.IN_PROGRESS.name())
                .timeInsert(new Timestamp(System.currentTimeMillis()))
                .timeUpdate(new Timestamp(System.currentTimeMillis()))
                .build();
        orderRepository.save(newOrder);
        return new ServiceAnswer.Success<>(new Order.OrderId(UUID.fromString(newOrder.getOrderId())));
    }

    @Override
    public ServiceAnswer getOrderByUuid(UUID uuid) {
        val order = orderRepository.findOrderEntityByOrderId(uuid.toString());
        if (order.isEmpty()) {
            return new ServiceAnswer.Error(ServiceError.ORDER_NOT_FOUND.getCode(), ServiceError.ORDER_NOT_FOUND.getMessage());
        } else {
            return new ServiceAnswer.Success<>(Order.Status.valueOf(order.get().getStatus()));
        }
    }

    @Override
    public ServiceAnswer deleteOrder(Order order) {
        val orderForDeletion = orderRepository.findOrderEntityByOrderId(order.orderId().toString());
        if(orderForDeletion.isEmpty()){
            return new ServiceAnswer.Error(ServiceError.ORDER_IMPOSSIBLE_TO_DELETE.getCode(), ServiceError.ORDER_IMPOSSIBLE_TO_DELETE.getMessage());
        } else {
            orderRepository.delete(orderForDeletion.get());
            return new ServiceAnswer.Success<>(null);
        }
    }
}
