package 设计模式.迭代器;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContainerImpl implements Container {
    private List<String> names=new ArrayList<>();


    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }




    public ContainerImpl add(String name){
        names.add(name);
        return this;
    }


    class NameIterator implements Iterator{
        int index;

        @Override
        public boolean hasNext() {
            if (index < names.size())
                return true;
            else
                return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return names.get(index++);
            }
            return null;
        }
    }
}
