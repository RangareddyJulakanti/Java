package com.cts;

import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLockExample2 {

	public static void main(String[] args) 
	{
		Display d=new Display();
		MyThread t1=new MyThread(d, "Ranga");
		MyThread t2=new MyThread(d, "Hari");
		MyThread t3=new MyThread(d, "Kiran");
		t1.start();
		t2.start();
		t3.start();

	}

}

class MyThread extends Thread{
	Display d;
	String name;
	MyThread(Display d,String name){
		this.d=d;
		this.name=name;
	}
	public void run(){
		try {
			d.wish(name);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class Display{
	ReentrantLock reentrantLock=new ReentrantLock();
	public void wish(String name) throws InterruptedException
	{
		reentrantLock.lock();
		
		for(int i=0;i<5;i++)
		{
			System.out.println("GoodMorning : "+name);
			Thread.sleep(1000);
		}
		
		reentrantLock.unlock();
		
	}
}