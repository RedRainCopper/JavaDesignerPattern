package bingo.design.chapter2.relation.stracomm.commond;

/**
 * Created by redrain on 2017/6/14.
 */
public class GzipUncompressCmd extends AbstractComm {
    @Override
    public boolean execute(String source, String to) {
        super.gzipReceiver.uncompress(source,to);
        return true;
    }
}
