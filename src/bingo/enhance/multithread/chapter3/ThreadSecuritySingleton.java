package bingo.enhance.multithread.chapter3;

import java.text.SimpleDateFormat;

/**
 * Created by redrain on 2017/4/21.
 * 线程安全问题：
 * 多个线程同时操作同一份数据
 */
public class ThreadSecuritySingleton {
	static{
		System.out.println("father init");
	}
	// 保证写先于读
	private volatile static Ticket singleton = null;
	
	// 基于volatile 关键字的内存模型
	public static Ticket getInstance(){
		if(singleton == null){
			synchronized (ThreadSecuritySingleton.class){
				if(singleton == null){
					singleton = new Ticket();
				}
			}
		}
		return singleton;
	}
	
	// 基于JVM初始化类的机制，类的初始化是线程安全的。
	private static class InstanceHolder{
		static{
			System.out.println("init");
		}
		public static Ticket ticket = new Ticket();
	}
	
	public static Ticket getInstance2(){
		System.out.println("method init");
		return InstanceHolder.ticket;
	}

    public static void main(String[] args) throws InterruptedException{
    	// 方法一
    	/*SimpleDateFormat sdf = new SimpleDateFormat("hhmmss");
    	new Ticket();
    	for (int i = 0; i < 100; i++) {
			Thread t = new Thread("Thread"+i){
				Ticket ticket = null;
				public void run(){
					ticket = ThreadSecuritySingleton.getInstance();
					System.out.println(Thread.currentThread().getName()+"--"+ticket);
				}				
			};
			t.start();
			t.join();
		}*/
    	
    	// 方法二
    	Ticket instance2 = ThreadSecuritySingleton.getInstance2();
    	System.out.println(instance2);
    }
}
