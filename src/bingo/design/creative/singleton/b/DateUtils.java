package bingo.design.creative.singleton.b;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtils
{
	// 懒汉模式
	private static DateFormat dateFormat ; 
	// 恶汉模式
	private static Date date = new Date();
	
	public static DateFormat getDateInstance(){
		dateFormat = new SimpleDateFormat();
		return dateFormat;
	}
	public static Date getDate(){
		return date;
	}
}
