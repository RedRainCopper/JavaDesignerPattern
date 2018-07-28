package bingo.enhance.multithread.chapter3;

/**
 * Created by RedRain on 2018/3/17.
 * volatil特性
 * 可见性：对于一个volatile变量的读，总是能看到对这个volatile变量最后的写入
 * 原子性：对任意单个volatile变量的读/写具有原子性，但类似于volatile++这种复合操作不具有原子性
 */
public class VolatileTest {
    private volatile String str = "hello!";

    public static void main(String[] args) throws InterruptedException {
        VolatileExample exam = new VolatileExample();
        VolatileThread writerThread = new VolatileThread(exam,"write");
        VolatileThread readerThread = new VolatileThread(exam,"read");
        VolatileThread readerThread2 = new VolatileThread(exam,"read");

        Thread t1 = new Thread(writerThread,"WThread");
        Thread t2 = new Thread(readerThread,"RThread1");
        Thread t3 = new Thread(readerThread2,"RThread2");

        t2.start();

        //Thread.sleep(100);

        t1.start();

        //Thread.sleep(100);

        t3.start();

    }

    static class VolatileThread implements Runnable{
        private VolatileExample exam = new VolatileExample();
        private String method = "";

        public  VolatileThread(VolatileExample exam,String method){
            this.exam = exam;
            this.method = method;
        }

        @Override
        public void run() {
            if("write".equals(method)){
                exam.writer();
                System.out.println("VolatileThread exec writer method.."+Thread.currentThread().getName());
            }else if("read".equals(method)){
                exam.reader();
                System.out.println("VolatileThread exec reader method.."+Thread.currentThread().getName());
            }
        }
    }

    static class VolatileExample{
        int a =0;
        volatile boolean flag = false;

        public void writer(){
            a = 1;
            flag = true;
            System.out.println("Example writer Thread: "+Thread.currentThread().getName());
        }

        public void reader(){
            if (flag){
                int i = a;
                System.out.println("Example reader Thread: "+Thread.currentThread().getName()
                        + " ** reader method read: "+i);
            }
        }
    }
}
