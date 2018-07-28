package bingo.design.creative.prototype.c;

import java.io.*;


public class Prototype implements Cloneable,Serializable
{
	private static final long serialVersionUID = 1L;
	private String string;
	private SerializableObjet obj;
	/*浅复制*/
	public Object clone() throws CloneNotSupportedException{
		Prototype proto = (Prototype) super.clone();
		return proto;
	}
	/*深复制*/
	public Object deepClone() throws IOException, ClassNotFoundException{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		return ois.readObject();
	}
	
	
	/**
	 * @return the string
	 */
	public String getString()
	{
	
		return string;
	}
	
	/**
	 * @param string the string to set
	 */
	public void setString(String string)
	{
	
		this.string = string;
	}
	
	/**
	 * @return the obj
	 */
	public SerializableObjet getObj()
	{
	
		return obj;
	}
	
	/**
	 * @param obj the obj to set
	 */
	public void setObj(SerializableObjet obj)
	{
	
		this.obj = obj;
	}
	
}

class SerializableObjet implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
}
