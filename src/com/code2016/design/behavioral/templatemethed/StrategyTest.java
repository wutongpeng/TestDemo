package com.code2016.design.behavioral.templatemethed;

/**
 * @Description: 模板方法模式
 * 解释一下模板方法模式，就是指：一个抽象类中，有一个主方法，
 * 再定义1...n个方法，可以是抽象的，也可以是实际的方法，定义一个类，
 * 继承该抽象类，重写抽象方法，通过调用抽象类，实现对子类的调用。
 * @author wutp 2017年2月23日
 * @version 1.0
 */
public class StrategyTest {

	public static void main(String[] args) {
		String exp = "8+8";  
        AbstractCalculator cal = new Plus();  
        int result = cal.calculate(exp, "\\+");  
        System.out.println(result); 
	}

}