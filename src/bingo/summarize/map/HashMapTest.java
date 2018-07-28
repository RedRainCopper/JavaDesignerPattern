package bingo.summarize.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class HashMapTest
{
	public static void main(String[] args)
	{
		Map<String,String> map = new HashMap<String,String>();
		map.put("key1", "v1");
		map.put("key2", "v2");
		map.put("key3", "v3");
		Set<Entry<String,String>> set = map.entrySet();
		Iterator<Entry<String, String>> iterator = set.iterator();
		while(iterator.hasNext()){
			Entry<String, String>  entry = iterator.next();
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println("key: "+key+" value: "+value);
		}
	}
}
