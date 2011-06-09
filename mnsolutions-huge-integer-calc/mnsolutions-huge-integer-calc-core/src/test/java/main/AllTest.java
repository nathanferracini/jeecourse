package main;

import junit.framework.Test;
import junit.framework.TestSuite;


public class AllTest extends TestSuite {
	
	 static public Test suite() {
		    TestSuite suite = new TestSuite();
		    suite.addTestSuite(CalculatorTest.class);
		    suite.addTestSuite(HugeNumberTest.class);
		    return suite;
	 }

}
