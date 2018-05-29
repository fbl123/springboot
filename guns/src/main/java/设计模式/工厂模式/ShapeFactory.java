package 设计模式.工厂模式;

public class ShapeFactory {

    Shape createShape(String type) {
        switch (type) {
            case "1":
                return new Circle();
            case "2":
                return new Square();
            case "3":
                return new Rectangle();
            default:
                return null;
        }


    }
}
