package bingo.enhance.sequence;

/**
 * Created by redrain on 2017/4/19.
 */
public class TestB extends TestA {
    public TestB(){
        System.out.println("TestB");
    }

    {
        System.out.println("i am TestB");
    }

    static{
        System.out.println("TestB static init..");
    }

    public static void main(String[] args){
        TestB b = new TestB();
    }
}
