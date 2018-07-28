package bingo.design.creative.factorymethod.c;

public abstract class Creator {
	/**
	 * 创建一个产品类
	 * 参数类型一般为 Class，String，Enum
	 * 定义返回值为产品子类
	 * @param clazz 
	 * @return
	 */
	public abstract <T extends Product> T createProduct(Class<T> clazz);	

}
