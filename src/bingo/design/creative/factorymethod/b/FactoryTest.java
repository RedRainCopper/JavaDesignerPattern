package bingo.design.creative.factorymethod.b;
/**
 * 工厂方法场景类
 * @author RedRain
 */
public class FactoryTest {
	public static void main(String[] args) {
		AbstractHumanFactory factory = new HumanFactory();
		System.out.println("---------------------");
		Human white = factory.createHuman(WhiteHuman.class);
		white.getColor();
		white.talk();
		System.out.println("---------------------");
		Human balck = factory.createHuman(BlackHuman.class);
		balck.getColor();
		balck.talk();
		System.out.println("---------------------");
		Human yellow = factory.createHuman(YellowHuman.class);
		yellow.getColor();
		yellow.talk();
		
	}

}
