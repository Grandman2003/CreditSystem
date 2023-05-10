package com.example.creditsystem.domain.service.model;

public sealed interface ServiceAnswer {
    record Success<T>(T data) implements ServiceAnswer {}
    record Error(String code, String message) implements ServiceAnswer {}
}

