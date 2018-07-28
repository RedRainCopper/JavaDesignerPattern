package bingo.report.iterface;

import java.util.Map;
// 通用操作数据的方法
public class TestGenerateCommonReport extends GenerateCommonReport {
	@Override
	public String create(Map<String, Object> params) {
		// 1设置参数
		// 2调用具体生成报表类
		System.out.println(this.getClass()+"继承通用类的具体实现类开始创建报表");
		this.generateReportForDynamicSheet(params);
		System.out.println(this.getClass()+"继承通用类的具体实现类结束创建报表");
		return null;
	}

	public static void main(String[] args) {
		TestGenerateCommonReport testGenerateCommonReport =  new TestGenerateCommonReport ();
		Map<String, Object> params = null;
		testGenerateCommonReport.create(params );
	}

}
