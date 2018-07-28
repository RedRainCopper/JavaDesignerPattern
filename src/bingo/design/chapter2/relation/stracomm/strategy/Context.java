package bingo.design.chapter2.relation.stracomm.strategy;

/**
 * Created by redrain on 2017/6/14.
 */
public class Context {
    private Algorithm algorithm;

    /**
     *
     * @param algorithm 策略模式关键在于上下文引用中传进来的算法类型
     */
    public Context(Algorithm algorithm) {
        this.algorithm = algorithm;
    }
    public void compress(String source,String to){
        this.algorithm.compress(source,to);
    };
    public void uncompress(String source,String to){
        this.algorithm.uncompress(source,to);
    };
}
