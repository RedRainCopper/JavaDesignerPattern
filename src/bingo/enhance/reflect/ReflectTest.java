package bingo.enhance.reflect;


import java.lang.reflect.Field;

/**
 *
 *  创建对象
 *  	new 类名
 *  访问方法
 *  	instance.method();
 *  ------------------------
 *  反射创建对象
 *  	Class.forName("").getConstructor().newInstance();
 *  访问方法
 *  	clazz.getDeclaredMethod("methodName","paramType").invoke(instance,param);
 */
public class ReflectTest {

	public static void main(String[] args) throws Exception {
		// 加载类
		Class<Student> clazz = (Class<Student>) Class.forName("bingo.enhance.reflect.Student");

		// 创建对象
		Student stu = clazz.getConstructor(String.class).newInstance();

		// 创建属性
		Field[] declaredFields = clazz.getDeclaredFields();
		for (int i = 0; i < declaredFields.length; i++) {
			Field declaredField = declaredFields[i];
			declaredField.get("name");
		}


		// 创建方法并调用
		String result =  (String) clazz.getDeclaredMethod("study", String.class)
				.invoke(stu, "eng");



		System.out.println(stu.study("english"));
	}
}
