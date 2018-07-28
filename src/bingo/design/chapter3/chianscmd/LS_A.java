package bingo.design.chapter3.chianscmd;

/**
 * Created by redrain on 2017/6/15.
 */
public class LS_A extends AbstractLS {
    @Override
    protected String getOperateParam() {
        return super.A_PARAM;
    }

    @Override
    protected String echo(CommandVO vo) {
        return FileManager.ls_a(vo.formatData());
    }
}
