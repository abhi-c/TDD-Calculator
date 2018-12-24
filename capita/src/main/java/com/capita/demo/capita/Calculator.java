package com.capita.demo.capita;

import java.util.Deque;
import java.util.LinkedList;

import com.capita.demo.capita.util.Validator;

public class Calculator {

	private Deque<String> tokenQueue = new LinkedList<String>();

	public enum OPERATOR {
		BrcRt(1, ")"), BrcLt(1, "("), DIV(2, "/"), Multi(2, "*"), Add(3, "+"), Sub(3, "-");

		private int weight = 0;
		private String symbol;

		OPERATOR(int weight, String symb) {
			this.weight = weight;
			this.symbol = symb;
		}

		public int getWeight() {
			return weight;
		}

		public String getSymbol() {
			return symbol;
		}

		public double operate(double a, double b) {
			switch (this) {
			case Add:
				return a + b;
			case DIV:
				return a / b;
			case Multi:
				return a * b;
			case Sub:
				return a - b;
			default:
				throw new IllegalArgumentException("Passed operand is: "+ this);
			}
		}
	}

	public double evaluateExpression(String inpExpression) {
		tokenQueue.clear();
		String[] expression = inpExpression.split("\\s+");

		for (int i = 0; i < expression.length; i++) {
			String token = expression[i];
			
			if(token.length()==0 )
			{
				continue;
			}
				
			
			if (Validator.isValidNumber(token)) {
				tokenQueue.addLast(token);
			} else if (Validator.isValidOperator(token)) {
				tokenQueue.addLast(expression[++i] + "");
				tokenQueue.addLast(token);
			} else {
				throw new IllegalArgumentException("Expression you provided is: " + token);
			}
		}

		while (tokenQueue.size() >1 ) {
			String token = tokenQueue.removeLast();
			if (Validator.isValidOperator(token)) {
				String operator = token;
				String secondOperand = tokenQueue.removeLast();
				String firstOperand = tokenQueue.removeLast();
				
				OPERATOR op = Validator.getValidOperator(operator);
				Double ret = op.operate(Double.parseDouble(firstOperand), Double.parseDouble(secondOperand));
				tokenQueue.addLast(ret+"");
				
			} else {
				throw new IllegalArgumentException("Expression you provided is: " + token);
			}
		}

		return Double.parseDouble(tokenQueue.getLast());
	}

}
