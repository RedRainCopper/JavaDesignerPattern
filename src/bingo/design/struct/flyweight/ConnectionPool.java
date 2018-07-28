package bingo.design.struct.flyweight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;


/*
 * 设计模式分析：
 * 通过连接池的管理，实现了数据库连接的共享，不需要每一次都重新创建连接，
 * 节省了数据库重新创建的开销，提升了系统的性能！
 */
public class ConnectionPool
{
	// 定义公用的变量
	String driverClassName = "";
	String url = "";
	String username = "";
	String password = "";
	
	Vector<Connection> pool ;
	int poolSize = 100;
	Connection conn = null;
	
	// 1 往池子里初始化东西
	public ConnectionPool() throws ClassNotFoundException, SQLException{
		pool = new Vector<Connection>(poolSize);
		for(int i=0;i<poolSize;i++){
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
			pool.add(conn);
		}
	}
	
	// 2 提供一个方法从池子里那东西出来
	public synchronized Connection getConnection(){
		if(pool.size()>0){
			Connection conn = pool.get(0);
			pool.remove(conn);
			return conn;
		}else{
			return null;
		}
	}
	
	// 3 将用完的东西放回池子里
	public synchronized void realease(Connection conn){
		pool.add(conn);
	}
}
