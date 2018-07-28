package bingo.design.chapter3.chianscmd;

/**
 * Created by redrain on 2017/6/15.
 */
public class LS extends AbstractLS {
    @Override
    protected String getOperateParam() {
        return super.DEFAULT_PARAM;
    }

    @Override
    protected String echo(CommandVO vo) {
        return FileManager.ls(vo.formatData());
    }
}
