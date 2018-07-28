package bingo.design.chapter3.chianscmd;

/**
 * Created by redrain on 2017/6/15.
 */
public class LSCommand extends Command {
    @Override
    public String execute(CommandVO vo) {
        // to-do ls -al 格式这里要修改，将个责任链的结果组装起来
        CommandName firstNode = super.buildChins(AbstractLS.class).get(0);
        return firstNode.handleMessage(vo);
    }
}
