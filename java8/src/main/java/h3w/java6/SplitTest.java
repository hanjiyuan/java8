package h3w.java6;

public class SplitTest {

    public static void main(String[] args) {
        String str = "a,b,,";
        String[] arr = str.split(",");
        // print 2
        System.out.println(arr.length);
        // print b
        System.out.println(arr[arr.length - 1]);
        
        System.out.println(new Object().toString());
    }

}
