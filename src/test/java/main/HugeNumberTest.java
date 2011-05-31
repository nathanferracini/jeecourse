package main;

import junit.framework.TestCase;

import org.junit.Test;

public class HugeNumberTest extends TestCase {

	@Test
	public void testConstructor(){
		HugeNumber hugeNumber = new HugeNumber("1");	
		assertEquals(1, hugeNumber.getIndex() );
		assertEquals("1", hugeNumber.getNumber() );
	}
	
	@Test
	public void testNextInteger(){
		HugeNumber hugeNumber = new HugeNumber("1");
		assertEquals(Integer.valueOf(1), hugeNumber.nextInteger());
		
		hugeNumber = new HugeNumber("21");
		assertEquals(Integer.valueOf(1), hugeNumber.nextInteger());
		assertEquals(Integer.valueOf(2), hugeNumber.nextInteger());
		
		hugeNumber = new HugeNumber("21");
		assertEquals(Integer.valueOf(1), hugeNumber.nextInteger());
		assertEquals(Integer.valueOf(2), hugeNumber.nextInteger());
		assertEquals(null, hugeNumber.nextInteger());
		assertEquals(null, hugeNumber.nextInteger());
	}
	
	@Test
	public void testHasNext(){
		HugeNumber hugeNumber = new HugeNumber("1");
		assertTrue(hugeNumber.hasNext());
		hugeNumber.nextInteger();
		assertFalse(hugeNumber.hasNext());
	}
	
	@Test
	public void testConcatLeft(){
		HugeNumber hugeNumber = new HugeNumber();
		hugeNumber.concatLeft("1");
		assertEquals("1",hugeNumber.getNumber());
		hugeNumber.concatLeft(2);
		assertEquals("21",hugeNumber.getNumber());
	}
	
	@Test
	public void testJustifyRight(){
		HugeNumber hugeNumber = new HugeNumber("1");
		assertEquals("1",hugeNumber.justifyRight());

		hugeNumber =  new HugeNumber("01");
		assertEquals("1",hugeNumber.justifyRight());
		
		hugeNumber =  new HugeNumber("001");
		assertEquals("1",hugeNumber.justifyRight());

		hugeNumber = new HugeNumber("0");
		assertEquals("0",hugeNumber.justifyRight());
	}
	
	@Test
	public void testIsNegative(){
		HugeNumber hugeNumber = new HugeNumber("-1");
		assertTrue(hugeNumber.isNegative());
		
		hugeNumber = new HugeNumber("-9586");
		assertTrue(hugeNumber.isNegative());
		
		hugeNumber = new HugeNumber("1");
		assertFalse(hugeNumber.isNegative());
		
		hugeNumber = new HugeNumber("25");
		assertFalse(hugeNumber.isNegative());
		
	}
	
	
}