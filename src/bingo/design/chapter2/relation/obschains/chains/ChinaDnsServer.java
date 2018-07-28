package bingo.design.chapter2.relation.obschains.chains;

public class ChinaDnsServer extends DnsServer {

	@Override
	protected boolean isLocal(String domain) {
		return domain.endsWith(".cn");
	}

	@Override
	protected Record echo(String domain) {
		Record record = super.echo(domain);
		record.setOwner("中国DNS服务器");
		return record;
	}
	
	

}
