package bingo.design.chapter3.chianscmd;

/**
 * Created by redrain on 2017/6/15.
 */

/**
 * 抽象命令名称
 */
public abstract class CommandName {
    private CommandName nextOperator;

    public final String handleMessage(CommandVO vo) {
        // 处理结果
        String result = "";
        // 模板方法
        if (vo.getParamList().size() == 0 || vo.getParamList().contains(this.getOperateParam())) {
            // ls -al 这种格式没处理，每个命令节点处理完后，继续后续节点的处理
            result = this.echo(vo);
        } else {


            if (this.nextOperator != null) {
                result = this.nextOperator.handleMessage(vo);
            } else {
                result = "命令无法执行！";
            }
        }
        return result;
    }

    // 责任链衔接的关键
    public void setNextOperator(CommandName nextOperator) {
        this.nextOperator = nextOperator;
    }

    // 每个处理者处理的后缀参数，每个节点处理的区别
    protected abstract String getOperateParam();

    // 每个处理者要处理的任务，具体处理任务
    protected abstract String echo(CommandVO vo);
}
