package bingo.enhance.multithread.chapter4.ThreadPool;

/**
 * 线程池通用接口
 * 1、线程池维护着固定数量的工作者线程处理客户端提交的任务
 * 2、任务与执行分离，职责更加分明。方便客户端调用和服务端维护
 *
 * Created by RedRain on 2018/7/29.
 */
public interface ThreadPool<Job extends Runnable>{
    // 执行客户端提交任务
    void execute(Job job);

    // 增加工作者线程
    void addWorkers(int num);

    // 减少工作者线程
    void removeWorker(int num);

    // 关闭线程池
    void shutdown();

    // 获取工作者线程数量
    int getJobSize();
}
