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
		cal.resolveExpression();

		/*ret = cal.convertToPostFixExpression("4 + 5 * 1");
		assertEquals("[4, 5, 1, *, +]", ret);
		
		ret = cal.convertToPostFixExpression("2 - 40 / 50 + 1");
		assertEquals("[2, 40, 50, /, -, 1, +]", ret);

		ret = cal.convertToPostFixExpression("5 * 6 / 21");
		assertEquals("[5, 6, *, 21, /]", ret);
		
		ret = cal.convertToPostFixExpression("4 * 5 + 75");
		assertEquals("[4, 5, *, 75, +]", ret);*/
	}
}
