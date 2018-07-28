package bingo.design.relation.strategy;


public class Minus extends AbstractCalculator implements ICalculator
{

	@Override
	public int calculate(String exp)
	{
		int arrayInt[] = this.spilt(exp, "\\-");
		return arrayInt[0] - arrayInt[1];
	}

}
