package bingo.design.creative.simplefactory;


public class SmsSender implements Sender
{

	@Override
	public void send()
	{
		System.out.println("this is SMS sender!");
	}

}
