package main;

public class HugeNumber {
	
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
		return number.substring(i);
	}
	                         
	public String getNumber() {
		return number;
	}
	
	public int getIndex() {
		return index;
	}

	public boolean isNegative() {
		int i;
		for(i = 0; i < number.length() - 1; i++){
			if(number.charAt(i) == '-')	return true;
		}
		return false;
	}

}
