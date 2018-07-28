package bingo.design.chapter2.relation.obschains.chains;

import java.util.Random;

public abstract class DnsServer {
	// 设置责任联的上一级
	private DnsServer upperServer ;
	// 本节点处理逻辑
	public final Record resolve(String domain){
		Record record ;
		if(this.isLocal(domain)){
			record = this.echo(domain);
		}else {
			record = this.upperServer.resolve(domain);
		}
		return record;
	}
	//
	public void setUpperServer(DnsServer dnsServer){
		this.upperServer = dnsServer;
	}
	
	protected abstract boolean isLocal(String domain);
	
	protected Record echo(String domain){
		Record record = new Record();
		record.setDomain(domain);
		record.setIp(this.getIpAddress());
		return record;
	}
	
	private String getIpAddress(){
		Random random = new Random();
		String ipAddress = random.nextInt(255) + "." + random.nextInt(255) + "." + random.nextInt(255) + "." + random.nextInt(255);
		return ipAddress;
	}
}
