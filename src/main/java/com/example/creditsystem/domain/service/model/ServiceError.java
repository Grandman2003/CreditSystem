package com.example.creditsystem.domain.service.model;

public enum ServiceError {
    ORDER_IMPOSSIBLE_TO_DELETE("Невозможно удалить заявку")
    ;
    private final String message;
    private final String code = getDeclaringClass().getSimpleName();

    ServiceError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
