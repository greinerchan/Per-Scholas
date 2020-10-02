package monday;

class IncrementAndPrint implements Runnable {
	private static Integer num = 0;

	@Override
	public void run() {

		synchronized (IncrementAndPrint.class) {
			if (Thread.currentThread().getName().equals("Thread One")) {
				for (int i = 0; i < 1000000; i++) {
					num++;
				}
			} else {
				System.out.println("Final count (should equal 1000000): " + getNum());
			}
			System.out.println("Synchronized block completed by " + Thread.currentThread().getName());
		}

	}

	public static Integer getNum() {
		return num;
	}
}

public class GuardedBlocks {
	public static void main(String[] args) throws InterruptedException {
		Runnable r = new IncrementAndPrint();
		Thread threadOne = new Thread(r);
		threadOne.setName("Thread One");
		Thread threadTwo = new Thread(r);
		threadTwo.setName("Thread Two");
		
		threadOne.start();
//		threadOne.join();
		threadTwo.start();
	}
}
