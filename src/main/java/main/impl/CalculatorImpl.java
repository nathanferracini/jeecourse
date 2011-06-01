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
		//It's going to disappear when we start to support signals
		boolean flagSwitch = false;
		
		leftHugeNumber = new HugeNumber(left);
		rightHugeNumber = new HugeNumber(right);
		finalResult = new HugeNumber();
		if(needToSwitchNumbers(leftHugeNumber,rightHugeNumber)){
			leftHugeNumber = new HugeNumber(right);
			rightHugeNumber = new HugeNumber(left);
			flagSwitch = true;
		}
		int penality = 0;
		
		while(leftHugeNumber.hasNext() || rightHugeNumber.hasNext()){
			int currentLeft = nextInteger(leftHugeNumber) - penality;
			int currentRight = nextInteger(rightHugeNumber);
			
			if (currentLeft < currentRight) {
				if(currentLeft < 0) currentLeft = 9;
				else currentLeft += 10;
				penality = 1;
			}else{
				penality = 0;
			}
			Integer partialResult = currentLeft - currentRight;
			finalResult.concatLeft(partialResult); 
		}
		finalResult.justifyRight();
		if(flagSwitch)finalResult.concatLeft("-");
		return finalResult.toString();
	}

	private boolean needToSwitchNumbers(HugeNumber leftHugeNumber,
			HugeNumber rightHugeNumber) {
		return leftHugeNumber.compareTo(rightHugeNumber) == -1;
	}

	@Override
	public int compare(String left, String right) {
		return new HugeNumber(left).compareTo(new HugeNumber(right));
	}
	
	public static void main(String[] args) {
		new CalculatorImpl().subtract("1", "1");
	}
	
}
