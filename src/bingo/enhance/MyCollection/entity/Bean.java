package bingo.enhance.MyCollection.entity;

/**
 * Created by redrain on 2017-3-10.
 */
public class Bean {
    private String name;

    public Bean(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
