package bingo.design.chapter2.relation.stracomm.strategy;

/**
 * Created by redrain on 2017/6/14.
 */
public interface Algorithm {
    public void compress(String source,String to);
    public void uncompress(String source,String to);
}
