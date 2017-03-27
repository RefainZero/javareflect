package com.democlass.test;

/**
 * 
 * @author Administrator
 *  类的动态加载
 *
 */
public class Office {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if("Word".equals(args[0])){
			Word w=	new Word();
			w.start();
		}else if("Excel".equals(args[0])){
			Excel e=new Excel();
			e.start();
		}

	}

}
