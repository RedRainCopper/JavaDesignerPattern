package bingo.enhance.multithread.chapter5;

/**
 * Created by redrain on 2017-4-4.
 */
public class DeadThread extends Thread{
    public void run(){
        System.out.println();

    }

    public static void main(String[] args){
        DeadThread t1 = new DeadThread();
        DeadThread t2 = new DeadThread();

    }
}
