package bingo.design.creative.singleton.a;
/**
 * Double Checked locking 实现单例模式
 * @author RedRain
 */
public class Singleton2 {
	private static Singleton2 singleton = null;
	
	private Singleton2(){
		System.out.println(123);
	}
	
	public static Singleton2 getInstance(){
		if(singleton == null){
			synchronized(Singleton2.class){
				Singleton2 singleton2 = singleton;
				if(singleton2 == null){
					singleton2 = new Singleton2();
					singleton = singleton2;
				}
			}
		}
		return singleton;
	}

}
