package com.code2016.design.structural.adapter.demo1;

/**
 * @Description: 适配器模式 教材例子
 * @author wutp 2017年2月23日
 * @version 1.0
 */
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlternateCurrent aElectric = new PowerCompany();
		Wash wash = new Wash();
		wash.turnOn(aElectric);
		DirectCurrent dElectric = new ElectricAdapter(aElectric);
		Recorder recorder = new Recorder();
		recorder.turnOn(dElectric);
	}
	
	
}
class PowerCompany implements AlternateCurrent {

	@Override
	public String giveAlternateCurrent() {
		// TODO Auto-generated method stub
		return "10101010101010101010";
	}			
}

class Wash{
	String name;
	Wash(){
		name="洗衣机";
	}
	Wash(String s){
		name=s;
	}
	public void turnOn(AlternateCurrent a){
		String s=a.giveAlternateCurrent();
		System.out.println(name+"使用交流电：\n"+s);
		System.out.println("开始洗衣物");
	} 
}

class Recorder{
	String name;
	Recorder(){
		name="录音机";
	}
	Recorder(String s){
		name=s;
	}
	public void turnOn(DirectCurrent a){
		String s=a.giveDirectCurrent();
		System.out.println(name+"使用直流电：\n"+s);
		System.out.println("开始录音");
	} 
}
