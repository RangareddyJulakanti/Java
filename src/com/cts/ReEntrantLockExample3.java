package com.cts;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLockExample3 {

	public static void main(String[] args) throws InterruptedException {
		
		
		Runnable runnable=new Runnable(){
			ReentrantLock reentrantLock=new ReentrantLock();
			public void run()
			{
				do{
					try {
						if(reentrantLock.tryLock(1000,TimeUnit.MILLISECONDS))
						{
							System.out.println(Thread.currentThread().getName()+"  got the lock --- executing un safe operation");
							try {
								Thread.sleep(5000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							reentrantLock.unlock();
							System.out.println(Thread.currentThread().getName()+"   released the lock");
							
							break;
							
						}else
						{
							System.out.println(Thread.currentThread().getName()+"unable the  get the lock --- executing safe operation");
								
							
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}while(true);
				
			}
		};
		
		
		Thread t1=new Thread(runnable);
		       t1.setName("Thread1");
		       
		   	Thread t2=new Thread(runnable);
		       t2.setName("Thread2");
		       t1.start();
		       t2.start();
		       t2.join();
		       t1.join();
		

	}

}
