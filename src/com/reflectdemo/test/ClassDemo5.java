package com.reflectdemo.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Test;

/**
 * 通过反射认识集合泛型的本质
 * @author Administrator
 *
 */
public class ClassDemo5 {

	@Test
	@SuppressWarnings("unchecked")
	public void run(){
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("hellow");
		ArrayList list2 = new ArrayList();
//		获取类类型
		Class c1 = list1.getClass();
		Class c2 = list2.getClass();
		System.out.println(c1==c2);
//		说明：通过编译后的集合是去泛型化的集合
//		集合的泛型是防止错误输出的，在编译阶段时通过泛型能够去除不合法的输入，但是反射却能够绕过泛型。
//		验证：集合通过反射后是去泛型化的，可绕过编译
		try {
//			通过反射获取对应类的类方法
			Method method1 = c1.getMethod("add", Object.class);
			method1.invoke(list1, 1);
			System.out.println(list1.size());
			Method method2 = c1.getMethod("add", Object.class);
			method2.invoke(list2, "wwwwww");
			System.out.println(list2.size());
		} catch (NoSuchMethodException | SecurityException e) {
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
