package main;
import junit.framework.Assert;
import junit.framework.TestCase;
import main.impl.CalculatorImpl;

import org.junit.Test;

public class CalculatorTest extends TestCase{
	Calculator calculator = CalculatorFactory.newCalculator();	

	@Test
	public void testAddOneSizedString(){
		Assert.assertEquals("2", calculator.add("1","1"));
		Assert.assertEquals("10",calculator.add("5","5"));
	}
	
	@Test
	public void testAddTwoSizedString(){
		Assert.assertEquals("20", calculator.add("10","10"));
		Assert.assertEquals("30", calculator.add("15","15"));
	}
	
	@Test
	public void testAddDistinctSizesString(){
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
		Assert.assertEquals("0", calculator.subtract("1", "1"));
		Assert.assertEquals("-1", calculator.subtract("1", "2"));
		Assert.assertEquals("1", calculator.subtract("2", "1"));
		
		assertEquals("9223372036854775806", calculator.subtract("9223372036854775807", "1"));
		assertEquals("999999999999999999", calculator.subtract("1000000000000000000", "1"));
	}
	
	@Test
	public void testCompare(){
		assertEquals(0,calculator.compare("1","1"));
		assertEquals(-1,calculator.compare("1","2"));
		assertEquals(1,calculator.compare("2","1"));
		
		assertEquals(0,calculator.compare("-1","-1"));
		assertEquals(1,calculator.compare("-1","-2"));
		assertEquals(-1,calculator.compare("-2","-1"));
		assertEquals(-1,calculator.compare("-28908","98797"));
	}
	
	
}
