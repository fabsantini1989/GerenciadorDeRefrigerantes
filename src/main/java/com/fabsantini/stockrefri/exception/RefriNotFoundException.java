package com.fabsantini.stockrefri.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class RefriNotFoundException extends Exception {

    public RefriNotFoundException(String refriName) {
        super(String.format("Refri with name %s not found in the system.", refriName));
    }

    public RefriNotFoundException(Long id) {
        super(String.format("Refri with id %s not found in the system.", id));
    }
}

