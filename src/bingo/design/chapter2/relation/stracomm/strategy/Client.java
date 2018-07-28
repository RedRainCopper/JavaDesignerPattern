package bingo.design.chapter2.relation.stracomm.strategy;

/**
 * Created by redrain on 2017/6/14.
 */
public class Client {
    public static void main(String[] args){
        Algorithm algorithm = new Zip();
        Context context = new Context(algorithm);
        context.compress("c盘","d盘");
        context.uncompress("d盘","c盘");
    }


}
