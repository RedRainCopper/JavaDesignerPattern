package bingo.design.relation.observe;

public class ObserveImpl2 implements IObserve {

	@Override
	public void update() {
		System.out.println(this.getClass()+"具体的观察者开始更新状态");
	}

}
