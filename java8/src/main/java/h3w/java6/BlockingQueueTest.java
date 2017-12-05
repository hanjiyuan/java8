package h3w.java6;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(
			10);

	public static void main(String[] args) {
		BlockingQueueTest test = new BlockingQueueTest();
		for (int i = 0; i < 100; i++) {
			test.new PutThread(i).start();
		}

		// test.new TakeThread().start();
	}

	class PutThread extends Thread {
		private int num;

		public PutThread(int num) {
			this.num = num;
		}

		public void run() {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				queue.put(num);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("blocking queue put " + num);
		}
	}

	class TakeThread extends Thread {
		public void run() {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				while (!queue.isEmpty()) {
					int num = queue.take();
					System.out.println("blocking queue take " + num);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
