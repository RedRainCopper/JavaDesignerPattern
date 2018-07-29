package bingo.enhance.multithread.chapter10.FutureTask;

import java.util.concurrent.*;

/**
 * Created by RedRain on 2018/7/29.
 */
public class FutureTaskTest {
    private final ConcurrentMap<Object,Future<String>> taskCache
            = new ConcurrentHashMap<Object,Future<String>>();

    private String executionTask(final String taskName){
        Future<String> future = taskCache.get(taskName);  //
        if(future == null){
            Callable<String> task = new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return taskName;
                }
            };
            FutureTask<String> futureTask = new FutureTask<String>(task); // 创建任务
            future = taskCache.putIfAbsent(taskName,futureTask); //
            if(future == null){
                future = futureTask;
                futureTask.run(); //
            }
        }
        try {
            return future.get();//
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (CancellationException e) { // 取消任务
            taskCache.remove(taskName,future);
        }
        return null;
    }

}
