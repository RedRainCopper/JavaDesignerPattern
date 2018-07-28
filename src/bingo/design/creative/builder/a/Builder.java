package bingo.design.creative.builder.a;

public abstract class Builder {
	// 组装产品的不同部分
	public abstract void setPart();
	//
	public abstract Product buildProduct();
}
