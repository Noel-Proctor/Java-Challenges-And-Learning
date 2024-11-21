package com.npro.colourprinter;

import com.npro.colourprinter.services.ColourPrinter;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log

public class ColourPrinterApplication implements CommandLineRunner {

	private ColourPrinter colourPrinter;

	public ColourPrinterApplication(ColourPrinter colourPrinter){
		this.colourPrinter=colourPrinter;
	}


	public static void main(String[] args) {
		SpringApplication.run(ColourPrinterApplication.class, args);
	}


	public void run(final String... args) {
		log.info(colourPrinter.print());

	}
}
