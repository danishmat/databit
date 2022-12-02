package com.org.customer.exception;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ErrorMessage {
    private String errorMessage;
}
