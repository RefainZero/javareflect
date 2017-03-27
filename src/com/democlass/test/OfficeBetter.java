package com.democlass.test;

public class OfficeBetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// 动态加载类，在类运行时加载
			Class c = Class.forName("com.democlass.test.Word");
			// 通过类类型创建该对象
			OfficAble o = (OfficAble) c.newInstance();
			o.start();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
