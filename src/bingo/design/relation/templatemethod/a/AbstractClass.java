package bingo.design.relation.templatemethod.a;

public class AbstractClass {
	// 基本方法 
	/**
	 * protected 符合迪米特法则，私有方法尽量不暴漏
	 */
	protected void doSomethingA(){
		System.out.println("AbstractClass doSomethingA..");
	}
	// 基本方法
	protected void doSomethingB(){
		System.out.println("AbstractClass doSomethingB..");
	}
	// 模板方法
	public void templateMethod(){
		this.doSomethingA();
		this.doSomethingB();
	}
}
