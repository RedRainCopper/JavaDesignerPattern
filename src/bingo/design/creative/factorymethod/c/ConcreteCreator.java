package bingo.design.creative.factorymethod.c;

public class ConcreteCreator extends Creator {

	@Override
	public <T extends Product> T createProduct(Class<T> clazz) {
		Product product = null;
		try {
			product = clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return (T)product;
	}

}
