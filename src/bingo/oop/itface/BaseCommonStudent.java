package bingo.oop.itface;

public class BaseCommonStudent extends BaseStudent{
	
	@Override
	public void chinese() {
		System.out.println("  *******class learning chinese*******  AS_IS_Loacl "+this.AS_IS_Loacl);
	}

	@Override
	public void physical() {
		System.out.println("*******class learning physical*******");
	}

	@Override
	public void art() {
		System.out.println("*******class learning art*******");
	}
    
	// 相当于报表通用类实现的getData方法
	@Override
	public int getTotalScore() {
		return 100;
	}
	
	

}
