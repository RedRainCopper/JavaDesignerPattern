package bingo.design.creative.simplefactory;
/*
 * 简单工厂模式
 * 分类：普通简单工厂、多方法简单工厂、静态多方法简单工厂
 * 应用场景：需要大量产 生实现共同接口的类。
 * 原则分析：
 * 缺点：类的创建依赖工厂类，如果要拓展程序，必须对工厂类进行修改，这个违背了闭包原则
 * 解决：工厂方法模式
 */
public class SimpleFactoryTest
{

	public static void main(String[] args)
	{
		Sender sender =  SimpleFactoryMultiStaticMethod.produceMailSender();
		sender.send();
	}

	private static void normal()
	{
		SimpleFactory factory = new SimpleFactory();
		Sender sender = factory.produceSender(SimpleFactory.MAILSENDER);
		sender.send();
	}

}
