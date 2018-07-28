package bingo.enhance.multithread.chapter3;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by RedRain on 2018/3/17.
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args){
        Thread wait = new Thread(new Wait(),"wait Thread");
        Thread notify = new Thread(new Notify(),"notify Thread");
        wait.start();
        SleepUtils.second(1);
        notify.start();
    }
    // 等待/消费者
    static class Wait implements Runnable{
        @Override
        public void run() {
            synchronized (lock){
                // 条件不满足时等待
                while(flag){
                    try {
                        System.out.println(Thread.currentThread() + "wait@" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait(00);
                    } catch (InterruptedException e) {
                        System.out.println("Wait Thread is interrupted");
                    }
                }
                // 满足是do something
                System.out.println("do something @"+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }
    // 通知/生产者
    static class Notify implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                System.out.println(Thread.currentThread() + "hold lock.notify@" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                flag = false;
                SleepUtils.second(2);
            }
            synchronized (lock){
                System.out.println(Thread.currentThread() + "hold lock again@"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                SleepUtils.second(2);
            }
        }
    }

}
