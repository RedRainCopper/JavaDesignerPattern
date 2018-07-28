package bingo.design.creative.factorymethod.a;


public class SendSmsFactory implements MethodProvider
{

	@Override
	public Sender produce()
	{
		return new SmsSender();
	}

}
