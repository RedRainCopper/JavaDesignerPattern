package bingo.enhance.multithread.chapter3;

import java.util.concurrent.TimeUnit;

/**
 * Created by RedRain on 2018/3/17.
 */
public class SleepUtils {
    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
