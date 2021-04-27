package com.fabsantini.stockrefri.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class RefriType {

    COCACOLA("Coca-Cola"),
    Dolly("Dolly"),
    FANTA("Fanta"),
    ITUBAINA("Tubaína"),
    CONVENCAO("Convenção"),
    KWAT("Kawt"),
    VEDETE("Vedete");

    private final String description;
}
