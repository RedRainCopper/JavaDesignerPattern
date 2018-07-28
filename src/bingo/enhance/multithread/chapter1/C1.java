package bingo.enhance.multithread.chapter1;

/**
 * Created by redrain on 2017-4-4.
 */
public class C1 {
    public static void main(String[] args){
        try {
        	System.out.println(123);
            Thread.sleep(100*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
