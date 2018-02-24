package h3w.java6.thread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SemaphoreTest {

	public static void main(String[] args) throws Exception {

		PrintQueue queue = new PrintQueue();
		int THREAD_COUNT = 20;

		// 为了模拟效果，这里理论上创建了可同时并发的20个线程
		ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

		// 以固定的并发流量处理打印任务
		for (int i = 0; i < THREAD_COUNT; i++) {
			Document doc = new Document("Title" + i, "Contents" + i);
			threadPool.execute(new PrintTask(queue, doc));
		}
		threadPool.shutdown();
	}
}
