package bingo.design.chapter2.relation.stracomm.commond;

/**
 * Created by redrain on 2017/6/14.
 */
public class Invoker {
    private AbstractComm abstractComm;

    public Invoker(AbstractComm abstractComm) {
        this.abstractComm = abstractComm;
    }

    public void exec(String source,String to){
        this.abstractComm.execute(source,to);
    }
}
