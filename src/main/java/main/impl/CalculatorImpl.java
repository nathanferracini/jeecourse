package main.impl;

import main.Calculator;

public class CalculatorImpl implements Calculator {

	@Override
	public String add(String left, String right) {
		int currentNumberLeft;
		int currentNumberRight;
		int currentRest = 0;
		String addResult = "";
		String biggest = left.length() > right.length() ? left : right ;
		String smallest = left.length() <= right.length() ? left : right ;
		int countSmallestNumber = smallest.length();
		
		for(int i = biggest.length()-1; i>=0; i--){
			if(--countSmallestNumber >= 0 ){
				currentNumberRight = intAt(smallest,countSmallestNumber);
			}else{ currentNumberRight = 0;}
			currentNumberLeft = intAt(biggest,i);
			Integer partialResult = currentNumberLeft + currentNumberRight + currentRest;
			addResult = Integer.toString(partialResult%10).concat(addResult);
			currentRest = partialResult / 10;
		}
		addResult = addRestToResult(currentRest, addResult);
		
		return addResult;
	}

	private String addRestToResult(int currentRest, String addResult) {
		return currentRest == 0 
			? addResult 
			: Integer.toString(currentRest).concat(addResult);  
	}

	private Integer intAt(String string, int posicao){
		return Integer.parseInt(string.substring(posicao, posicao+1));
	}
	
	public static void main(String[] args) {
		System.out.println(Long.MAX_VALUE);
	}

	@Override
	public String subtract(String left, String right) {
		// TODO Auto-generated method stub
		return "0";
	}
	
}
