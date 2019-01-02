package com.capita.demo.capita;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import com.capita.demo.capita.util.Validator;

public class Calculator {

	private Stack<OPERATOR> operandStack = new Stack<OPERATOR>();
	private Deque<String> postFixStack = new LinkedList<String>();

	public enum OPERATOR {
		BrcRt(3, ")"), BrcLt(4, "("), DIV(2, "/"), Multi(2, "*"), Add(1, "+"), Sub(1, "-");

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
				throw new IllegalArgumentException("Passed operand is: " + this);
			}
		}
	}

	public String resolveExpression() {
		Stack<String> evaluation = new Stack<String>();

		while (!postFixStack.isEmpty()) {
			String token = postFixStack.pollFirst();
			if (Validator.isValidOperator(token)) {
				OPERATOR operator = Validator.getValidOperator(token);
				String second = evaluation.pop();
				String first = evaluation.pop();

				double result = operator.operate(Double.parseDouble(first), Double.parseDouble(second));
				evaluation.push(result+"");
			} else {
				evaluation.push(token);
			}
		}
		return evaluation.pop();
	}

	public String convertToPostFixExpression(String expression_) {
		operandStack.clear();
		postFixStack.clear();

		String[] expression = expression_.split("\\s+");

		for (int i = 0; i < expression.length; i++) {
			String token = expression[i];

			if (token.length() == 0) {
				continue;
			}
			if (Validator.isValidNumber(token)) {
				postFixStack.addLast(token);
			} else {
				OPERATOR currentOperator = Validator.getValidOperator(token);
				if (operandStack.isEmpty() || operandStack.peek().weight < currentOperator.weight) {
					operandStack.push(currentOperator);
				} else {
					while (!operandStack.isEmpty() && operandStack.peek().weight >= currentOperator.weight) {
						OPERATOR prevOperator = operandStack.pop();
						postFixStack.addLast(prevOperator.symbol);
					}
					operandStack.push(currentOperator);
				}
			}
		}
		while (!operandStack.empty()) {
			OPERATOR prevOperator = operandStack.pop();
			postFixStack.addLast(prevOperator.symbol);
		}

		return postFixStack.toString();
	}
}
