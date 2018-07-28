package bingo.design.chapter3.chianscmd;

/**
 * Created by redrain on 2017/6/15.
 */
public class FileManager {
    public static String ls(String path){
        return "a.txt  b.txt  \n";
    }
    public static String ls_a(String path){
        return "a.txt  .a.txt  b.txt .b.txt \n";
    }
    public static String ls_l(String path){
        return "a.txt dr-rw-rw 20170716 12:39\n " +
                ".a.txt dr-rw-rw 20170716 12:39\n" +
                " b.txt dr-rw-rw 20170716 12:39\n " +
                ".b.txt dr-rw-rw 20170716 12:39\n";
    }
}
