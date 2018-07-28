package bingo.design.struct.proxy.staticproxy;
/**
 * 
 * @author RedRain
 * 具体的功能类
 */
public class Phone implements Message{

	@Override
	public void sentMessage(String content) {
		System.out.println(content);
	}

}
