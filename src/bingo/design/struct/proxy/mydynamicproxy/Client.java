package bingo.design.struct.proxy.mydynamicproxy;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client
{
    /**
     * @param args
     * @throws Throwable 
     */
    public static void main(String[] args) throws Throwable
    {
        //    我们要代理的真实对象
        Subject realSubject = new RealSubject();

        //    我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler handler = new DynamicProxy(realSubject);

        /*
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
         * 第一个参数 handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
         * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实现的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上，代理对象的处理器
         * 这个代理对象是java运行动态生成的，并不是 编码 的类。
         */
        /*Subject subject = (Subject)Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), realSubject
                .getClass().getInterfaces(), handler);*/
        /*Subject subject = (Subject)Proxy.newProxyInstance(Subject.class.getClassLoader(), new Class[]{Subject.class}, handler);
        
        System.out.println(subject.getClass().getName());
        subject.rent();  
        subject.hello("world");  
        
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        */
//      我们要代理的真实对象
        Subject realSubject2 = new RealSubject();

        //    我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        MyInvocationHandler handler2 = new MyDynamicProxy(realSubject2);

        Subject subject2 = (Subject)MyProxy.newProxyInstance(Subject.class.getClassLoader(), new Class[]{Subject.class}, handler2);
        
        subject2.rent();
        //subject2.hello("world");
        
        
        
    }
    
    /*private static Class< > findClass() throws MalformedURLException, ClassNotFoundException { 
	try { return enableAsserts(Class.forName(defaultJavaCompilerName, false, null)); } 
	catch (ClassNotFoundException e) { // ignored, try looking  else where 
	} 
	File file = new File(System.getProperty("java.home")); 
	if (file.getName().equalsIgnoreCase("jre")) file = file.getParentFile(); 
	for (String name : defaultToolsLocation) file = new File(file, name); 
	URL[] urls = {file.toURI().toURL()}; 
	ClassLoader cl = URLClassLoader.newInstance(urls); 
	cl.setPackageAssertionStatus("com.sun.tools.javac", true); 
	return Class.forName(defaultJavaCompilerName, false, cl); 
	}
}*/
}
