package com.ccb.test;

public class Test {

	public static void main(String[] args) {
		MyClassLoader loader3 = new MyClassLoader("E:\\test"); 
		try {
			Class classN3 = loader3.loadClass("test.N",true);
			Class.forName("test.N");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}

}
