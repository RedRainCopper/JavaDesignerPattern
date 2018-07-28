package bingo.design.struct.proxy.staticproxy;
/*
* 代理的作用：
* 代理类主要负责为委托类预处理消息、过滤消息、把消息转发给委托类，以及事后处理消息等。
* */
public class Client {
	public static void main(String[] args) {
		String content = "hello RedRain!";
		Message message = new MessageProxy(new Phone());
		try {
			message.sentMessage(content);
		} catch (RuleException e) {
			e.printStackTrace();
		}
	}

}
