package bingo.enhance.MyCollection;

import bingo.enhance.MyCollection.entity.Bean;

/**
 * Created by redrain on 2017-3-10.
 * 数组和集合的差别：
 * 遍历:下标的方式，从头到尾；迭代器；
 * 获取集合中的元素：下标引用；下标或者名称；
 * 增删改：增删数组无法实现；集合可以；
 *
 * 集合的实现方法：数组方式或者链表方式；
 */
public class MyCollections {
    public static void main(String[] args){
        Bean[] myBeans = new Bean[]{new Bean("A"),new Bean("B")} ;
        for(int i=0;i<myBeans.length;i++){
            System.out.println(myBeans[i]);
        }
    }
}
