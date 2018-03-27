package com.ccb.java.dp.proxy;

public class Test {

    public static void main(String[] args) {
        IConnection conn = new Connection("Oralce");
        DynamicProxy proxy = new DynamicProxy(conn);
        IConnection conn1 = (IConnection) proxy.getProxy();
        conn1.open();
        conn1.toString();
    }
}
