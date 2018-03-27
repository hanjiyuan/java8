package h3w.java6.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {

         test0();

        // test1();

        // test2();
//        test5();
    }

    public static void test0() {
        
        Student s1 = new Student("zhangsan", 5);
        Student s2 = new Student("lisi", 10);
        Student s3 = new Student("wangwu", 5);
        
        Map<String, Student> map = new HashMap<String, Student>(16);
        map.put(s1.name, s1);
        map.put(s2.name, s2);
        map.put(s3.name, s3);
        
        for (Map.Entry<String, Student> s : map.entrySet()) {
            System.out.println(s.getKey() + ":" + s.getValue());
        }
        Hashtable t = new Hashtable<Integer, Object>();
    }
}
