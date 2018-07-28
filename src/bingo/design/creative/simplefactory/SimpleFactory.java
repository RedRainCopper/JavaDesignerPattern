package bingo.design.creative.simplefactory;

/*
 * 简单工厂模式（简单工厂模式不属于23种设计模式）
 */
public class SimpleFactory
{
	// 用静态变量作为 类型 的标志，防止写错
	public static final String MAILSENDER = "Mail";
	public static final String SMSSENDER = "SMS";
	/**
	 * 
	 * @param type 输入需要创建的发送类型
	 * @return
	 */
	public Sender produceSender(String type){
		if(MAILSENDER.equals(type)){
			return new MailSender();
		}else if(SMSSENDER.equals(type)){
			return new SmsSender();
		}else{
			System.out.println("please input the corret type!");
			return null;
		}
	}
}
