package bingo.enhance.multithread.chapter4.ThreadPool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 自定义实现线程池技术
 * Created by RedRain on 2018/7/29.
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    // 线程池工作线程最大数量
    private static final int MAX_WORKER_NUMS = 10;
    // 线程池工作线程最小数量
    private static final int MIN_WORKER_NUMS = 1;
    // 线程池工作线程默认数量
    private static final int DEFAULT_WORKER_NUMS = 5;
    // 线程池工作线程当前数量
    private int workerNum = DEFAULT_WORKER_NUMS;

    // 线程池工作线程集合*
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());

    // 线程池任务列表
    private final LinkedList<Job> jobs = new LinkedList<Job>();

    // 线程编号生成
    private AtomicLong threadNum = new AtomicLong();

    public DefaultThreadPool(){
        initializeWorkers(DEFAULT_WORKER_NUMS);
    }

    public DefaultThreadPool(int num){
        workerNum = num > MAX_WORKER_NUMS ? MAX_WORKER_NUMS : num < MIN_WORKER_NUMS ? MIN_WORKER_NUMS : num;
        initializeWorkers(workerNum);
    }

    /**
     * 初始化工作者线程
     * @param num
     */
    private void initializeWorkers(int num){
        System.out.println("initialing");
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            // 新建工作者线程后直接启动
            new Thread(worker,"ThreadPool_worker_"+threadNum.incrementAndGet()).start();
        }
        System.out.println("initialed");
    }


    /**
     * 执行方法
     * 实际上是将任务添加进任务列表，并调用列表的notify方法
     * @param job
     */
    @Override
    public void execute(Job job) {
        // 多线程提交任务，需锁定任务队列
        if(null != job){
            synchronized (jobs){
                jobs.addLast(job);
                jobs.notifyAll();
            }
        }
    }

    @Override
    public void addWorkers(int num) {

    }

    @Override
    public void removeWorker(int num) {

    }

    @Override
    public void shutdown() {
        for (Worker work : workers) {
            work.shutdown();
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }


    // 工作者线程对象
    class Worker implements Runnable{
        // 为什么要用volatile
        private volatile boolean running = true;
        /**
         * 实际上就是执行jobs列表中的任务
         */
        @Override
        public void run() {
            while(running){
                // System.out.println(Thread.currentThread().getName() + " working..");
                Job job  = null;
                // 锁定工作列表
                synchronized (jobs){
                    System.out.println(Thread.currentThread().getName() + " has got lock. current jobs is " + getJobSize());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    while(jobs.isEmpty()){
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            // 如何处理中断？
                            Thread.currentThread().interrupt();
                            e.printStackTrace();
                            return;
                        }
                    }
                    job = jobs.removeFirst();
                    System.out.println(Thread.currentThread().getName() + " has got job..");
                }
                if(null != job){
                    job.run(); // 不需要构造线程，直接调用run方法。线程池的目的就是为了控制线程数量
                }
            }
        }

        public void shutdown() {
            running = false;
        }
    }

    static class JobThread implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " start running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " end...");
        }
    }

    public static void main(String[] args){
        DefaultThreadPool threadPool = new DefaultThreadPool(5);
        for (int i = 0; i < 10; i++) {
            JobThread job = new JobThread();
            threadPool.execute(job);
        }
    }
}
