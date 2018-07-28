package bingo.design.creative.singleton.a;
/**
 * volatile 方式 实现单例模式
 * @author RedRain
 */
public class Singleton3 {
	private static volatile Singleton3 singleton = null; // volatile 修饰
	
	private Singleton3(){
		
	}
	
	public static Singleton3 getInstance(){
		Singleton3 singleton2 = singleton; //临时变量
		if(singleton2 == null){
			synchronized(Singleton3.class){
				singleton2 = singleton; // 
				if(singleton2 == null){
					singleton2 = new Singleton3();
					singleton = singleton2; // 写
				}
				
			}
		}
		return singleton2; // 返回临时变量
	}

}
