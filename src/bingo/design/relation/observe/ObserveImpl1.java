package bingo.design.relation.observe;
/**
 * 具体的观察者
 * @author RedRain
 */
public class ObserveImpl1 implements IObserve {

	@Override
	public void update() {
		System.out.println(this.getClass()+"具体的观察者开始更新状态");
	}

}
