package bingo.design.struct.proxy.mydynamicproxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyProxy {
    static String rt = "\r\n";

    public static Object newProxyInstance(ClassLoader loder, Class<?>[] interfaces, MyInvocationHandler handler) throws IOException {
        Class<?> targetClass = interfaces[0];
        Method[] methods = targetClass.getMethods();
        String rt = "\r\n";
        // 1、用流的方式创建一个java文件
        String proxyClass = "package bingo.design.struct.proxy.mydynamicproxy;" + rt
                + "import java.lang.reflect.Method;" + rt
                + "public final class $Proxy0 implements " + targetClass.getName() + "{" + rt
                + "MyInvocationHandler h;" + rt
                + "public $Proxy0(MyInvocationHandler h){" + rt
                + "this.h = h;" + rt
                + "}" + rt
                + getMethodString(methods, targetClass) + rt
                + "}";

        // 2、把类生成文件
        String filename = "E:/J2EE/worldspace/JavaDesignerPattern/src/bingo/design/struct/proxy/mydynamicproxy/$Proxy0.java";
        FileWriter fw = new FileWriter(new File(filename));
        fw.write(proxyClass);
        fw.flush();
        fw.close();

        // 3、编译java文件
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager filemgr = compiler.getStandardFileManager(null, null, null);
        Iterable units = filemgr.getJavaFileObjects(filename);
        CompilationTask task = compiler.getTask(null, filemgr, null, null, null, units);
        task.call();
        filemgr.close();

        // 4、class加载到内存
        MyClassLoader myLoader = new MyClassLoader("E:/J2EE/worldspace/JavaDesignerPattern/src/bingo/design/struct/proxy/mydynamicproxy/");
        try {
            Class proxy0Class = myLoader.findClass("$Proxy0");
            Constructor cons = proxy0Class.getConstructor(MyInvocationHandler.class);
            Object o = cons.newInstance(handler);
            return o;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        return null;
    }

    ;

    private static String getMethodString(Method[] methods, Class<?> targetClass) {
        String proxyMethod = "";
        for (Method method : methods) {
            method.getParameterTypes();
            proxyMethod += "public final void " + method.getName() + "(" + getMethodParamString(method) + ") throws Throwable {" + rt
                    + "Method md = " + targetClass.getName() + ".class.getMethod(\"" + method.getName() + "\", new Class[]{});" + rt
                    + "this.h.invoke(this, md, null);" + rt
                    + "}" + rt
            ;
        }
        return proxyMethod;
    }

    private static String getMethodParamString(Method method) {
        String methodParamStr = "";
        for (Class clazz : method.getParameterTypes()) {
            methodParamStr += clazz.getName() + " " + "param";
        }
        return methodParamStr;
    }

}
