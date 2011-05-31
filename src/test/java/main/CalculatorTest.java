package main;
import junit.framework.Assert;
import junit.framework.TestCase;
import main.impl.CalculatorImpl;

import org.junit.Test;

public class CalculatorTest extends TestCase{

	@Test
	public void testAddOneSizedString(){
		Calculator calculator = new CalculatorImpl();	
		Assert.assertEquals("2", calculator.add("1","1"));
		Assert.assertEquals("10",calculator.add("5","5"));
	}
	
	@Test
	public void testAddTwoSizedString(){
		Calculator calculator = new CalculatorImpl();	
		Assert.assertEquals("20", calculator.add("10","10"));
		Assert.assertEquals("30", calculator.add("15","15"));
	}
	
	@Test
	public void testAddDistinctSizesString(){
		Calculator calculator = new CalculatorImpl();	
		Assert.assertEquals("15", calculator.add("10","5"));
		Assert.assertEquals("15", calculator.add("5","10"));
	}
	
	@Test
	public void testAddBigSizesString(){
		Calculator calculator = new CalculatorImpl();	
		Assert.assertEquals("9223372036854775808", calculator.add("9223372036854775807", "1"));
		Assert.assertEquals("18446744073709551616", 
				calculator.add("9223372036854775808","9223372036854775808"));
		
	}
	
	@Test
	public void testSubtractOneSizedString(){
		Calculator calculator = new CalculatorImpl();	
		Assert.assertEquals("0", calculator.subtract("1", "1"));
		Assert.assertEquals("4", calculator.subtract("9", "5"));
		Assert.assertEquals("-4", calculator.subtract("5", "9"));
	}
	
	@Test 
	public void subtractTwoSizadString(){
		Calculator calculator = new CalculatorImpl();	
		Assert.assertEquals("0", calculator.subtract("12", "12"));
		Assert.assertEquals("11", calculator.subtract("22", "11"));
	}
	
	
}
