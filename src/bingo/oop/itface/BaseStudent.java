package bingo.oop.itface;

public abstract class BaseStudent implements IOtherCourse{
	public String AS_IS_Loacl = "Y";
	
	public void chinese(){
		System.out.println("-------abstract learning chinese-------");
	};
	
	public void english(){
		System.out.println("-------abstract learning english-------");
	};	
	
	public void math(){
		System.out.println("-------abstract learning math-------");
	};	
	
	// 抽象类新增了一个方法；
	// 抽象类新增方法调用实现的接口的方法，但该方法在抽象类中并没有实现，所有实际上调用的是实现抽象类的类的方法
	public void getScore(){
		System.out.println("abstract+++++++"+this.getTotalScore()+"+++++++");
	};
}
