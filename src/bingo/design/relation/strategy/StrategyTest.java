package bingo.design.relation.strategy;

/*
 * 关系模式
 * 1、父类与子类的关系
 * 		策略模式、模板方法模式
 * 2、两个类之间
 * 		观察者模式、迭代模式、责任链模式、命令模式
 * 3、类的状态
 * 		备忘录模式、状态模式
 * 4、中间类
 * 		访问者模式、中介者模式、解释器模式
 */
/*
 * 策略模式
 * 概念：
 * 策略模式定义了一系列的算法，并将每个算法封装起来，使他们可以相互替换，且算法的改变不会影响到使用算法的客户。
 * 应用场景：
 * 原则分析：
 */
public class StrategyTest
{
	public static void main(String[] args)
	{

		String exp = "2+8";
		ICalculator cal = new Minus();
		int result = cal.calculate(exp);
		System.out.println(result);
	}
}
