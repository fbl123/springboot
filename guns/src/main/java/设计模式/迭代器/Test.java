package 设计模式.迭代器;

import java.util.Iterator;

public class Test {


    public static void main(String[] args) {
        ContainerImpl container = new ContainerImpl();
        container.add("jick");
        container.add("123");
        container.add("tom");
        container.add("tony").add("jim");
        Iterator iterator = container.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
