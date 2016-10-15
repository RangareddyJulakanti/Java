package com.cts;

public class DeadLock extends Thread {

	A a=new A();
	B b=new B();
	public DeadLock() throws InterruptedException
	{
		Thread childThread=new Thread(this);
		childThread.start();
		a.foo(b);
		
	}
	public static void main(String[] args) throws InterruptedException {
		new DeadLock();
		

	}
	public void run()
	{
		try {
			b.bar(a);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
class A
{
	public synchronized void foo(B b) throws InterruptedException
	{
		System.out.println("child thread called A class foo");
		Thread.sleep(1000);
		System.out.println("child thread trying to get B'slock");
		b.last();
	}
	public synchronized void  last()
	{
		System.out.println("main thread called A'last method");
	}
}
class B{
	public synchronized void bar(A a) throws InterruptedException
	{
		System.out.println("main thread called B class foo");
		Thread.sleep(1000);
		System.out.println("main  thread trying to get A'slock");
		a.last();
		
	}
	public  synchronized void  last()
	{
		System.out.println("child thread called B'last method");
		
	}
}
