package bingo.enhance.multithread.chapter1;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by redrain on 2017-4-4.
 */
public class C2 {
    public static void main(String[] args) throws InterruptedException{
    	final Map<String,String> map = new HashMap<String,String>();
        Runnable t1 = new Runnable(){
            @Override
            public void run() {
                for (int i=0;i<10000;i++){
                	new Thread(){
                		public void run(){
                			String uuid = UUID.randomUUID().toString();
                			map.put(uuid,"");
                            System.out.println(uuid );
                		}
                	}.start();
                }
            }
        };
        Thread tt = new Thread(t1);
        tt.start();
        tt.join();
    }
}
