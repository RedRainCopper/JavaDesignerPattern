package bingo.design.relation.decorator;

/**
 * Created by redrain on 2017-3-9.
 */
public class ConcreteDecorator extends MyDecorator {
    public ConcreteDecorator(MyComponent myComponent,String text){
        this.myComponent = myComponent;
        this.text = text;
    }
    @Override
    public void print() {
        // 调用自身的方法
        System.out.println(this.text);
        // 调用组件的方法
        myComponent.print();
    }
}
