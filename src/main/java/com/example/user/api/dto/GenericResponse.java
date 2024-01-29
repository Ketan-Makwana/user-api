package com.example.user.api.dto;

public record GenericResponse<T>(int status, String message, T data) {
}
