package bingo.report.iterface;

import java.util.Map;
// 自己实现操作数据的方法
public class SummaryPaymentReportBrn extends BaseTemplateReport implements
	ICreateReport {

	// 自己实现获取数据getData接口
	@Override
	public Object getDate(Object t) throws Exception {
		System.out.println(this.getClass()+"具体类正在处理数据");
		return null;
	}

	@Override
	public String create(Map<String, Object> params) {
		System.out.println(this.getClass()+"具体类开始创建报表");
		this.generateReportForDynamicSheet(params);
		System.out.println(this.getClass()+"具体类结束创建报表");
		return null;
	}

	public static void main(String[] args) {
		SummaryPaymentReportBrn summaryPaymentReportBrn = new SummaryPaymentReportBrn();
		Map<String, Object> params = null;
		summaryPaymentReportBrn.create(params);
	}

}
