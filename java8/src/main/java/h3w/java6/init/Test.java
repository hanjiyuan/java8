package h3w.java6.init;

public class Test {

	public static void main(String[] args) {

		Child.BBQ bbq = new Child.BBQ();

		System.out.println("-------------");
		
		Father.func2();
		
		System.out.println("-------------");

		Child.func2();
		
		System.out.println("-------------");

		Father father = new Child();
		
		System.out.println("-------------");

		father.func1();
	}
}
