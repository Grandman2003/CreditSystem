package com.example.creditsystem.domain.service.model;

import java.util.UUID;
public record Order(long userId, UUID orderId) {
    public enum Status {
        IN_PROGRESS, APPROVED, REFUSED;
    }
    public record OrderId(UUID orderId){}
    public record OrderStatus(Status orderStatus){}
}
