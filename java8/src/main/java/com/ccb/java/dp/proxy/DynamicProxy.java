package com.ccb.java.dp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

	private Object target;

	public DynamicProxy(Object target) {
		super();
		this.target = target;
	}

	public void before() {
		System.out.println("proxy before() ...");
	}

	public void after() {
		System.out.println("proxy after() ...");
	}


	public Object getProxy() {
		return Proxy.newProxyInstance(getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object object = null;
		if (method.getName().equals("open")) {
			before();
			object = method.invoke(target, args);
			after();
		}
		return object;
	}
}
