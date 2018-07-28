package bingo.enhance.multithread.chapter1;

/**
 * Created by RedRain on 2018/7/28.
 */
public class StaticClazz {

    private String name = "Tom";
    private static boolean flag = false;

    public static void main(String[] args){
        Main test = new Main();

    }

    /**
     * 静态内部类
     * 当外部类需要使用内部类，而内部类无需外部类资源，并且内部类可以单独创建的时候会考虑采用静态内部类的设计
     */

    static class Main{
        static String age = "10";
        String gender = "1";
        static void main(){
            // 调用外部类
            System.out.println(StaticClazz.flag);
            StaticClazz.print2();
        }

        void method1(){
            // 静态内部类的方法可以访问外部类的静态变量和方法，不能直接方法非静态变量和方法
            System.out.println(StaticClazz.flag);
            StaticClazz.print2();
        }
    }

    class Main2{
        String gender = "1";
    }

    public void print(){
        System.out.println("running");
    }

    public static void print2(){
        System.out.println("running static method 2 ...");
    }


}
