package bingo.design.struct.adapter;

import bingo.design.struct.adapter.Interf.DBSocketInterface;
import bingo.design.struct.adapter.Interf.GBSocketInterface;
import bingo.design.struct.adapter.impl.DBSocket;
import bingo.design.struct.adapter.impl.GBSocket;

public class HotelTest {
	public static void main(String[] args) {
		//初始化一个国标插座对象， 用一个国标接口引用它
        GBSocketInterface gbSoket = new GBSocket();
         
        //创建一个旅馆对象
        Hotel hotel = new Hotel(new SocketAdapter(gbSoket));
         
        //在旅馆中给手机充电
        hotel.charge();
	}

	private static void dbTest() {
		//初始化一个德国插座对象， 用一个德标接口引用它
        DBSocketInterface dbSoket = new DBSocket();
         
        //创建一个旅馆对象
        Hotel hotel = new Hotel(dbSoket);
         
        //在旅馆中给手机充电
        hotel.charge();
	}
}
