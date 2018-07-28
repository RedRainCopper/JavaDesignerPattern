package bingo.design.struct.proxy.mydynamicproxy;

import java.io.*;

public class MyClassLoader extends ClassLoader{
	private File dir ;
	public MyClassLoader(String path){
		this.dir = new File(path);
	}

	/**
	 * 作用：加载class文件
	 */
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		if(dir != null){
			File clazz = new File(dir,name+".class");
			if(clazz.exists()){
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(clazz);
					
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					byte[] buffer = new byte[1024];
					int len;
					while((len = fis.read(buffer)) != -1){
						baos.write(buffer, 0, len);
					}
					// 字节码加载到内存，new出对象
					return defineClass("bingo.design.struct.proxy.mydynamicproxy."+name,baos.toByteArray(),0,baos.size());
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally{
					if(fis != null){
						try {
							fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		
		return super.findClass(name);
	}
	

}
