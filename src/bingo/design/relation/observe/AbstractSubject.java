package bingo.design.relation.observe;

import java.util.ArrayList;
import java.util.List;
/**
 * 抽象类--主要用来实现功能
 * @author RedRain
 */
public abstract class AbstractSubject implements ISubject<IObserve> {
	public List<IObserve> list = new ArrayList<IObserve>();

	// 相关观察者注册进来目标类
	@Override
	public void add(IObserve t) {
		list.add(t);
	}

	@Override
	public void del() {
		
	}

	@Override
	public void aware() {
		System.out.println(this.getClass()+"抽象实现的方法开始通知观察者");
		for(IObserve observe : list){
			observe.update();
		}
		System.out.println(this.getClass()+"抽象实现的方法结束通知观察者");
	}


}
