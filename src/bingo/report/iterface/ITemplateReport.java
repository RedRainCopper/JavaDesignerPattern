package bingo.report.iterface;

public interface ITemplateReport extends IReport<Object> {
	public void setTemplateFile(String path, String name);

	public void setConfigFile(String path, String name);

	public void setTargetFile(String path, String name);
	
	public String getTemplateFile();

	public String getConfigFile();

	public String getTargetFile();
}
