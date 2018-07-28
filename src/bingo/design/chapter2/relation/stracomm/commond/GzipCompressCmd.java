package bingo.design.chapter2.relation.stracomm.commond;

/**
 * Created by redrain on 2017/6/14.
 */
public class GzipCompressCmd extends AbstractComm {
    @Override
    public boolean execute(String source, String to) {
        super.gzipReceiver.compress(source,to);
        return true;
    }
}
