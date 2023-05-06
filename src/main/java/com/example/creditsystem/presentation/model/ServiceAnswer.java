package com.example.creditsystem.presentation.model;

public sealed interface ServiceAnswer {}
record Success<T>(T data) implements ServiceAnswer {}
record Error(String code, String message) implements ServiceAnswer {}