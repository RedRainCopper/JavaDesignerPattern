package bingo.enhance.IO;

/**
 * Created by redrain on 2017/4/21.
 */
public class ByteTest {
    public static void main(String[] args){
        // 类型不一样，所占位数相同可以互转
        char c = 'A';
        byte b = 127;
        byte a = 1;
        a = (byte)c;
        int i = b;
        System.out.println(i);
    }
}
