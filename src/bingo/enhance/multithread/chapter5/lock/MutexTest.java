package bingo.enhance.multithread.chapter5.lock;

import bingo.enhance.multithread.chapter3.SleepUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by RedRain on 2018/7/27.
 */
public class MutexTest {
    public static void main(String[] args){
        final Mutex lock = new Mutex();
        class Worker extends Thread{
            @Override
            public void run() {
                while(true){
                    lock.lock();
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("---"+Thread.currentThread().getName());
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            Worker worker = new Worker();
            //worker.setDaemon(true);
            worker.start();
        }
    }
}
