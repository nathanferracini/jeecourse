package main;

import main.impl.CalculatorImpl;

public class CalculatorFactory {

	public static Calculator newCalculator(){
		return new CalculatorImpl();
	}
	
}
