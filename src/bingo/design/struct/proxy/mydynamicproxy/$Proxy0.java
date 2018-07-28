package bingo.design.struct.proxy.mydynamicproxy;
import java.lang.reflect.Method;
public final class $Proxy0 implements bingo.design.struct.proxy.mydynamicproxy.Subject{
MyInvocationHandler h;
public $Proxy0(MyInvocationHandler h){
this.h = h;
}
public final void rent() throws Throwable {
Method md = bingo.design.struct.proxy.mydynamicproxy.Subject.class.getMethod("rent", new Class[]{});
this.h.invoke(this, md, null);
}
public final void hello(java.lang.String param) throws Throwable {
Method md = bingo.design.struct.proxy.mydynamicproxy.Subject.class.getMethod("hello", new Class[]{});
this.h.invoke(this, md, null);
}

}