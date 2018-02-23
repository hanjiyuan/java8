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

	public synchronized void put() throws Exception{
		if (index < size) {
			units[index++] = value++;
			System.out.println(Thread.currentThread().getName()  
					+ ": put " + units[index - 1]);
		} else {
			throw new Exception(Thread.currentThread().getName() 
					+ ": " + "repository is full");
		}
	}

	public synchronized void get() throws Exception {
		if (index == 0) {
			throw new Exception(Thread.currentThread().getName() 
					+ ": " + "repository is empty");
		} else {
			System.out.println(Thread.currentThread().getName() 
					+ " : get " +  units[--index]);
		}
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
