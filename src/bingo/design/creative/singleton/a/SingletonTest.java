package bingo.design.creative.singleton.a;

public class SingletonTest {
	public static void main(String[] args) {
		Singleton4 singleton = null;
		for(int i=0;i<3;i++){
			singleton = Singleton4.getInstance();
			System.out.println(singleton);
		}
	}

	private static void test3() {
		Singleton3 singleton = null;
		for(int i=0;i<3;i++){
			singleton = Singleton3.getInstance();
			System.out.println(singleton);
		}
	}

	private static void test2() {
		Singleton2 singleton = null;
		for(int i=0;i<3;i++){
			singleton = Singleton2.getInstance();
			System.out.println(singleton);
		}
	}

	private static void test1() {
		Singleton singleton = null;
		for(int i=0;i<3;i++){
			singleton = Singleton.getInstance();
			//singleton = new Singleton();
			System.out.println(singleton);
		}
	}

}
