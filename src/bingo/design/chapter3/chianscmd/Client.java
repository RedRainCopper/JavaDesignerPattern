package bingo.design.chapter3.chianscmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by redrain on 2017/6/15.
 */
public class Client {
    public static void main(String[] args){
        //
        /*Invoker invoker = new Invoker();
        while(true){
            try {
                String input = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                if(input.equals("quit")){
                    return;
                }
                System.out.println(invoker.exec(input));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        //
        List<String> names = CommandEnum.getNames();
        CommandEnum[] enums = CommandEnum.values();
        for (String name : names) {
            System.out.println(name);
        }
        for (CommandEnum e : enums) {
            System.out.println(e);
        }
    }
}
