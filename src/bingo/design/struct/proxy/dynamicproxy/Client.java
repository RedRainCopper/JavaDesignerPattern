package bingo.design.struct.proxy.dynamicproxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client
{
    public static void main(String[] args) throws IOException
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
        Subject subject = (Subject)Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), realSubject
                .getClass().getInterfaces(), handler);
        //Subject subject = (Subject)Proxy.newProxyInstance(Subject.class.getClassLoader(), new Class[]{Subject.class}, handler);
        
        //System.out.println(subject.getClass().getInterfaces()[0]);
        //subject.rent();
        subject.hello("world");
        
        //getProxyClazz();
    }
    
    public static void getProxyClazz() throws IOException{
    	byte[] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Subject.class});
    	FileOutputStream fileos = new FileOutputStream("$Proxy0.class");
    	fileos.write(data);
    	fileos.close();
    }
    
   

    
    
}
