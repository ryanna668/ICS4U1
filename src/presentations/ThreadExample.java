package presentations;

public class ThreadExample {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());

		for (int i = 1; i < 4; i++) {
			new Thread("" + i) {
				public void run() {
					System.out.println("Thread " + getName() + " running");
				}
			}.start();
		}
	}
}
