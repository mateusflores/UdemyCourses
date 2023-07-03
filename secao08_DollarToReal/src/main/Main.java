package main;

import java.util.Scanner;

import util.CurrencyConverter;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("What is the dollar price? ");
		double dollarPrice = scn.nextDouble();
		System.out.println("How many dollars will be bought? ");
		double dollarQuant = scn.nextDouble();
		
		System.out.printf("Amount to be paid in Reais: R$ %.2f", CurrencyConverter.converter(dollarPrice, dollarQuant));
		
		scn.close();
	}

}
