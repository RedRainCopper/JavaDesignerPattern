package bingo.design.chapter3.chianscmd;

/**
 * Created by redrain on 2017/6/15.
 */
public class DFCommand extends Command {
    @Override
    public String execute(CommandVO vo) {
        CommandName firstNode = super.buildChins(AbstractLS.class).get(0);
        return firstNode.handleMessage(vo);
    }
}
