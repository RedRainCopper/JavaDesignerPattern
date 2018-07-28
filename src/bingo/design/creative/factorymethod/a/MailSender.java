package bingo.design.creative.factorymethod.a;


public class MailSender implements Sender
{

	@Override
	public void send()
	{
		System.out.println("this is MAIL sender!");
	}

}
