package 设计模式.工厂模式;

public class Test {


    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.createShape("1");
        shape.draw();
    }

}
