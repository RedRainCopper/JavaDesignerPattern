package bingo.design.chapter2.relation.stracomm.strategy;

/**
 * Created by redrain on 2017/6/14.
 */
public class Zip implements Algorithm {
    @Override
    public void compress(String source, String to) {
        System.out.println(source+" 压缩 " + to +"zip方法实现压缩");
    }

    @Override
    public void uncompress(String source, String to) {
        System.out.println(source+" 解压到 " + to +"zip方法实现解压缩");
    }
}
