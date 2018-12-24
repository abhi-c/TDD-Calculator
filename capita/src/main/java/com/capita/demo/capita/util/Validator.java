package com.capita.demo.capita.util;

import com.capita.demo.capita.Calculator.OPERATOR;

public class Validator {

	public static int getValidNumber(String string) {
		return Integer.parseInt(string);
	}

	public static OPERATOR getValidOperator(String s) {
		OPERATOR[] opArr = OPERATOR.values();
		for (int i = 0; i < opArr.length; i++) { // User java 8
//			System.out.println(opArr[i].getSymbol());
//			System.out.println(s);
			if (opArr[i].getSymbol().equals(s))
				return opArr[i];
		}
		throw new IllegalArgumentException("You passed: " + s);
	}

	public static boolean isValidOperator(String s) {
		try {
			getValidOperator(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isValidNumber(String s) {
		try {
			getValidNumber(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
