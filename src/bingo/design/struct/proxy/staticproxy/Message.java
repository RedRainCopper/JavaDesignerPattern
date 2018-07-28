package bingo.design.struct.proxy.staticproxy;

public interface Message {
	int messageCount = -1;
	void sentMessage(String content) throws RuleException;

}
