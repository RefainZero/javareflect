package com.reflectdemo.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * 方法的反射使用
 * 
 * @author Administrator
 *
 */
public class ClassDemo4 {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testMethod() {
		// 要想获取类的方法，首先先要知道该类的类类型
		PrintMessage printMessage = new PrintMessage();
		Class c = printMessage.getClass();
		try {
			// 获取该类所有方法，包括自己声明的，不问权限
			// c.getDeclaredMethod(name, parameterTypes)
			// 获取该类所有public方法
			Method m1 = c.getMethod("print",new Class[] { int.class, int.class });
			m1 = c.getMethod("print", int.class, int.class);
			m1.invoke(printMessage, 1, 1);
			Method m2 = c.getMethod("print", String.class, String.class);
			m2.invoke(printMessage, "hellow", "world!");
			Method m3 = c.getMethod("print");
			m3.invoke(printMessage);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class PrintMessage {
	public void print(int a, int b) {
		System.out.println(a + b);
	}

	public void print(String a, String b) {
		System.out.println(a.toUpperCase() + " :" + b.toLowerCase());
	}

	public void print() {
		System.out.println("helloworld!!");
	}
}