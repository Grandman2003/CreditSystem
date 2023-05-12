package com.example.creditsystem.domain.repository;

import com.example.creditsystem.data.entity.OrderEntity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

    @Query("SELECT * FROM loan_order WHERE order_id = :order_id")
    Optional<OrderEntity> findOrderEntityByOrderId(@Param("order_id") String orderId);

}
