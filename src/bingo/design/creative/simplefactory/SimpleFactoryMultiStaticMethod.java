package bingo.design.creative.simplefactory;

/*
 * 简单工厂模式（简单工厂模式不属于23种设计模式）
 */
public class SimpleFactoryMultiStaticMethod
{
	public static Sender produceMailSender(){
			return new MailSender();
	}
	public static Sender produceSmsSender(){
		return new SmsSender();
	}
}
