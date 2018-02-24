package h3w.java6.thread.semaphore;

public class PrintTask extends Thread {

	private PrintQueue printQueue;
	private Document document;

	public PrintTask(PrintQueue q, Document doc) {
		this.printQueue = q;
		this.document = doc;
	}

	// 具体的打印操作
	@Override
	public void run() {
		printQueue.print(document);
		System.out.println();
	}
}
