package bingo.enhance.multithread.chapter1;

/**
 * Created by RedRain on 2018/7/28.
 */
public class TestStaticClazz {
    public static void main(String[] args){
        StaticClazz.Main test = new StaticClazz.Main();
        test.method1();
        StaticClazz.Main.main();


    }

}
