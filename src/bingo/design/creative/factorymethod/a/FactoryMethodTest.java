package bingo.design.creative.factorymethod.a;

/*
 * 设计原则分析：
 * 拓展性:如需要增加 生产的对象，只需要再加一个实现 接口的类，和一个创建该接口的工厂类
 */
public class FactoryMethodTest
{
	public static void main(String[] args)
	{
		MethodProvider provider = new SendMailFactory();
		Sender mailSender = provider.produce();
		mailSender.send();
	}
}
