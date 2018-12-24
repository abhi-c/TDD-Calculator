package com.capita.demo.capita.utils;

import org.junit.Test;

import com.capita.demo.capita.util.Validator;

public class ValidatorTest {

	@Test(expected=NumberFormatException.class)
	public void validateNumberOfTest()
	{
		Validator.isValidNumberOfTests("asd");
	}

}
