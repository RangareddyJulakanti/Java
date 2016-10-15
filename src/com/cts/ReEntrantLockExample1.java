package com.cts;

import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLockExample1 {

	public static void main(String[] args) {
		ReentrantLock reentrantLock=new ReentrantLock(true);
		reentrantLock.lock();
		reentrantLock.lock();
		reentrantLock.lock();
		System.out.println(reentrantLock.isLocked());
		System.out.println(reentrantLock.isFair());
		System.out.println(reentrantLock.isHeldByCurrentThread());
		System.out.println(reentrantLock.getHoldCount());
		reentrantLock.unlock();
		System.out.println(reentrantLock.getHoldCount());
		reentrantLock.unlock();
		System.out.println(reentrantLock.isLocked());
		System.out.println(reentrantLock.isFair());
		System.out.println(reentrantLock.isHeldByCurrentThread());
		System.out.println(reentrantLock.getHoldCount());
	}

}
