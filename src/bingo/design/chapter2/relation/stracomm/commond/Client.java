package bingo.design.chapter2.relation.stracomm.commond;

/**
 * Created by redrain on 2017/6/14.
 */
public class Client {
    public static void main(String[] args){
        AbstractComm commond = new ZipCompressCmd();
        Invoker invoker = new Invoker(commond);
        invoker.exec("c","d ");
    }
}
