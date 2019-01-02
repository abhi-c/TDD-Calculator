package com.capita.demo.capita;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public final void basicTest() {
		Calculator cal = new Calculator();
		String 
		
		ret = cal.convertToPostFixExpression("4 * 5");
		assertEquals("[4, 5, *]", ret);

		ret = cal.convertToPostFixExpression("4 + 5");
		assertEquals("[4, 5, +]", ret);
		
		ret = cal.convertToPostFixExpression("40 / 50");
		assertEquals("[40, 50, /]", ret);

		ret = cal.convertToPostFixExpression("4 - 5");
		assertEquals("[4, 5, -]", ret);
	}
	
	@Test
	public final void multiOperatorTest() {
		Calculator cal = new Calculator();
		String 
		
		ret = cal.convertToPostFixExpression("4 * 5 + 75 - 35");
		assertEquals("[4, 5, *, 75, +, 35, -]", ret);
		ret = cal.resolveExpression();
		assertEquals("60.0", ret);

		ret = cal.convertToPostFixExpression("4 + 5 * 1");
		assertEquals("[4, 5, 1, *, +]", ret);
		ret = cal.resolveExpression();
		assertEquals("9.0", ret);
		
		ret = cal.convertToPostFixExpression("20 - 40 / 4 + 1");
		assertEquals("[20, 40, 4, /, -, 1, +]", ret);
		ret = cal.resolveExpression();
		assertEquals("11.0", ret);

		ret = cal.convertToPostFixExpression("5 * 60 / 2");
		assertEquals("[5, 60, *, 2, /]", ret);
		ret = cal.resolveExpression();
		assertEquals("150.0", ret);
		
		ret = cal.convertToPostFixExpression("4 * 5 + 75");
		assertEquals("[4, 5, *, 75, +]", ret);
		ret = cal.resolveExpression();
		assertEquals("95.0", ret);
	}
}
