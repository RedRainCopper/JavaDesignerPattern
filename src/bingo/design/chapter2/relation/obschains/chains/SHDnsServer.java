package bingo.design.chapter2.relation.obschains.chains;

public class SHDnsServer extends DnsServer {

	@Override
	protected boolean isLocal(String domain) {
		return domain.endsWith(".sh.cn");
	}

	@Override
	protected Record echo(String domain) {
		Record record = super.echo(domain);
		record.setOwner("上海DNS服务器");
		return record;
	}
	
	

}
