package bingo.enhance.multithread.chapter4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by RedRain on 2017/6/30.
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args){
        Thread waitThread = new Thread(new Wait(),"WaitThread");
        Thread notifyThread = new Thread(new Notify(),"NotifyThread");
        waitThread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyThread.start();
    }

    /**
     * 充当消费者的角色
     * 1、获取锁
     * 2、判断条件是否满足？等待；业务处理；
     */
    static class Wait implements Runnable{
        public void run(){
            synchronized (lock){
                // 条件不满足时，wait，释放lock锁
                while (flag){
                    try {
                        System.out.println(Thread.currentThread() + "条件不满足，waiting..."
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread() + "条件满足，running job..." );
            }
        }
    }

    /**
     * 充当生产者的角色
     * 1、获取锁
     * 2、改变消费者条件
     * 3、通知
     */
    static class Notify implements Runnable{
        public void run(){
            synchronized (lock){
                System.out.println(Thread.currentThread() + "locking ... "
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                // 直到当前线程释放了lock后，Wait线程才能从wait方法中返回
                lock.notifyAll();
                flag = false;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            /*
            synchronized (lock){
                System.out.println(Thread.currentThread() + "locking again ... ");

            }
            */
        }
    }
}
