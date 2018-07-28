package bingo.enhance.multithread.chapter3;

/**
 * Created by redrain on 2017/4/21.
 * 线程安全问题：
 * 多个线程同时操作同一份数据
 */
public class ThreadSecurity {

    public static void main(String[] args){
        // 1、相同对象
        final Ticket ticket= new Ticket();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    try {
                        Thread.sleep(10);
                    }catch(Exception e){
                    }
                    ticket.saleTicket(1);
                }
            }
        },"Thread1");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    try {
                        Thread.sleep(10);
                    }catch(Exception e){
                    }
                    ticket.saleTicket(1);
                }
            }
        },"Thread2");
        thread1.start();
        thread2.start();
    }

}
