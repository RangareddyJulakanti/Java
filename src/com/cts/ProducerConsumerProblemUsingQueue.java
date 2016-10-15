package com.cts;

import java.util.Stack;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerProblemUsingQueue
{
	
	// BlockingQueue<Integer> blockingQueue=new LinkedBlockingQueue<>();
	Stack<Integer> stack=new Stack<>();
	public static void main(String[] args) 
	{
		ProducerConsumerProblemUsingQueue producerConsumerProblemUsingQueue=new ProducerConsumerProblemUsingQueue();
		
		new Thread(){
			public void run() {
				for(int i=0;i<10;i++)
				{
					try {
						producerConsumerProblemUsingQueue.produce(i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		new Thread(){
			public void run() {
				try {
					while(true)
					{
					producerConsumerProblemUsingQueue.consume();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();

	}

	public void produce(int i) throws InterruptedException{
		
		synchronized (stack) {
			if(stack.size()==10)
			{
				stack.wait();
			}
		}
		synchronized (stack) {
			stack.add(i);
			System.out.println("PRODUCED :"+i);
			Thread.sleep(1000);
			stack.notify();
		}
		//blockingQueue.add(i);
		//System.out.println("PRODUCED :"+i);
	}
	public void consume() throws InterruptedException{
		synchronized (stack) {
			if(stack.empty())
			{
				stack.wait();
			}
		}
		synchronized (stack) {
			
			System.out.println("CONSUMED:"+stack.remove(0));
			Thread.sleep(1000);
			stack.notify();
		}
		//System.out.println("CONSUMED:"+blockingQueue.take());
		
	}
	
}

