package com.cts;

import java.util.Stack;
import java.util.Vector;

public class ProducerAndConsumerDemo {

	public static void main(String[] args) {
		Stack stack=new Stack();
       new Thread(new Producer(stack)).start();
       new Thread(new Consumer(stack)).start();
       
	}
}

class Producer implements Runnable {
	Stack stack;

	public Producer(Stack stack) {
		// TODO Auto-generated constructor stub
		this.stack = stack;
	}

	@Override
	public void run() {

		// if queue is full need to wait
		for(int i=0;i<10;i++){
			try {
				produce(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private void produce(int i) throws InterruptedException {
		// TODO Auto-generated method stub
		synchronized (stack) {
			while(stack.size()==10){
				stack.wait();
			}
		}
		synchronized (stack) {  
	           System.out.println("Produced : " + i);
	           stack.add(i);
	         Thread.sleep((long)(Math.random() * 1000));
	         stack.notify();
	        }
		
	}

}

class Consumer implements Runnable {

	Stack stack;

	public Consumer(Stack stack) {
		// TODO Auto-generated constructor stub
		this.stack = stack;
	}

	@Override
	public void run() {
		// if queue is empty need to wait
		
			while(true){
				try {
					consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
	}

	private void consume() throws InterruptedException {
		// TODO Auto-generated method stub
		synchronized (stack) {
			while(stack.isEmpty()){
				stack.wait();
			}
		}
		synchronized (stack) {
	           Thread.sleep((long)(Math.random() * 1000));
	         System.out.println("CONSUMED : "+ stack.remove(0));
	         stack.notify();
	        }

		
	}

}
