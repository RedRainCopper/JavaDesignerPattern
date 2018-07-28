package bingo.enhance.multithread.chapter2;

/**
 * Created by redrain on 2017/4/6.
 */
public class ThreadInterrupt extends Thread {
    public void run() {
        try {
            sleep(10000); // 延迟10秒
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        Thread thread = new ThreadInterrupt();
        thread.start();
        System.out.println("在10秒之内按任意键中 断线程!");
        System.in.read();
        thread.interrupt();
        thread.join();
        System.out.println("线程已经退出!");
    }
}
