package bingo.design.chapter3.chianscmd;

/**
 * Created by redrain on 2017/6/15.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 命令抽象类
 */
public abstract class Command {
    public abstract String execute(CommandVO vo);

    protected final List<? extends CommandName> buildChins(Class<? extends CommandName> abstractCommand){
        List<Class> classes = ClassUtils.getSonClass(abstractCommand);
        List<CommandName> commandNameList = new ArrayList<CommandName>();
        for(Class clazz : classes){
            CommandName commandName = null;
            try {
                // 实例化
                commandName = (CommandName) Class.forName(clazz.getName()).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            // 设置链条
            if(commandNameList.size()>0){
                commandNameList.get(commandNameList.size()-1).setNextOperator(commandName);
            }
            commandNameList.add(commandName);
        }
        return commandNameList;
    }
}
