package bingo.enhance.base;

/**
 * Created by RedRain on 2017/7/2.
 */
public class NestedClass {
    private static String sMsg = "静态变量";
    private String msg = "非静态变量";

    static class StaticInnerClass{
        public void printMsg(){
            System.out.println("静态内部类访问静态变量"+sMsg);
            // 静态内部类不能访问非静态成员
            // System.out.println("静态内部类访问静态变量"+msg);
        }
    }

    class InnerClass{
        public void printMsg(){
            System.out.println("非静态内部类访问静态变量"+sMsg);
            System.out.println("非静态内部类访问静态变量"+msg);
        }
    }

}
