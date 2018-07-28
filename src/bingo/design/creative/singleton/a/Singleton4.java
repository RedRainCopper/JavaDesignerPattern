package bingo.design.creative.singleton.a;
/**
 * 内部类  方式 实现单例模式
 * @author RedRain
 * 这里是利用了 Java 的语言特性，内部类只有在使用的时候，才回去加载，从而初始化内部静态变量。
 * 关于线程安全，这是 Java 运行环境自动给你保证的，在加载的时候，会自动隐形的同步。
 * 在访问对象的时候，不需要同步 Java 虚拟机又会自动给你取消同步，所以效率非常高。
 */
public class Singleton4 {
	private static class Singleton4Holder{
		private static final Singleton4 singleton = new Singleton4();
	}
	
	public static Singleton4 getInstance(){
		return Singleton4Holder.singleton;
	}
}
