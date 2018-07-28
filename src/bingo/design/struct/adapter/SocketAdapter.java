package bingo.design.struct.adapter;

import bingo.design.struct.adapter.Interf.DBSocketInterface;
import bingo.design.struct.adapter.Interf.GBSocketInterface;

// 对象类型适配器模式（更加灵活）
// 类 适配器模式，要继承子类。已经写死
public class SocketAdapter implements DBSocketInterface {
	// 适配器持有 被适配的引用
	private GBSocketInterface gbSocket;

	public SocketAdapter() {

	}

	public SocketAdapter(GBSocketInterface gbSocket) {
		this.gbSocket = gbSocket;
	}

	@Override
	public void powerWithTwoRound() {
		gbSocket.powerWithThreePlain();
	}

}
