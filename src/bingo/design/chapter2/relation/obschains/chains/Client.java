package bingo.design.chapter2.relation.obschains.chains;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {
	public static void main(String[] args) throws IOException {
		DnsServer shServer = new SHDnsServer();
		DnsServer chinaServer = new ChinaDnsServer();
		DnsServer topServer = new TopDnsServer();
		shServer.setUpperServer(chinaServer);
		chinaServer.setUpperServer(topServer);
		
		while(true){
			System.out.println("\n请输入域名（输入N退出）：");
			String domain = (new BufferedReader(new InputStreamReader(System.in))).readLine();
			if(domain.equalsIgnoreCase("n")){
				return;
			}
			Record record = shServer.resolve(domain);
			System.out.println("DNS服务器解析结果");
			System.out.println(record);
		}
	}
}
