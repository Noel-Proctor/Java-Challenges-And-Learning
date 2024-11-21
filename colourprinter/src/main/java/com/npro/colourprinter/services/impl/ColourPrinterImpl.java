package com.npro.colourprinter.services.impl;

import com.npro.colourprinter.services.BluePrinter;
import com.npro.colourprinter.services.ColourPrinter;
import com.npro.colourprinter.services.GreenPrinter;
import com.npro.colourprinter.services.RedPrinter;
import org.springframework.stereotype.Component;

@Component
public class ColourPrinterImpl implements ColourPrinter {


    private RedPrinter redPrinter;
    private BluePrinter bluePrinter;
    private GreenPrinter greenPrinter;


    public ColourPrinterImpl(RedPrinter redPrinter, BluePrinter bluePrinter, GreenPrinter greenPrinter){
        this.bluePrinter = bluePrinter;
        this.redPrinter = redPrinter;
        this.greenPrinter = greenPrinter;
    }

    public String print(){
        return String.join(", ", redPrinter.print(), bluePrinter.print(), greenPrinter.print());
    }
}
