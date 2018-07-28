package bingo.enhance.MyCollection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by redrain on 2017-3-10.
 */
public class MySet1 {
    public static void main(String[] args){
        Set<String> strSet = new TreeSet<String>(new Comparator<String>(){
            @Override
            public int compare(String a,String b){
                return a.compareTo(b);
            }
        });
        strSet.add("a");
        strSet.add("b");
        strSet.add("a");
        strSet.add("c");
        strSet.add("d");
        Iterator<String> iterator = strSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
class MyComparator implements Comparator<String>{
    @Override
    public int compare(String a,String b){
       return a.compareTo(b);
    }
}