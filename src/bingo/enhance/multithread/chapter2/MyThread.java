package bingo.enhance.multithread.chapter2;

/**
 * Created by redrain on 2017/4/5.
 */
public class MyThread extends Thread {
    class SleepThread extends Thread {
        public void run() {
            try {
                sleep(2000);
                System.out.println("sleep 2s");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MyThread -- "+new java.util.Date().getTime());
        }
    }

    public static void main(String[] args) throws Exception {
        MyThread thread = new MyThread();
        SleepThread sleepThread = thread.new SleepThread();
        sleepThread.start(); // 开始运行线程sleepThread
        sleepThread.join(); // 使线程sleepThread延迟2秒
        thread.start();
        boolean flag = false;
        while (true) {
            sleep(5000); // 使主线程延迟5秒
            System.out.println("sleep 5s");
            flag = !flag;
            if (flag)
                thread.suspend(); //挂起线程
            else
                thread.resume(); //唤醒线程
        }
    }
}
