package com.capita.demo.capita;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public final void test() {
		Calculator cal = new Calculator();
		double 
		
		ret = cal.evaluateExpression("4 * 5");
		assertEquals(20.0 + "", ret + "");

		ret = cal.evaluateExpression("4 + 5");
		assertEquals(9.0 + "", ret + "");
		
		ret = cal.evaluateExpression("40 / 5");
		assertEquals(8.0 + "", ret + "");

		ret = cal.evaluateExpression("4 - 5");
		assertEquals(-1.0 + "", ret + "");
	}

}
