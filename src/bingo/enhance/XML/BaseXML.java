package bingo.enhance.XML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BaseXML {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream(new File("f://3.sql"));
			byte[] b = new byte[1024];
			String str;
			while(fis.read(b)!=-1){
				fis.read(b);
				str = new String(b,"utf-8");
				System.out.println(str);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
