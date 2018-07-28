package bingo.enhance.base;

public class BaseDataType {

	public static void main(String[] args) {
		char c = '\u0061'; // unicode 编码
		String str = "abc";
		
		//getUnicode(str);
		//(int)str.charAt(1); 将字符转换成 int 类型
		System.out.println(Integer.toHexString(97));//将
	}

	public static String getUnicode(String source) {
		String returnUniCode = null;
		String uniCodeTemp = null;
		for (int i = 0; i < source.length(); i++) {
			uniCodeTemp = "\\u" + Integer.toHexString((int) source.charAt(i));// 使用char类的charAt()的方法
			returnUniCode = returnUniCode == null ? uniCodeTemp : returnUniCode
					+ uniCodeTemp;
		}
		System.out.print(source + " 's unicode = " + returnUniCode);
		return returnUniCode;// 返回一个字符的unicode的编码值
	}

}
