package main;

public class HugeNumber implements Comparable<HugeNumber>{
	
	private String number;
	private int index;
	
	public HugeNumber(){
		number = new String();
		index = number.length();
	}
	
	public HugeNumber(String number){
		this.number = number;
		index = number.length();
	}
	
	public Integer nextInteger() {
		return --index < 0  
			? null  
			: Integer.parseInt(getNumber().substring(index, index + 1));
	}

	public boolean hasNext() {
		return getIndex() > 0;
	}

	public void concatLeft(String string) {
		number = string.concat(number);
	}
	
	public void concatLeft(Integer integer){
		concatLeft(integer.toString());
	}
	
	public String justifyRight(){
		int i;
		for(i = 0; i < number.length() - 1; i++){
			if(number.charAt(i) != '0')	break;
		}
		number = number.substring(i);
		return getNumber();
	}
	                         
	public String getNumber() {
		return number;
	}
	
	public int getIndex() {
		return index;
	}

	public boolean isNegative() {
		return number.charAt(0) == '-';
	}
	
	public boolean isPositive(){
		return !isNegative();
	}

	@Override
	public int compareTo(HugeNumber hugeNumber) {
		if(isPositive() && hugeNumber.isPositive()) return compareToWithoutSignal(hugeNumber);
		if(isPositive() && hugeNumber.isNegative()) return 1;
		if(isNegative() && hugeNumber.isPositive()) return -1;
		if(isNegative() && hugeNumber.isNegative()) return compareToWithoutSignal(hugeNumber) * -1;
		throw new RuntimeException("Jesus");
	}
	
	public int compareToWithoutSignal(HugeNumber hugeNumber){
		String thisNumber = absoluteValue();
		String anotherNumber = hugeNumber.absoluteValue();
		if(thisNumber.length() > anotherNumber.length()) return 1;
		if(thisNumber.length() < anotherNumber.length()) return -1;
		return compareNumberANumber(thisNumber, anotherNumber);
	}

	private int compareNumberANumber(String thisNumber, String anotherNumber) {
		for(int i=0; i < thisNumber.length(); i++){
			if(thisNumber.charAt(i) == anotherNumber.charAt(i))
				continue;
			return Integer.signum(Character.valueOf(thisNumber.charAt(i)).compareTo(anotherNumber.charAt(i)));
		}
		return 0;
	}
	
	public String absoluteValue(){
		return removeSignal(justifyRight());
	}
	
	private String removeSignal(String number) {
		return number.charAt(0) == '-' ? number.substring(1): number;
	}
	
	@Override
	public String toString() {
		return getNumber();
	}

}
