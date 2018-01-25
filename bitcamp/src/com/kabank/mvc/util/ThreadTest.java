package com.kabank.mvc.util;

public class ThreadTest {
	public static void main(String[] args) {
		Atm atm = new Atm();
		Runnable hong = new User(atm, "홍길동");
		Runnable kim = new User(atm, "김유신");
		Runnable lee = new User(atm, "이순신");
		Thread thr1 = new Thread(hong);
		thr1.start();
		Thread thr2 = new Thread(kim);
		thr2.start();
		Thread thr3 = new Thread(lee);
		thr3.start();
		//thread 1개당 1개씩 타고있음
	}
}
class Atm{
	public synchronized void inchul(String name) {
		System.out.println(name + " 님이 인출 요청함");
		for(int i=0; i<=100000000; i++) {
			if(i==10000) {
				System.out.println(name + " 님이 돈을 인출하는 중...");
			}
		}
		System.out.println(name + " 님이 인출해 나감");
	}
}
class User implements Runnable{
	Atm atm;	//Atm이 있어야 Atm user가 존재할 수 있다.
	String name;
	public User(Atm atm, String name) {
		// TODO Auto-generated constructor stub
		super();		//얘가 뭐였지..
		this.atm = atm;
		this.name = name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		atm.inchul(name);
	}
	
}
//하나의 클래스파일에 두개이상의 클래스가 있을 수도 있지만, 퍼블릭은 단 하나만 있어야된다
