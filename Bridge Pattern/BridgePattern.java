interface Color{
    void applyColor();
}
class RedColor implements Color{
    @Override
    public void applyColor(){
        System.out.println("Applying Red Color");
    }
}

class BlueColor implements Color{
    @Override
    public void applyColor(){
        System.out.println("Applying Blue Color");
    }
}

abstract class Shape{
    protected Color color; // The bridge to access color interface
    public Shape(Color color){
        this.color = color;
    }
    abstract void draw();
}

class Circle extends Shape{
    public Circle(Color color){
        super(color);
    }
    @Override
    void draw(){
        System.out.println("Drawing a Circle");
        color.applyColor();
    }
}
class Square extends Shape{
    public Square(Color color){
        super(color);
    }
    @Override
    void draw(){
        System.out.println("Drawing a square");
        color.applyColor();
    }
}
public class BridgePattern {
    public static void main(String[] args){
        Color red = new RedColor();
        Color blue = new BlueColor();
        Shape redCircle = new Circle(red);
        redCircle.draw();
        Shape blueSquare = new Square(blue);
        blueSquare.draw();
        Color green = new Color(){
            @Override
            public void applyColor(){
                System.out.println("Applying Green Color");
            }
        };
        Shape greenSquare = new Square(green);
        greenSquare.draw();
    }
}
