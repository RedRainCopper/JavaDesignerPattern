package bingo.design.chapter3.chianscmd;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by redrain on 2017/6/15.
 */
public class CommandVO {
    private static final String DIVIDE_FLAG = " ";
    private static final String PREFIX = "-";
    private String commandName = "";
    private List<String> paramList = new ArrayList<String>();
    private List<String> dataList = new ArrayList<String>();

    public CommandVO(String commandStr) {
        if(commandStr != null && commandStr.length() != 0){
            String[] complexStr = commandStr.split(DIVIDE_FLAG);
            this.commandName = complexStr[0];
            for (int i = 1; i < complexStr.length; i++) {
                String s = complexStr[i];
                if( s.indexOf(PREFIX)==0 ){
                    this.paramList.add(s.replace(PREFIX,"").trim());
                }else{
                    this.dataList.add(s.trim());
                }
            }
        }
    }

    public String getCommandName() {
        return commandName;
    }

    public List<String> getParamList() {
        // 处理为空的情况
        if(this.paramList.size()==0){
            this.paramList.add("");
        }
        // 去重
        return new ArrayList<String>(new HashSet<String>(this.paramList));
    }

    public List<String> getDataList() {
        return dataList;
    }

    public String formatData() {
        return null;
    }
}
