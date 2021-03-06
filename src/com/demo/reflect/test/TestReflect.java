package com.demo.reflect.test;

/** 
 * 通过反射注解结合，替换hibernate完成数据库表映射
 */
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestReflect {

	@Test
	public void test(){
		Filter f1 = new Filter();
		f1.setId(10);//查询ID为10的用户信息
		System.out.println(query(f1));
		Filter f2 = new Filter();
		f2.setUserName("lucy");//查询用户名为Lucy的用户信息
		System.out.println(query(f2));
		Filter f3 = new Filter();
		f3.setEmail("liu@sina.com,zh@163.com,7777@qq.com");//查询邮箱为abc@qq.com的用户信息
		System.out.println(query(f3));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String query(Object f) {
		StringBuffer sb = new StringBuffer();
		// TODO Auto-generated method stub
		// 获取该类类型
		Class c = f.getClass();
		// 获取数据库表名
		boolean isTable = c.isAnnotationPresent(Table.class);
		if (!isTable) {
			return null;
		}
		Table t = (Table) c.getAnnotation(Table.class);
		String tableName = t.value();
		sb.append("select * from ").append(tableName).append(" where 1=1 ");
		// 获取所有字段名
		Object invoke = null;
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			String fieldName = field.getName();
			// 获取字段值
			try { 
				String methodName="get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
				Method method = c.getMethod(methodName);
				invoke = method.invoke(f);
				// 拼接sql
				if (invoke == null || invoke instanceof Integer&& ((Integer) (invoke) == 0)) {
					continue;
				}
				// 多个邮箱账号情况
				if (invoke instanceof String) {
					if ((boolean)(invoke.toString()).contains(",")) {
						String[] value = ((String) invoke.toString()).split(",");
						sb.append(" and ").append(fieldName+" in ");
						sb.append("(");
						for (String values : value) {
							sb.append("'").append(values).append("'").append(",");
						}
						// 删掉最后的逗号
						sb.deleteCharAt(sb.length()-1);
						sb.append(')');
					}else {
						sb.append(" and ").append(fieldName+" = ").append("'").append(invoke).append("'");
					}
				}else {
					sb.append(" and ").append(fieldName+" = ").append(invoke);
				}
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
		return sb.toString();
	}
	

}
