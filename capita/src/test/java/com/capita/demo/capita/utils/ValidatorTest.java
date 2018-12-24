package com.capita.demo.capita.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capita.demo.capita.Calculator.OPERATOR;
import com.capita.demo.capita.util.Validator;

public class ValidatorTest {

	@Test(expected=NumberFormatException.class)
	public void validateStrNumberOfTest()
	{
		Validator.getValidNumber("asd");
	}

	@Test
	public void validateIntNumberOfTest()
	{
		int ret = Validator.getValidNumber("12");
		assertEquals(12, ret);
	}
	
	@Test
	public void validateOperator()
	{
		OPERATOR ret =  Validator.getValidOperator("*");
		assertEquals(OPERATOR.Multi, ret);
		
		 ret =  Validator.getValidOperator("/");
		assertEquals(OPERATOR.DIV, ret);
		
		 ret =  Validator.getValidOperator("(");
		assertEquals(OPERATOR.BrcLt, ret);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void inValidateOperator()
	{
		Validator.getValidNumber("asd");
	}
}
