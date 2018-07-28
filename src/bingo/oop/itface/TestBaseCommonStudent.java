package bingo.oop.itface;

public class TestBaseCommonStudent extends BaseCommonStudent{
	
	public static void main(String[] args) {
		TestBaseCommonStudent hy = new TestBaseCommonStudent();
		hy.chinese();
		hy.english();
		hy.math();
		hy.getScore();
		System.out.println(hy.V_CHINESE);
	}
	
}
