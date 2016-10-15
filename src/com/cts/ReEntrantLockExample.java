package com.cts;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReEntrantLockExample
{
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Map<String, String> map = new HashMap<>();
		ReadWriteLock lock = new ReentrantReadWriteLock();

		
			Runnable writeTask=() -> {
			    lock.writeLock().lock();
			    try {
			    	
			    	 System.out.println(" writing");
			   map.put("1", "Ranga");
			   Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
			        lock.writeLock().unlock();
			    }
			};
			
			Runnable readTask = () -> {
				 
			    lock.readLock().lock();
			    try {
			    	System.out.println("waiting for read");
			System.out.println(map.get("1"));
			    Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
			        lock.readLock().unlock();
			    }
			};
		
		
		executor.submit(writeTask);
		executor.submit(readTask);
		
		executor.submit(readTask);
		
		
		


		executor.shutdown();
	}

}
