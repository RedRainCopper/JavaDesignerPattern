package bingo.design.creative.abstractfactory.a;

public class Creator1 extends AbstractCreator {

	@Override
	public AbstractProductA createAbstractProductA() {
		return new ProductA1();
	}

	@Override
	public AbstractProductB createAbstractProductB() {
		return null;
	}

}
