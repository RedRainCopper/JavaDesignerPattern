package bingo.design.creative.factorymethod.a;


public class SmsSender implements Sender
{

	@Override
	public void send()
	{
		System.out.println("this is SMS sender!");
	}

}
