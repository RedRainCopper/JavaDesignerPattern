package bingo.enhance.sequence;

/**
 * Created by redrain on 2017/4/19.
 */
public class TestA {
    public TestA(){
        System.out.println("TestA");
    }

    {
        System.out.println("i am TestA");
    }

    static{
        System.out.println("TestA static init..");
    }
}
