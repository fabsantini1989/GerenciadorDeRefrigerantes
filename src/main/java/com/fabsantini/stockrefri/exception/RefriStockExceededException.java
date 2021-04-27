package com.fabsantini.stockrefri.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RefriStockExceededException {

    public RefriStockExceededException(Long id, int quantityToIncrement) {
        super(String.format("Refrigerant with %s ID to increment informed exceeds the max stock capacity: %s", id, quantityToIncrement));
    }
}