package bingo.report.iterface;

import java.util.Map;

// 在抽象类实现接口的方法，具体类就不用实现了
public abstract class BaseTemplateReport implements ITemplateReport {

	private String templateFile;// 模板文件路径

	private String configFile;// 配置文件路径

	private String targetFile;// 目标文件路径
	
	public boolean generateReportForDynamicSheet(Map<String, Object> params) {
		try {
			Object o = null;
			System.out.println(this.getClass()+"开始调用getData()返回数据");
			this.getDate(o);
			System.out.println(this.getClass()+"结束调用getData()返回数据");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public void setTemplateFile(String path, String name) {
		setTemplateFile("path:"+path+" --name:"+name);
	}

	@Override
	public void setConfigFile(String path, String name) {
		setConfigFile("path:"+path+" --name:"+name);
	}

	@Override
	public void setTargetFile(String path, String name) {
		setTargetFile("path:"+path+" --name:"+name);
	}

	@Override
	public String getTemplateFile() {
		return null;
	}

	@Override
	public String getConfigFile() {
		return null;
	}

	@Override
	public String getTargetFile() {
		return null;
	}

	public void setTemplateFile(String templateFile) {
		this.templateFile = templateFile;
	}

	public void setConfigFile(String configFile) {
		this.configFile = configFile;
	}

	public void setTargetFile(String targetFile) {
		this.targetFile = targetFile;
	}
}
