package com.code2016.design.behavioral.interpreter;

public class Minus implements Expression {

	@Override
	public int interpret(Context context) {
		 return context.getNum1()+context.getNum2(); 
	}

}
