package com.ss.deadlockexample;

public class DeadlockExample 
{
	public static void main(String[] args) 
	{
		DeadlockExample example = new DeadlockExample();
		
		Object o1 = new Object();
		Object o2 = new Object();
		
		Thread thread1 = new Thread(example.new MyThread(o1, o2));
		Thread thread2 = new Thread(example.new MyThread(o2, o1));
		
		thread1.setName("ONE");
		thread2.setName("TWO");
		
		
		thread1.start();
		thread2.start();
	}
	
	class MyThread implements Runnable
	{
		private Object o1;
		private Object o2;
		private String name;
		
		public MyThread(Object o1, Object o2) 
		{
			this.o1 = o1;
			this.o2 = o2;
		}
		
		@Override
		public void run() 
		{
			this.name = Thread.currentThread().getName();
			
			System.out.println(name + " locking " + o1);
			synchronized(o1) 
			{
				calculate();
				System.out.println(name + " locked " + o1 + "\n");
				
				System.out.println(name + " locking " + o2);
				synchronized(o2) 
				{
					calculate();
					System.out.println(name + " locked " + o2 + "\n");
				}
				System.out.println(name + " released " + o2);
			}
			System.out.println(name + " released " + o1);
		}
		
		public void calculate() 
		{
			try 
			{
				Thread.sleep(100);
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

