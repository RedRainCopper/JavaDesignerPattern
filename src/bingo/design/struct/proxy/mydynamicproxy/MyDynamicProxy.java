package bingo.design.struct.proxy.mydynamicproxy;

import java.lang.reflect.Method;
/**
 * 代理类的处理器
 * @author RedRain
 */
public class MyDynamicProxy implements MyInvocationHandler
{
    //　这个就是我们要代理的真实对象
    private Object subject;
    
    //    构造方法，给我们要代理的真实对象赋初值
    public MyDynamicProxy(Object subject)
    {
        this.subject = subject;
    }
    
    /*
     * 
     * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
     * Object 最终的代理对象
     * method 被代理对象的方法
     */
    @Override
    public Object invoke(Object object, Method method, Object[] args)
            throws Throwable
    {
        //　　在代理真实对象前我们可以添加一些自己的操作
        System.out.println("my before rent house");

        System.out.println("my Object:" + object);
        System.out.println("my Method:" + method);
        
        
        //    当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        method.invoke(subject, args);
        
        
        //　　在代理真实对象后我们也可以添加一些自己的操作
        System.out.println("my after rent house");
        
        return null;
    }

}