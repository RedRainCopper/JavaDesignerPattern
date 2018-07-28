package bingo.design.creative.abstractfactory.a;

public class Creator2 extends AbstractCreator {

	@Override
	public AbstractProductA createAbstractProductA() {
		return new ProductA2();
	}

	@Override
	public AbstractProductB createAbstractProductB() {
		return null;
	}

}
