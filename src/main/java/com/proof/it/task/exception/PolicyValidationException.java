package com.proof.it.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class PolicyValidationException extends RuntimeException {

    public PolicyValidationException(String message) {
        super(message);
    }
}
