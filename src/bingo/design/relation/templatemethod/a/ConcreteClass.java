package bingo.design.relation.templatemethod.a;

public class ConcreteClass extends AbstractClass {
	// 重写父类的基本方法
	protected void doSomethingA(){
		System.out.println("ConcreteClass doSomethingA..");
	}
	// 重写父类的基本方法
	protected void doSomethingB(){
		System.out.println("ConcreteClass doSomethingB..");
	}

}
