package h3w.java6.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {

    public static void main(String[] args) {

        // test0();

        test1();

        test2();
    }

    public static void test0() {
        List<String> list = new ArrayList<String>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");
        List<String> sub = list.subList(1, 2);
        /*
         * 对原集合元素个数的修改， 会导致子列表的遍历、增加、删除均会产生ConcurrentModificationException异常
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
        /*
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
}
