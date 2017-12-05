package h3w.java6.gnrc;

import org.junit.Test;

public class BoxTest {

	@Test
	public void test() {
		Box<Integer> age = new Box<Integer>(20);
		Box<String> name = new Box<String>("zhangsan");
		Box<?> box1 = name;
		System.out.println(box1.getData());
	}
}
