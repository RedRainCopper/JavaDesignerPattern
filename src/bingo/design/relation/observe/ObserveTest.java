package bingo.design.relation.observe;

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
 * 观察者模式
 * 概念：
 * 应用场景：
 * 原则分析：
 */
public class ObserveTest
{
	public static void main(String[] args)
	{
		MySubject mySubject = new MySubject();
		mySubject.add(new ObserveImpl1());
		mySubject.add(new ObserveImpl2());
		// 目标类有变化，立即通知注册到目标类中的观察者
		mySubject.operation();
	}
}
