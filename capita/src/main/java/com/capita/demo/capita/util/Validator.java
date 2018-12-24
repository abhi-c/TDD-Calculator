package com.capita.demo.capita.util;

import com.capita.demo.capita.Calculator.OPERATOR;

public class Validator {

	public static int isValidNumber(String string) {
		return Integer.parseInt(string);
	}

	public static OPERATOR getValidOperator(String s) {
		OPERATOR[] opArr = OPERATOR.values();
		for (int i = 0; i < opArr.length; i++) { // User java 8
			if(opArr[i].getSymbol().equals(s))
				return opArr[i];
		}
		throw new IllegalArgumentException("You passed: " + s);
	}
}
