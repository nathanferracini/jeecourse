package main;

import java.util.Scanner;

public class ConsoleApp {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] inputEntries;
		String leftNumber;
		String operator;
		String rightNumber;
		Calculator calculator = CalculatorFactory.newCalculator();
		while(true){
			inputEntries = in.nextLine().split(" ");
			if(inputEntries[0].equals("exit")){
				System.out.println("Programa terminado");
				break;
			}
			if(inputEntries.length != 3){
				System.out.println("Erro - Comando Inválido");
				continue;
			}
			leftNumber = inputEntries[0];
			operator = inputEntries[1];
			rightNumber = inputEntries[2];
			if (operator.equals("+")){ 
				System.out.println("resultado = " + calculator.add(leftNumber, rightNumber));
				continue;
			}
			if(operator.equals("-")){
				System.out.println("resultado = " + calculator.subtract(leftNumber, rightNumber));
				continue;
			}
			if(operator.equals("=")){
				System.out.println("resultado = " + calculator.compare(leftNumber, rightNumber));
				continue;
			}
			System.out.println("Erro - Operador " + operator +  " Inválido");
		}
		in.close();
	}

}
