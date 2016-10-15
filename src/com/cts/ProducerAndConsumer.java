package com.cts;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class ProducerAndConsumer {
	Stack<Integer> l= new Stack<Integer>();
	private final Lock aLock = new ReentrantLock(); 
	private final Condition queueISEmpty = aLock.newCondition(); 
	private final Condition queueISFull = aLock.newCondition();

	
	public static void main(String[] args) throws InterruptedException {
		ProducerAndConsumer producerAndConsumer=new ProducerAndConsumer();
		
		Thread t1=new Thread(){
			public void run(){
				for(int i=1;i<=10;i++)
				{
					try {
						producerAndConsumer.produce(i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		};

	Thread t2=	new Thread() 
		{
            public void run(){
				while(true){
					try {
						producerAndConsumer.consume();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		t1.start();
		t2.start();
		
		//t1.join();
		//t2.join();
	}

	public void produce(int i) throws InterruptedException 
	{
		//Java7
		/*
	      synchronized (l) {
			if(l.size()==10){
				l.wait();
			}
			l.add(i);
			System.out.println("PRODUCED: "+i);
			l.notify();
			Thread.sleep(1000);
		   }*/
		
		
		//Java8
		aLock.lock();
		if(l.size()==10){
			queueISFull.await();
		}
		l.add(i);
		System.out.println("PRODUCED: "+i);
		queueISEmpty.signal();
		Thread.sleep(1000);
		aLock.unlock();
		
       
	}

	public void consume() throws InterruptedException
	{
		
		//java 7
		/*
		synchronized (l) {
			if(l.empty()){
				l.wait();
			}
			System.out.println("CONSUMED :"+l.remove(0));
			l.notify();
			Thread.sleep(1000);
		   }*/
		
		//java 8
		aLock.lock();
		if(l.empty()){
			queueISEmpty.await();
		}
		System.out.println("CONSUMED :"+l.remove(0));
		queueISFull.signal();
		Thread.sleep(1000);
		aLock.unlock();

	}
}
