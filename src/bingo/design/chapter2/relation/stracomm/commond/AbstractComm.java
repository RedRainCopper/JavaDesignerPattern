package bingo.design.chapter2.relation.stracomm.commond;

/**
 * Created by redrain on 2017/6/14.
 */
public abstract class AbstractComm {

    protected IReceiver zipReceiver = new ZipReceiver();
    protected IReceiver gzipReceiver = new GzipReceiver();
    public abstract boolean execute(String source,String to);
}
