package bingo.enhance.multithread.chapter5.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自定义同步组件
 * Created by RedRain on 2018/7/26.
 */
public class Mutex implements Lock {
    /**
     * 队列同步器
     */
    private static class Sync extends AbstractQueuedSynchronizer{
        /**
         * 当前线程是否获取到锁
         * @return
         */
        @Override
        protected boolean isHeldExclusively() {
            return getState()==1;
        }

        /**
         * 独占式获取锁
         * @param arg
         * @return
         */
        @Override
        protected boolean tryAcquire(int arg) {
            // CAS设置获锁状态
            if(compareAndSetState(0,1)){
                // 独占式获取锁
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        /**
         * 独占式释放锁
         * @param arg
         * @return
         */
        @Override
        protected boolean tryRelease(int arg) {
            if(getState()==0){
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        Condition newCondition(){
            return new ConditionObject();
        }
    }

    private final Sync sync = new Sync();
    /**
     * 阻塞、独占式获取锁
     */
    @Override
    public void lock() {
        // 调用同步器模板方法
        sync.acquire(1);
    }

    /**
     * 阻塞、独占式、可中断获取锁
     * @throws InterruptedException
     */
    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    /**
     * 非阻塞、独占式获取锁
     * @return
     */
    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }
    /**
     * 非阻塞、独占式、超时获取锁
     * @return
     */
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    /**
     * 释放锁
     */
    @Override
    public void unlock() {
        sync.release(1);
    }

    /**
     * 等待队列等待条件
     * @return
     */
    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    public static void main(String[] args){
        Mutex mutex = new Mutex();
        mutex.lock();
        System.out.println(Thread.currentThread().getName());
        mutex.unlock();
    }
}
