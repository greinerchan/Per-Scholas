package monday;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConsumerProduct {
	private static final Queue<Integer> queue = new ConcurrentLinkedQueue<>();
	private static final long startMillis = System.currentTimeMillis();
	
	public static class Consumer implements Runnable {

		@Override
		public void run() {
//			System.out.println("Consumter run method.");
			// This loop will continue for 10 seconds from the creation of the class instance
			while (System.currentTimeMillis() < (startMillis + 10000)) {
				synchronized (queue) {
					try {
//						System.out.println("Consumer try block.");
						/* wait() method is inherited from the Object class and causes the current
						 * thread to wait until another thread invokes with notify() or notifyAll()
						 * method for this object. */
						queue.wait();
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (!queue.isEmpty()) {
					// The poll() method retrieves and removes the head
//					System.out.println("Queue content: " + queue);
					Integer integer = (Integer)queue.poll();
					/* This print statement will print the current thread along with the head of
					the queue */
					System.out.println("[" + Thread.currentThread().getName() + "]: " + integer);
				}
			}
			
		}
	
	}
	
	public static class Producer implements Runnable {

		@Override
		public void run() {
			int i = 0;
			// This loop will continue for 10 seconds from the creation of the class instance
			while (System.currentTimeMillis() < (startMillis + 10000)) {
				queue.add(i++);
//				System.out.println(queue);
//				System.out.println("Next int: " + getNextInt());
				synchronized (queue) {
					// Notifies the queue object to stop waiting after an integer is added to the queue.
					queue.notify();
				}
				try
				{
					Thread.sleep(100);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			synchronized (queue) {
				// This line notifies all queue objects to stop waiting
				queue.notifyAll();
			}
			
		}
		
	}
	
	public static Integer getNextInt() {
		Integer retVal = null;
		synchronized (queue) {
			try
			{
				while (queue.isEmpty()) {
					queue.wait();
				}
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			retVal = queue.poll();
		}
		return retVal;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread[] consumerThreads = new Thread[5];
		for (int i = 0; i < consumerThreads.length; i++) {
			consumerThreads[i] = new Thread(new Consumer(), "consumer-" + i);
			consumerThreads[i].start();
		}
		Thread producerThread = new Thread(new Producer(), "producer");
		producerThread.start();
		for (int i = 0; i < consumerThreads.length; i++) {
			consumerThreads[i].join();
		}
//		producerThread.join();
	}
}