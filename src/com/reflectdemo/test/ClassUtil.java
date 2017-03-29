package com.reflectdemo.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {

	/**
	 * 打印类的信息，成员函数也是对象
	 */
	public static void printFunction(Object obj){
//		要想获取类信息，首先先要获取类的类型
		Class  c = obj.getClass();
//		获取类的名字
		System.out.println("类的名字为："+c.getName());
//		c.getMethods()获取所有public的方法，包括从父类继承的方法
//		c.getDeclaredMethods()获取所有自己声明的方法，不问访问权限
//		获取方法名
		Method[] methods = c.getMethods();
		for (Method method : methods) {
//			获取返回值类型
			Class returnType = method.getReturnType();
			System.out.print(returnType.getName()+" :");
//			获取类的方法名
			System.out.print(method.getName()+"(");
//			获取参数列表类型
			Class [] parameterTypes = method.getParameterTypes();
			for (Class class1 : parameterTypes) {
				System.out.print(class1.getName());
			}
			System.out.println(")");
		} 
	}

	/**
	 * 	成员变量也是对象
	 * c.getFields();获取所有public的成员变量
	 * c.getDeclaredFields() 所有自己声明的成员变量
	 * @param c
	 */
	public static void printMemberVariable(Object obj) {
		Class  c = obj.getClass();
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			// 获取成员变量类型
			Class returnType = field.getType();
			System.out.print(returnType.getName() + " :");
			// 获取类的成员变量名
			System.out.print(field.getName() + "(");
			System.out.println(")");
		}
	}
	
	/**
	 * 构造器也是对象
	 * c.getConstructors();获取所有public的成员变量
	 * c.getDeclaredConstructors() 所有自己声明的成员变量
	 * @param obj
	 */
	public static void printConstructor(Object obj) {
		Class  c = obj.getClass();
		Constructor[] constructors = c.getDeclaredConstructors();
		for (Constructor constructor : constructors) {
//			获取构造器异常类型
			System.out.println(constructor.getExceptionTypes()+" :");
//			获取构造器名称
			System.out.print(constructor.getName()+"(");
//			获取参数列表类型
			Class [] parameterTypes = constructor.getParameterTypes();
			for (Class class1 : parameterTypes) {
				System.out.print(class1.getName());
			}
			System.out.println(")");
		} 
	}
}
