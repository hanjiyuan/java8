package com.ccb.java.dp.proxy;

public class Connection implements IConnection {

    private String name;

    public Connection(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void open() {
        System.out.println("open " + name + " now ....");
    }
}
