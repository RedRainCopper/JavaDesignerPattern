package bingo.oop.clazz;

public class Circle extends Shape{
	private Draw draw = new Draw("Circle");
	
	public String name = "Circle";
	protected  String pName = "p_Circle";
	
	public Circle(){
		System.out.println("Circle constructor");
	}
}
