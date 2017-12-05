package h3w.java6.cl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class OrderClassLoader extends ClassLoader {
	
	protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException{
		 Class<?> re = findClass(name);
		 if (re == null) {
			 System.out.println("I can't load the class:" + name + " need help from parent.");
			 return super.loadClass(name,resolve);
		 }
		 return re;
	 }
	
	
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> clazz = this.findLoadedClass(name);
		if (clazz == null) {
			File file = new File("C:\\bea11\\workspace\\JavaTest\\bin\\com\\ccb\\PrintClassLoaderTree.class");
		byte[] content = null;
		try {
			content = read1(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		clazz = defineClass(name,content,0,content.length);
		}
		return clazz;
	}
	
	public byte[] read(File file) {
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		FileChannel chnl = in.getChannel();
		ByteBuffer buf = ByteBuffer.allocate(1024);
		try {
			while (chnl.read(buf) != 0 && chnl.read(buf) != -1){}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buf.array();
	}
	
	public byte[] read1(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		FileChannel fileC = fis.getChannel();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		WritableByteChannel outC = Channels.newChannel(baos);
		ByteBuffer buffer =  ByteBuffer.allocateDirect(1024);
		while(true){
			int i = fileC.read(buffer);
			if (i==0 || i ==-1) {
				break;
			}
			buffer.flip();
			outC.write(buffer);
			buffer.clear();
		}
		fis.close();
		byte[] bytes = baos.toByteArray();
		return bytes;
	}
	
	public void print(File file) {
		try {
			FileInputStream in = new FileInputStream(file);
			byte[] buf = new byte[100];
			int len = 0;
			while ((len = in.read(buf)) != -1) {
				System.out.write(buf, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
//		new OrdreClassLoader().findClass("com.ccb.PrintClassLoaderTree");
		String a = "WH_NH_406";
		String b = "";
		System.out.println(a.startsWith(b));
	}

}
