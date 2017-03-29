package com.reflectdemo.test;

public class ClassDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="22132";
		ClassUtil.printMemberVariable(str);
		System.out.println("---------------------------");
		ClassUtil.printMemberVariable(new Integer(1));
	}

}
