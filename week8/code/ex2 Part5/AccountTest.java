public class AccountTest {
	public static void main(String[] args) {
		Thread[] threads = new Thread[2];
		AccountTest at = new AccountTest();
		threads[0] = new Thread(at);
		threads[1] = new Thread(at);
		threads[0].setName("Reema");
		threads[1].setName("Ranjeet");
		threads[0].start();
		threads[1].start();
	}
}