package main;

import junit.framework.Assert;

import org.junit.Test;

public class HugeNumberTest {

	@Test
	public void testConstructor(){
		HugeNumber hugeNumber = new HugeNumber("1");	
		Assert.assertEquals(1, hugeNumber.getIndex() );
		Assert.assertEquals("1", hugeNumber.getNumber() );
	}
	
	@Test
	public void testNextInteger(){
		HugeNumber hugeNumber = new HugeNumber("1");
		Assert.assertEquals(Integer.valueOf(1), hugeNumber.nextInteger());
		
		hugeNumber = new HugeNumber("21");
		Assert.assertEquals(Integer.valueOf(1), hugeNumber.nextInteger());
		Assert.assertEquals(Integer.valueOf(2), hugeNumber.nextInteger());
		
		hugeNumber = new HugeNumber("21");
		Assert.assertEquals(Integer.valueOf(1), hugeNumber.nextInteger());
		Assert.assertEquals(Integer.valueOf(2), hugeNumber.nextInteger());
		Assert.assertEquals(null, hugeNumber.nextInteger());
		Assert.assertEquals(null, hugeNumber.nextInteger());
	}
	
	@Test
	public void testHasNext(){
		HugeNumber hugeNumber = new HugeNumber("1");
		Assert.assertTrue(hugeNumber.hasNext());
		hugeNumber.nextInteger();
		Assert.assertFalse(hugeNumber.hasNext());
	}
	
	@Test
	public void concatLeft(){
		HugeNumber hugeNumber = new HugeNumber();
		hugeNumber.concatLeft("1");
		Assert.assertEquals("1",hugeNumber.getNumber());
		hugeNumber.concatLeft(2);
		Assert.assertEquals("21",hugeNumber.getNumber());
	}
	
	@Test
	public void justifyRight(){
		HugeNumber hugeNumber = new HugeNumber("1");
		Assert.assertEquals("1",hugeNumber.justifyRight());

		hugeNumber =  new HugeNumber("01");
		Assert.assertEquals("1",hugeNumber.justifyRight());
		
		hugeNumber =  new HugeNumber("001");
		Assert.assertEquals("1",hugeNumber.justifyRight());

		hugeNumber = new HugeNumber("0");
		Assert.assertEquals("0",hugeNumber.justifyRight());
	}
	
}