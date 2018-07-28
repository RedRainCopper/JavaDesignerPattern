package test.java;

import java.util.Calendar;

/**
 * Created by redrain on 2017-2-25.
 */
public class test2 {
    /**
     * @param args
     */
    public static void main(String[] args)
    {

        /**
         * 获取最近12个月，经常用于统计图表的X轴
         */
        String[] strArr = getLast12Months();

        for(int i = 0; i<strArr.length;i++){
            System.out.println(strArr[i]);
        }

    }
    public static String[] getLast12Months(){

        String[] last12Months = new String[12];

        Calendar cal = Calendar.getInstance();
        //cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+1); //要先+1,才能把本月的算进去</span>
        for(int i=0; i<12; i++){
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-1); //逐次往前推1个月
            last12Months[11-i] = cal.get(Calendar.YEAR)+ "-" + (cal.get(Calendar.MONTH)+1);
        }

        return last12Months;
    }
}
