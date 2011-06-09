package main;

import junit.framework.TestCase;
import main.impl.HugeNumber;

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
	
	@Test
	public void testCompareToWithoutSignal(){
		HugeNumber hugeNumber = new HugeNumber("1");
		HugeNumber hugeNumber2 = new HugeNumber("2");
		assertEquals(-1,hugeNumber.compareToWithoutSignal(hugeNumber2));
		assertEquals(1,hugeNumber2.compareToWithoutSignal(hugeNumber));
		
		hugeNumber = new HugeNumber("-1");
		hugeNumber2 = new HugeNumber("-2");
		assertEquals(-1,hugeNumber.compareToWithoutSignal(hugeNumber2));
		assertEquals(1,hugeNumber2.compareToWithoutSignal(hugeNumber));
		
		hugeNumber = new HugeNumber("85");
		hugeNumber2 = new HugeNumber("-10");
		assertEquals(1,hugeNumber.compareToWithoutSignal(hugeNumber2));
		assertEquals(-1,hugeNumber2.compareToWithoutSignal(hugeNumber));
		
		hugeNumber = new HugeNumber("45");
		hugeNumber2 = new HugeNumber("-90");
		assertEquals(-1,hugeNumber.compareToWithoutSignal(hugeNumber2));
		assertEquals(1,hugeNumber2.compareToWithoutSignal(hugeNumber));
		
		hugeNumber = new HugeNumber("-10");
		hugeNumber2 = new HugeNumber("10");
		assertEquals(0,hugeNumber.compareToWithoutSignal(hugeNumber2));
		assertEquals(0,hugeNumber2.compareToWithoutSignal(hugeNumber));
		
	}
	
	@Test
	public void testCompareTo(){
		HugeNumber hugeNumber = new HugeNumber("1");
		HugeNumber hugeNumber2 = new HugeNumber("2");
		assertEquals(-1,hugeNumber.compareTo(hugeNumber2));
		assertEquals(1,hugeNumber2.compareTo(hugeNumber));
		
		hugeNumber = new HugeNumber("1");
		hugeNumber2 = new HugeNumber("-1");
		assertEquals(1,hugeNumber.compareTo(hugeNumber2));
		assertEquals(-1,hugeNumber2.compareTo(hugeNumber));
		
		hugeNumber = new HugeNumber("-1");
		hugeNumber2 = new HugeNumber("-1");
		assertEquals(0,hugeNumber.compareTo(hugeNumber2));
		
		hugeNumber = new HugeNumber("-10");
		hugeNumber2 = new HugeNumber("-1");
		assertEquals(-1,hugeNumber.compareTo(hugeNumber2));
		assertEquals(1,hugeNumber2.compareTo(hugeNumber));
	}
	
}