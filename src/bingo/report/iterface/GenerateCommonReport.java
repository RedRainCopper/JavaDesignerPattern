package bingo.report.iterface;

import java.util.Map;
// 通用操作数据的方法
public class GenerateCommonReport extends BaseTemplateReport implements
	ICreateReport {

	// 通用类实现获取数据getData接口
	@Override
	public Object getDate(Object t) throws Exception {
		System.out.println(this.getClass()+"具体类正在处理数据");
		return null;
	}

	@Override
	public String create(Map<String, Object> params) {
		// 子类自己覆盖
		return null;
	}

}
