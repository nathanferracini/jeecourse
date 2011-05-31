package main.impl;

import main.Calculator;
import main.HugeNumber;

public class CalculatorImpl implements Calculator {
	
	private HugeNumber leftHugeNumber;
	private HugeNumber rightHugeNumber;
	private String finalResult;

	@Override
	public String add(String left, String right) {
		leftHugeNumber = new HugeNumber(left);
		rightHugeNumber = new HugeNumber(right);
		finalResult = "";
		int currentRest = 0;
		
		while(leftHugeNumber.hasNext() || rightHugeNumber.hasNext()){
			Integer partialResult = nextInteger(leftHugeNumber) + nextInteger(rightHugeNumber) + currentRest;
			finalResult = Integer.toString(partialResult%10).concat(finalResult);
			currentRest = partialResult / 10;
		}
		finalResult = addRestToResult(currentRest, finalResult);
		
		return finalResult;
	}

	private String addRestToResult(int currentRest, String addResult) {
		return currentRest == 0 
			? addResult 
			: Integer.toString(currentRest).concat(addResult);  
	}

	private Integer nextInteger(HugeNumber hugeNumber){
		return hugeNumber.hasNext() ? hugeNumber.nextInteger() : 0;
	}
	
	@Override
	public String subtract(String left, String right) {
		leftHugeNumber = new HugeNumber(left);
		rightHugeNumber = new HugeNumber(right);
		finalResult = "";
		
		while(leftHugeNumber.hasNext() || rightHugeNumber.hasNext()){
			Integer partialResult = nextInteger(leftHugeNumber) - nextInteger(rightHugeNumber);
			finalResult = Integer.toString(partialResult%10).concat(finalResult);
		}
		
		finalResult = justifyRight(finalResult);
		
		return finalResult;
	}

	private String justifyRight(String finalResult2) {
//		while ()
		return null;
	}
	
}
