package bingo.design.relation.observe.instance;

import java.util.Observable;
import java.util.Observer;

public class Listener implements Observer {

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("RunThread 死机");
		RunThread run = new RunThread();
		run.addObserver(this);
		new Thread(run).start();
		System.out.println("RunThread 重启");
	}

}
