package bingo.enhance.multithread.chapter4;

/**
 * volatile 相当于同步操作这个成员变量的方法
 * --线程间竞争锁是随机的
 * Created by RedRain on 2017/7/3.
 */
public class VolatileTest {
    volatile int i = 0;

    public void writer(){
        this.i = 1;
    }

    public int read(){
        return this.i;
    }

    public static void main(String[] args){
        final VolatileTest  test = new VolatileTest();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println( "before " + test.read() );
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                test.writer();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println( "after " + test.read() );
            }
        });


        t2.start();
        t1.start();

    }
}
