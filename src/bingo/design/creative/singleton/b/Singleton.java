/**
 * This file created at 2016年2月3日.
 *
 * Copyright (c) 2002-2016 Bingosoft, Inc. All rights reserved.
 */
package bingo.design.creative.singleton.b;

/*
 * 单例模式 与 享元模式的区别
 * 单例是作用于类级别上的，一个类只有一个对象
 * 享元模式是作用于对象级别，有可能多个对象被共享，例如：多个数据库连接对象
 */
public class Singleton
{
	private static Singleton singleton = null;

	// 私有化构造方法
	private Singleton() {
	}

	// 提供单例对象供外部访问
	public static Singleton getSingleton()
	{
		if(singleton == null){
			singleton = new Singleton();
		}
		return singleton;
	}

	/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */ //？ 这个还不太懂
	public Object readResolve()
	{
		return singleton;
	}
	
	// 优化
	/*
	1、synchronized 这个锁虽然在方法上，但是锁住的是对象
	public static synchronized Singleton getSingleton()
	{
		if(singleton == null){
			singleton = new Singleton();
		}
		return singleton;
	}
	2、synchronized 这个锁虽然在方法上，但是锁住的是对象
	public static Singleton getSingleton()
	{
		if(singleton == null){
			synchronized (singleton){
				if(singleton == null){
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}//对象的创建步骤 1 划分内存空间 2 赋值给成员变量 3 初始化类的实例
	3、静态内部类
	private static class SingleFactory{
		private static Singleton singleton = new Singleton();
	}
	public static Singleton getSingleton()
	{
		return SingleFactory.singleton;
	}// 暂时完美的答案
	4、
	public static Singleton getSingleton()
	{
		if(singleton == null){
			syncInit();
		}
		return singleton;
	}
	private static synchronized void syncInit(){//实际上跟同步对象差不多，具体区别还得斟酌
		if(singleton == null){
			singleton = new Singleton();
		}
	}
	*/
	
}
