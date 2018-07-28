package bingo.oop.clazz;

public class TestExtends {
	
	public TestExtends(){
		
	}
	
	public static void main(String[] args) {
		Shape shape = new Circle();
		System.out.println(shape.name);
		System.out.println(shape.pName);
	}

	private static void testLoading() {
		// 类的加载顺序  先执行父类的成员变量，再构造函数
		Circle circle = new Circle();
		
		/*
		    Shape Draw constructor
			Shape constructor
			Circle Draw constructor
			Circle constructor
		 **/
	}
	
	
}
