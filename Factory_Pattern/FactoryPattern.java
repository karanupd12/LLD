package Factory_Pattern;

interface Shape{
    void draw();
}

class Circle implements Shape{
    @Override
    public void draw(){
        System.err.println("This is Circle");
    }
}

class Rectangle implements Shape{
    @Override
    public void draw(){
        System.err.println("This is Rectangle");
    }
}

class Square implements Shape{
    @Override
    public void draw(){
        System.err.println("This is Square");
    }
}

class ShapeFactory{

    Shape getShape(String shapeType){
        if(shapeType == null) return null;

        switch(shapeType.toUpperCase()){
            case "CIRCLE" : 
                return new Circle();
            case "RECTANGLE" : 
                return new Rectangle();
            case "SQUARE" : 
                return new Square();
            default : 
                System.out.println("Invalid Shape Type");
                return null;  
        }
    }
}


public class FactoryPattern {
    public static void main(String[] args) {
        ShapeFactory shapeFactoryObj = new ShapeFactory();
        Shape shapeObj1 = shapeFactoryObj.getShape("circle");
        Shape shapeObj2 = shapeFactoryObj.getShape("SQUARE");
        shapeObj1.draw();
        shapeObj2.draw();
    }
}

