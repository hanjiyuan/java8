package h3w.java6.thread.prodcosu;

public class Repository {

	private int size;

	private int index;

	private int value;

	private int[] units;

	public Repository(int size) {
		this.size = size;
		this.index = 0;
		this.value = 0;
		units = new int[size];
	}

	public synchronized int put() throws Exception{
		if (index < size) {
			units[index++] = value++;
			return units[index - 1];
		} else {
			throw new Exception(Thread.currentThread().getName() 
					+ ": " + "repository is full");
		}
	}

	public synchronized int get() throws Exception {
		if (index == 0) {
			throw new Exception(Thread.currentThread().getName() 
					+ ": " + "repository is empty");
		} else {
			return units[--index];
		}
	}

	public synchronized int getSize() {
		return size;
	}

	public synchronized void setSize(int size) {
		this.size = size;
	}
}
