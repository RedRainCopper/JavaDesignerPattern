package bingo.design.creative.builder.a;

public class Director {
	Builder builder = new ConcreteBuilder();
	public Product getProduct(){
		builder.setPart();
		return builder.buildProduct();
	}
}
