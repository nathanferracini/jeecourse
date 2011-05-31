package main.impl;

import main.Calculator;
import main.HugeNumber;

public class CalculatorImpl implements Calculator {
	
	private HugeNumber leftHugeNumber;
	private HugeNumber rightHugeNumber;
	private HugeNumber finalResult;

	@Override
	public String add(String left, String right) {
		leftHugeNumber = new HugeNumber(left);
		rightHugeNumber = new HugeNumber(right);
		finalResult = new HugeNumber();
		int currentRest = 0;
		
		while(leftHugeNumber.hasNext() || rightHugeNumber.hasNext()){
			Integer partialResult = nextInteger(leftHugeNumber) + nextInteger(rightHugeNumber) + currentRest;
			finalResult.concatLeft(partialResult%10);
			currentRest = partialResult / 10;
		}
		finalResult.concatLeft(currentRest);
		
		return finalResult.justifyRight();
	}

	private Integer nextInteger(HugeNumber hugeNumber){
		return hugeNumber.hasNext() ? hugeNumber.nextInteger() : 0;
	}
	
	@Override
	public String subtract(String left, String right) {
		leftHugeNumber = new HugeNumber(left);
		rightHugeNumber = new HugeNumber(right);
		finalResult = new HugeNumber();
		
		while(leftHugeNumber.hasNext() || rightHugeNumber.hasNext()){
			Integer partialResult = nextInteger(leftHugeNumber) - nextInteger(rightHugeNumber);
			finalResult.concatLeft(partialResult%10); 
		}
		
		return finalResult.justifyRight();
	}
	
}
