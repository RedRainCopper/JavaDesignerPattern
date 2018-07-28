package bingo.design.relation.templatemethod.a;

public class ModelMethodTest {
	public static void main(String[] args) {
		AbstractClass clazz1 = new ConcreteClass();
		AbstractClass clazz2 = new ConcreteClass2();
		
		clazz1.templateMethod();
		clazz2.templateMethod();
	}

}
