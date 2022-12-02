package com.org.customer.model;

public record CustomerRegistrationRequest(
        String userName,
        String firstName,
        String lastName,
        String email) {
}
