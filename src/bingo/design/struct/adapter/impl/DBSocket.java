package bingo.design.struct.adapter.impl;

import bingo.design.struct.adapter.Interf.DBSocketInterface;

public class DBSocket implements DBSocketInterface {

	@Override
	public void powerWithTwoRound() {
		System.out.println("使用两项圆头的插孔供电");
	}

}
