package bingo.report.iterface;

public interface IReport<T> {
	public Object getDate(T t) throws Exception;
}
