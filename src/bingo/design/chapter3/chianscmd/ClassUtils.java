package bingo.design.chapter3.chianscmd;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by redrain on 2017/6/15.
 */
public class ClassUtils {
    public static List<Class> getSonClass(Class fatherClass){
        List<Class> returnClassList = new ArrayList<Class>();
        String packagename = fatherClass.getPackage().getName();
        List<Class> packageClasses = getClassByPackage(packagename);
        // 将属于父类的子类加入集合
        for(Class c : packageClasses){
            if(fatherClass.isAssignableFrom(c) && !fatherClass.equals(c)){
                returnClassList.add(c);
            }
        }
        return returnClassList;
    }

    public static List<Class> getClassByPackage(String packagename){
        List<Class> returnClassList = new ArrayList<Class>();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        String path = packagename.replace(".","/");
        Enumeration<URL> resources = null;
        try {
            resources = classloader.getResources(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<File> dirs = new ArrayList<File>();
        while(resources.hasMoreElements()){
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        for(File dir : dirs){
            returnClassList.addAll(findClass(dir,packagename));
        }
        return returnClassList;
    }

    /**
     * 获取directory目录下所有class文件
     * @param directory
     * @param packageName
     * @return
     */
    public static List<Class> findClass(File directory , String packageName){
        List<Class> returnClassList = new ArrayList<Class>();
        if(!directory.exists()){
            return returnClassList;
        }
        File[] files = directory.listFiles();
        for(File file : files){
            if(file.isDirectory()){
                assert !file.getName().contains(".");
                returnClassList.addAll(findClass(file,packageName + "." + file.getName()));
            }else if(file.getName().endsWith(".class")){
                try {
                    returnClassList.add(
                            Class.forName(packageName + "." + file.getName().substring(0,file.getName().length()-6))
                    );
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return returnClassList;
    }
}
