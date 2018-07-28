package bingo.design.relation.decorator;

/**
 * Created by redrain on 2017-3-9.
 */
public class ConcreteComponent1 extends MyComponent{

    public ConcreteComponent1(){
    }
    public ConcreteComponent1(String text){
       this.text = text;
    }
    public void print(){
        System.out.println(this.text);
    }
}
