package com.democlass.test;

/**
 * 
 * @author Administrator
 *    class类的使用
 *
 */
public class DemoClass1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 万物皆对象，其中静态变量和基本数据类型不是面向对象
		 * 如何创建一个对象实例
		 */
		Foo foo = new Foo();
//		任何一个类都是class的实例对象，有三种表现形式
//		第一种---->告诉我们任何一个对象实例都隐含有一个静态成员变量class
		Class c1=Foo.class;
//		第二种--->已知对象通过getclass方法
		Class c2 = foo.getClass();
		System.out.println(c1==c2);
//		第三种---->通过动态加载类
		Class c3=null;
		try {
			c3=Class.forName("com.democlass.test.Foo");
			System.out.println(c1==c3);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		通过类类型创建实例对象，并调用其方法
		try {
			Foo f=(Foo) c3.newInstance();
			f.print();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

class Foo{
	void print(){
		System.out.println("Foo .......");
	}
}
