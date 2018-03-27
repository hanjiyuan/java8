package h3w.java6.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {

        // test0();

        // test1();

        // test2();
        test5();
    }

    public static void test0() {
        List<String> list = new ArrayList<String>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");
        List<String> sub = list.subList(1, 2);
        /**
         * 对原集合元素个数的修改， 会导致子列表的遍历、增加、删除均会产生 ConcurrentModificationException异常
         */
        list.remove(1);
        for (String s : sub) {
            // will throw ConcurrentModificationException
            System.out.println(s);
        }
    }

    public static void test1() {
        List<String> list = new ArrayList<String>(2);
        list.add("guan");
        list.add("bao");
        /**
         * 使用集合转数组的方法，必须使用集合的toArray(T[]array)， 传入的是类型完全一样的数组，大小就是list.size()
         */
        String[] array = new String[list.size()];
        array = list.toArray(array);
    }

    /**
     * 使用工具类Arrays.asList()把数组转换成集合时， 不能使用其修改集合相关的方法，
     * 它的add/remove/clear方法会抛出UnsupportedOperationException异常。
     * 
     * 说明： asList的返回对象是一个Arrays内部类， 并没有实现集合的修改方法。 Arrays.asList体现的是适配器模式，
     * 只是转换接口，后台的数据仍是数组。
     */
    public static void test2() {
        String[] str = new String[] { "you", "wu" };
        List<String> list = Arrays.asList(str);
        // 运行时异常
        list.add("yangguanbao");
        // list.get(0)也会随之修改
        str[0] = "gujin";
        System.out.println(list.get(0));
    }

    public static void test3() {
        List<String> list = new LinkedList<String>();
        list.add("you");
        list.add("wu");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.equals("you")) {
                iterator.remove();
            }
        }
    }

    /**
     * 若是2，则会抛出 ConcurrentModificationException 异常；
     * 若是1，不会抛出异常，且list中的1能够被删除。
     * 如果 list 是 LinkedList 类型，那么，无论是1还是2，都能正常运行。
     * 综上，一定要使用 Iterator
     */
    public static void test4() {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }
    }
    
    
    public static void test5() {
        Student s1 = new Student("zhangsan", 5);
        Student s2 = new Student("lisi", 10);
        Student s3 = new Student("wangwu", 5);
        List<Student> list = new ArrayList<Student>(2);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        // s1,s3,s2
        Collections.sort(list, new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                if (o1.age == o2.age) {
                    return 0;
                } else {
                    return o1.age - o2.age;
                }
            }
        });
        for (Student s : list) {
            System.out.println(s.name + ":" + s.age);
        }
    }
}
