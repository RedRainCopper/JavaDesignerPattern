package bingo.enhance.multithread.chapter4;

/**
 * Created by RedRain on 2017/7/2.
 */
public class DeadThread {
    public static void main(String[] args){

    }

    static class Thread1 implements Runnable{
        @Override
        public void run() {
            System.out.println("Thread1");
        }
    }

    static class Thread2 implements Runnable{
        @Override
        public void run() {
            System.out.println("Thread2");
        }
    }

}
