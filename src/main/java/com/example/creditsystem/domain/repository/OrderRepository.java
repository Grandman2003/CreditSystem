package com.example.creditsystem.domain.repository;

import com.example.creditsystem.data.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {}
