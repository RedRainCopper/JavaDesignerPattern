package bingo.design.creative.builder.a;

public class ConcreteBuilder extends Builder {
	private Product product = new Product();

	@Override
	public void setPart() {
	}

	@Override
	public Product buildProduct() {
		return product;
	}

}
