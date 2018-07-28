package bingo.enhance.multithread.chapter3;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * Created by RedRain on 2018/3/17.
 */
public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int init) {
        if(init>0){
            for (int i = 0; i < init; i++) {
                pool.add(ConnectionDriver.createConnection());
            }
        }
    }

    public void releaseConnection(Connection conn){
        if(conn != null){
            synchronized (pool){
                pool.addLast(conn);
                pool.notifyAll();
            }
        }
    }

    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool){
            // mills小于0则没超时功能
            if(mills<0){
                if (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            // 设置超时获取功能
            }else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                if (pool.isEmpty() && remaining > 0) {
                    pool.wait(mills);
                    remaining = future - System.currentTimeMillis();
                }
                Connection conn = null;
                if (!pool.isEmpty()) {
                    conn = pool.removeFirst();
                }
                return conn;
            }
        }

    }
}
