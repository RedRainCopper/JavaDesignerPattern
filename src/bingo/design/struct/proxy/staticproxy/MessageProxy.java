package bingo.design.struct. proxy.staticproxy;

/**
 * 
 * @author RedRain
 * 消息对象代理器
 * 切面插入功能
 */
public class MessageProxy implements Message {
	private int messageCount;
	public int getMessageCount() {
		return messageCount;
	}

	public void setMessageCount(int messageCount) {
		this.messageCount = messageCount;
	}

	// 代理对象持有的被代理对象
	private Message message = null;

	/**
	 * 被代理的对象
	 * @param message
	 */
	public MessageProxy(Message message){
		this.message = message;
	}
	
	@Override
	public void sentMessage(String content) throws RuleException {
		if(check(content)){
			messageCount++ ;
			// 可以在此处做代理类统一处理的业务代码，前提：被代理类统一实现同个接口
			this.message.sentMessage(content);
			//System.out.println(this.messageCount); // 计数业务
		}else{
			throw new RuleException("字数不符合标准");
		};
	}

	private boolean check(String content) {
		return content != null & content.length()>10;
	}
	
	

}
