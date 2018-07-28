package bingo.enhance.multithread.chapter4;

/**
 * Created by RedRain on 2018/7/28.
 */
public class Thread_SleepWait {
    public static void main(String[] args) throws InterruptedException {
        // 启动两个线程，取得锁的几率理论上是公平的
        new Thread(new WaitThread(),"WaitThread1").start();
        new Thread(new WaitThread(),"WaitThread2").start();
        Thread.sleep(100); // 确保WaitThread2拿到锁
        new Thread(new NotifyThread(),"NotifyThread").start();
    }

    private static class WaitThread implements Runnable{
        @Override
        public void run() {
            synchronized (Thread_SleepWait.class){
                System.out.println(Thread.currentThread().getName()+" is waiting...");
                try {
                    Thread_SleepWait.class.wait(); // 进入锁等待队列
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" is going on...");
            }
        }
    }
    private static class NotifyThread implements Runnable{
        @Override
        public void run() {
            synchronized (Thread_SleepWait.class){
                Thread_SleepWait.class.notify(); // 唤醒等待在该锁等待队列中的线程，使这些线程进入同步队列重新竞争锁
                System.out.println(Thread.currentThread().getName()+" call Thread_SleepWait.class's notify method...");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" is going on...");
            }
        }
    }
}
