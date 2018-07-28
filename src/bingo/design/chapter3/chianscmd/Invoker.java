package bingo.design.chapter3.chianscmd;

/**
 * Created by redrain on 2017/6/15.
 */
public class Invoker {
    public String exec(String commandStr){
        String result = "";
        CommandVO vo = new CommandVO(commandStr);
        if(CommandEnum.getNames().contains(vo.getCommandName())){
            String className = CommandEnum.valueOf(vo.getCommandName()).getValue();
            Command command;
            try {
                command = (Command)Class.forName(className).newInstance();
                result = command.execute(vo);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            result = "无法执行命令，请检查命令格式";
        }
        Command command = new LSCommand();
        return result;
    }
}
