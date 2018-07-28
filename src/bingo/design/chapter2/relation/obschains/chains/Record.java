package bingo.design.chapter2.relation.obschains.chains;

public class Record {
	private String domain;
	private String ip;
	private String owner;
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	@Override
	public String toString() {
		String result = "域名：" + this.getDomain() 
						+ "\nIP：" + this.getIp()
						+ "\n属主：" + this.getOwner();		
		return result;
	}
}
