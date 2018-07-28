package bingo.design.relation.decorator;

/**
 * Created by redrain on 2017-3-9.
 */
public class Test {
    public static void main(String[] args){
        MyComponent textComponent = new ConcreteComponent1("text...");
        MyDecorator headDecorator = new ConcreteDecorator (textComponent,"head..");
        MyDecorator footDecorator = new ConcreteDecorator (headDecorator,"tail..");

        footDecorator.print();
    }
}
