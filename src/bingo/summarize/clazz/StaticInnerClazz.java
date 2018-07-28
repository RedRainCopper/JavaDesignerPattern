package bingo.summarize.clazz;

// 静态内部类
public class StaticInnerClazz
{
	// 静态内部类类似于类的静态变量
	private static class InnerClazz{
		public InnerClazz(){
			System.out.println("hello inner clazz!");
		}
	}
	
	public static void main(String[] args)
	{
		// new InnerClazz(); 只有在类的内部 new 类才能实例化它
		new StaticInnerClazz();
		System.out.println("outter clazz!");
	}

}
