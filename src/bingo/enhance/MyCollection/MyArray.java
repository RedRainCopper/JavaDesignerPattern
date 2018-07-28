package bingo.enhance.MyCollection;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by redrain on 2017-3-11.
 */
public class MyArray {
    public static void main(String[] args){
        String array[] = {"a","c","d","b"};
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(array));
        System.out.println(list);
    }
    // 02 打印数组
    private static void m2() {
        String array[] = {"a","b","c","d"};
        System.out.println(Arrays.asList(array).toString());
        System.out.println(array);
    }

    // 01 声明数组
    private static void m1() {
        String aArray[] = new String[5];
        String bArray[] = {"a","b","c","d"};
        String cArray[] = new String[]{"a","b","c","d"};
    }

}
