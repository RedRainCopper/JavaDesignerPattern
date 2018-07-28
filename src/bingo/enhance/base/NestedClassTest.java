package bingo.enhance.base;

/**
 * Created by RedRain on 2017/7/2.
 */
public class NestedClassTest {
    public static void main(String[] args){
        NestedClass.StaticInnerClass staticInnerClass = new NestedClass.StaticInnerClass();
        staticInnerClass.printMsg();



        NestedClass nestedClass = new NestedClass();
        NestedClass.InnerClass innerClass = nestedClass.new InnerClass();
        innerClass.printMsg();
    }
}
