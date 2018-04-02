package h3w.java6.random;

import java.util.Random;

public class RandomTest {
    
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            /* Math.random() returns a double value with a positive sign, 
            greater than or equal to 0.0 and less than 1.0. 
            */
            System.out.println(Math.random());
        }
        
        Random r1 = new Random();
        Integer a = r1.nextInt();
        System.out.println(a);
        
        System.out.println(test());
        
       
        
    }
    
    public static int test() {
        try {
            int b = 1;
            return 2;
        } catch (Exception e) {
            
        } finally {
            return 3;
        }
    }
}
