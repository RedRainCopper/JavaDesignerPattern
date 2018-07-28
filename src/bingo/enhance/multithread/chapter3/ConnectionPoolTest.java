package bingo.enhance.multithread.chapter3;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by RedRain on 2018/3/17.
 */
public class ConnectionPoolTest {
    static ConnectionPool pool = new ConnectionPool(10);
    static CountDownLatch start = new CountDownLatch(1);
    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;

        end = new CountDownLatch(threadCount);

        int count = 20;
        AtomicInteger got = new AtomicInteger(); // ??
        AtomicInteger noGot = new AtomicInteger();

        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count,got,noGot),"ConnRunner"+i);
            thread.start();
        }

        start.countDown();
        end.await();

        System.out.println("total conn is: " + (threadCount * count));
        System.out.println("got is: " + got);
        System.out.println("noGot is: " + noGot);
    }

    static class ConnectionRunner implements Runnable{
        int count ;
        AtomicInteger got;
        AtomicInteger noGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger noGot) {
            this.count = count;
            this.got = got;
            this.noGot = noGot;
        }

        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while(count>0){
                try {
                    Connection conn = pool.fetchConnection(1000);
                    if(conn != null){
                        try{
                            conn.createStatement();
                            conn.commit();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } finally {
                            pool.releaseConnection(conn);
                            got.incrementAndGet();
                        }
                    }else{
                        noGot.incrementAndGet();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    count --;
                }
            }
            end.countDown();
        }
    }
}
