package bingo.design.relation.strategy;

/*
 * 抽象类提供辅助方法
 */
public abstract class AbstractCalculator
{
	public int[] spilt(String exp,String opt){
		String array[] = exp.split(opt);
		int arrayInt[] = new int[2];
		arrayInt[0] = Integer.parseInt(array[0]);
		arrayInt[1] = Integer.parseInt(array[1]);
		return arrayInt;
	}
}
