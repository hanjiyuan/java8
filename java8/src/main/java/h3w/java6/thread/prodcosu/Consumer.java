package h3w.java6.thread.prodcosu;


public class Consumer extends Thread {

	private Repository rep;
	
	public Consumer(Repository rep){
		super("CONSUMER");
		this.rep = rep;
	}
	
	public void run() {
		int count = 0;
		while (true) {
			if (count == rep.getSize()) break;
			try {
				rep.get();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				continue;  // why continue?
			}
			count++;
		}
	}
}
