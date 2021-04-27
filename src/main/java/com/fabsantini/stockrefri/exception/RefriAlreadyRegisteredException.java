package com.fabsantini.stockrefri.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RefriAlreadyRegisteredException extends Exception {

    public RefriAlreadyRegisteredException(String refriName) {
        super(String.format("Refri with name %s already registered in the system.", refriName));
    }
}
