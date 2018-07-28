package bingo.design.chapter2.relation.obschains.chains;

public class TopDnsServer extends DnsServer {

	@Override
	protected boolean isLocal(String domain) {
		return true;
	}

	@Override
	protected Record echo(String domain) {
		Record record = super.echo(domain);
		record.setOwner("顶级DNS服务器");
		return record;
	}
	
	

}
