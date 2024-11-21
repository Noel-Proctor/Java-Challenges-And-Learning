package com.npro.colourprinter.services.impl;

import com.npro.colourprinter.services.RedPrinter;
import org.springframework.stereotype.Component;

@Component
public class EnglishRedPrinter implements RedPrinter {

    @Override
    public String print() {
        return "Red";
    }
}
