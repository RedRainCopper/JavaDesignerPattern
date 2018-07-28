package bingo.enhance.multithread.chapter3;

/**
 * Created by redrain on 2017/4/21.
 */
public class Ticket {
    // 总票数，是个静态变量，只存在一份
    private static int ticketCount = 100;

    // 销售方法
    public synchronized void  saleTicket(int count){
        ticketCount = ticketCount - count;
        System.out.println(Thread.currentThread().getName()+"销售了"+count+"张票，剩余"+ticketCount);
    }
}
