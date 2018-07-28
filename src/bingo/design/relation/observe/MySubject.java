package bingo.design.relation.observe;

public class MySubject extends AbstractSubject {

	/*
	 * 抽象类没实现的方法，具体类要实现
	 * @see bingo.design.relation.observe.ISubject#operation()
	 */
	@Override
	public void operation() {
		System.out.println(this.getClass()+"目标类状态开始变化。。。");
		this.aware();
		System.out.println(this.getClass()+"目标类状态结束变化。。。");
	}

}
