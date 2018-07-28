package bingo.enhance.multithread.chapter2;

/**
 * Created by redrain on 2017/4/6.
 */
public class ThreadFlag extends Thread{
    public volatile boolean exit = false;

    public void run() {
        while (!exit)
            ;
    }

    public static void main(String[] args) throws Exception {
        ThreadFlag thread = new ThreadFlag();
        thread.start();
        sleep(5000); // 主线程延迟5秒
        thread.exit = true; // 终止线程thread
        thread.join();
        System.out.println("线程退出!");
    }
}
