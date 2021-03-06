package com.code2016.design.creational.singleton;

/**
 * @Description: 懒汉，线程不安全
 * 这种写法lazy loading很明显，但是致命的是在多线程不能正常工作。
 * @author wutp 2016年9月24日
 * @version 1.0
 */
public class Singleton1 {
	private static Singleton1 instance;  
    private Singleton1 (){}  

	public static Singleton1 getInstance() {
		if (instance == null) {
			instance = new Singleton1();
		}
		return instance;
	}
}
