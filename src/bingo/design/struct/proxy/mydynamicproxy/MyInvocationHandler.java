package bingo.design.struct.proxy.mydynamicproxy;

import java.lang.reflect.Method;

public interface MyInvocationHandler {
	public Object invoke(Object object, Method method, Object[] args) throws Throwable;

}
