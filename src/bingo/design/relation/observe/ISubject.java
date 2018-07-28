package bingo.design.relation.observe;
/**
 * 目标类，即被观察类
 * @author RedRain
 */
public interface ISubject<T> {
	public void add(T t);
	public void del();
	public void aware();
	public void operation();
}
