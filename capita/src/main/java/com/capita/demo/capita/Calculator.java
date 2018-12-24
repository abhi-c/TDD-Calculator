package com.capita.demo.capita;

public class Calculator {

	public enum OPERATOR {
		BrcRt(1,")"), BrcLt(1,"("), DIV(2,"/"), Multi(2,"*"), Add(3,"+"), Sub(3,"-");

		private int weight = 0;
		private String symbol;

		OPERATOR(int weight,String symb) {
			this.weight = weight;
			this.symbol = symb;
		}

		public int getWeight() {
			return weight;
		}

		public String getSymbol() {
			return symbol;
		}
	}

	// TODO make it non static
	public static double evaluateExpression(String expression) {
		int[] evaluateHeap = new int[expression.length()];

		for (int i = 0; i < expression.length(); i++) {

		}

		return 2D;
	}

}
