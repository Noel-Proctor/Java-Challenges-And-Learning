package com.npro.colourprinter.services.impl;

import com.npro.colourprinter.services.BluePrinter;
import org.springframework.stereotype.Component;

@Component
public class EnglishBluePrinter implements BluePrinter {

    @Override
    public String print(){
        return "Blue";
    }
}
