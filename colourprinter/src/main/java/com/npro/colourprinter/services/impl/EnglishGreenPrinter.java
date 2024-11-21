package com.npro.colourprinter.services.impl;

import com.npro.colourprinter.services.GreenPrinter;
import org.springframework.stereotype.Component;

@Component
public class EnglishGreenPrinter implements GreenPrinter {

    @Override
    public String print() {
        return "Green";
    }
}
