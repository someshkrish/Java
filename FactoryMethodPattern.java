package com.company;

interface DrawShape {
    default void drawing() {
        System.out.println("Drawing for default implementation");
    }
}

class Square implements DrawShape {
    @Override
    public void drawing() {
        System.out.println("Drawing Square shape...");
    }
}

class Rectangle implements DrawShape {
    @Override
    public void drawing() {
        System.out.println("Drawing Rectangle shape...");
    }
}

class Circle implements DrawShape {
    @Override
    public void drawing(){
        System.out.println("Drawing Circle shape...");
    }
}

class Factory {
    public DrawShape getShape(String shape) {
        if(shape.equalsIgnoreCase("Circle")){
            return new Circle();
        }
        else if(shape.equalsIgnoreCase("Rectangle")){
            return new Rectangle();
        }
        else if(shape.equalsIgnoreCase("Square")){
            return new Square();
        }
        return new DrawShape() {
        };
    }
}

public class FactoryMethodPattern {
    public static void main(String[] args) {
        Factory obj = new Factory();

        //Default implementation
        DrawShape shapeObj = obj.getShape("");
        shapeObj.drawing();

        //Square
        DrawShape square = obj.getShape("Square");
        square.drawing();

        //Rectangle
        DrawShape rectangle = obj.getShape("Rectangle");
        rectangle.drawing();

        //Circle
        DrawShape circle = obj.getShape("Circle");
        circle.drawing();
    }
}
