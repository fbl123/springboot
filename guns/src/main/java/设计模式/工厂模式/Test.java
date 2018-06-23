package 设计模式.工厂模式;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {


    public static void main(String[] args) {
//        ShapeFactory shapeF
        Date date=new Date(1498391898962L);
        System.out.println(date);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
    }

}
