package h3w.java6.thread.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphorePermitsTest {

	public static void main(String[] args) throws Exception {
		Semaphore semaphore = new Semaphore(10);// 总共有1个许可
		System.out.println("可用的许可数目为：" + semaphore.availablePermits());
		semaphore.release();
		System.out.println("可用的许可数目为：" + semaphore.availablePermits());
	}
}
