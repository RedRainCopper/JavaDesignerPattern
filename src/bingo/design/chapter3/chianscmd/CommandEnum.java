package bingo.design.chapter3.chianscmd;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by redrain on 2017/6/15.
 */
public enum CommandEnum {

    ls("bingo.design.chapter3.chianscmd.LSCommand"),
    df("bingo.design.chapter3.chianscmd.DFCommand");

    private String value = "";

    // 定义构造函数，目的是data(value)相匹配
    private CommandEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static List<String> getNames(){
        CommandEnum[] enums = CommandEnum.values();
        List<String> names = new ArrayList<String>();
        for(CommandEnum c : enums){
            names.add(c.name());
        }
        return names;
    }
}
