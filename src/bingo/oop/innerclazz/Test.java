package bingo.oop.innerclazz;

public class Test{
	public Test() {
		
	}
	
	public static void main(String[] args) {
		// 初始化  成员内部类
		Test.Bean1 bean1 = (new Test()).new Bean1();
		// 初始化  静态内部类
		Test.Bean2 bean2 = new Test.Bean2();
		// 初始化  成员内部类
		Bean3.Bean4 bean4 = (new Bean3()).new Bean4();
	}
	
	// 成员内部类
	class Bean1{
		public int i = 0;
	}
	
	// 静态内部类
	static class Bean2{
		public int j = 0;
	}
}

// 没有 public 修饰符的类
class Bean3{
	class Bean4{
		public int k = 0;
	}
}
