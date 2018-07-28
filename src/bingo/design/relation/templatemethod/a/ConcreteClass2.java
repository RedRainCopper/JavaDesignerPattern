package bingo.design.relation.templatemethod.a;

public class ConcreteClass2 extends AbstractClass {
	// 重写父类的基本方法
	protected void doSomethingA(){
		System.out.println("ConcreteClass2 doSomethingA..");
	}
	// 重写父类的基本方法
	protected void doSomethingB(){
		System.out.println("ConcreteClass2 doSomethingB..");
	}

}
