package com.example.user.api.dto;

public record GenericResponseWithoutBody<T>(int status, String message) {
}
