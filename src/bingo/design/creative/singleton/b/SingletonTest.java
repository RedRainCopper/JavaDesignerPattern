package bingo.design.creative.singleton.b;

import java.text.DateFormat;
/*
 * 设计模式学习步骤：
 * 1、设计模式的概念、特点
 * 2、应用场景
 * 3、设计模式原则分析
 */
/* 创见性模式：工厂方法模式、抽象工厂模式、单例模式、创建者模式、原型模式。
 * 单例模式（工厂方法模式）
 * 1、懒汉模式（需要的是候才创建）
 * 2、恶汉模式
 */ 
public class SingletonTest
{
	public static void main(String[] args) throws InterruptedException
	{
		//test1();
		// 懒汉模式有线程安全问题（怎么测试？）
		Thread thread1 = new Thread();
		for(int i=0;i<10;i++){
			thread1.sleep(1000);
			System.out.println(DateUtils.getDateInstance());
		}
		test1();
	}

	// 基本测试
	private static void test1()
	{
		DateFormat dateFormat = DateUtils.getDateInstance();
		DateFormat dateFormat2 = DateUtils.getDateInstance();
		System.out.println(dateFormat);
		System.out.println(dateFormat2);
		System.out.println(dateFormat.equals(dateFormat2));// 地址这个字符串是相等的
	}
}
