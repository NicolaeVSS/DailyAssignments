package com.ss.producerconsumer;

import java.util.concurrent.LinkedBlockingDeque;

public class ProducerConsumer 
{
	public static void main(String[] args) 
	{
		ProducerConsumer example = new ProducerConsumer();

		// Acts as a buffer which holds 128 Objects
		LinkedBlockingDeque<Object> goods = new LinkedBlockingDeque<Object>(10);
		
		Thread producer = new Thread(example.new ProducerThread(goods, 500), "Producer");
		Thread consumer = new Thread(example.new ConsumerThread(goods, 500), "Consumer");
		
		producer.start();
		consumer.start();
	}

	
	class ProducerThread implements Runnable
	{
		private LinkedBlockingDeque<Object> goods;
		private Integer frequency;
		
		public ProducerThread(LinkedBlockingDeque<Object> goods, Integer frequency) 
		{
			this.goods = goods;
			this.frequency = frequency;
		}

		@Override
		public void run() 
		{
			while(true) 
			{
				try 
				{
					Thread.sleep(frequency);
				} 
				catch (InterruptedException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				goods.offer(new Object());
				System.out.println("Produced. New quantity: " + goods.size());
			}
		}
	}
	
	class ConsumerThread implements Runnable
	{
		private LinkedBlockingDeque<Object> goods;
		private Integer frequency;
		
		public ConsumerThread(LinkedBlockingDeque<Object> goods, Integer frequency) 
		{
			this.goods = goods;
			this.frequency = frequency;
		}

		@Override
		public void run() 
		{
			while(true) 
			{
				try 
				{
					Thread.sleep(frequency);
				} 
				catch (InterruptedException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (goods.peekFirst() == null) 
				{
					System.out.println("Peeked empty");
					continue;
				}
				else
				{
					try 
					{
						goods.take();
						System.out.println("Took. New quantity: " + goods.size() + "\n");
					} 
					catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
				}
			}
		}
	}

}
