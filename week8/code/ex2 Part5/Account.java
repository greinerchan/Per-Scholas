public class Account implements Runnable{
	public static final balance = 50;
	public void withdraw() {
		if (balance >= 0) { 
			balance = balance - 10;
		} else {
			System.out.println("Not enough in account for" + Thread.currentThread().getName() + "to withdraw 0");
		}
	}
}