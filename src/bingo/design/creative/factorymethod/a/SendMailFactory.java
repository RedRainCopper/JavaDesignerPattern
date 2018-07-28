package bingo.design.creative.factorymethod.a;


public class SendMailFactory implements MethodProvider
{

	@Override
	public Sender produce()
	{
		return new MailSender();
	}

}
