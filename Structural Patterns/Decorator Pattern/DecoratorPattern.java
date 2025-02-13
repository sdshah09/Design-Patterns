interface Coffee{ // Component Inteface
    String getDescription();
    double getCost();
}

// Concrete Component (SimpleCoffee)
class SimpleCoffee implements Coffee{
    @Override
    public String getDescription(){
        return "Simple Coffee";
    }
    @Override
    public double getCost(){
        return 2.0;
    }
}

// Abstract decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;
    public CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }
    @Override
    public String getDescription(){
        return coffee.getDescription();
    }
    @Override
    public double getCost(){
        return coffee.getCost();
    }
    
}

// Concrete Decorators (Add-ons)
class Milk extends CoffeeDecorator{
    public Milk(Coffee coffee){
        super(coffee);
    }
    @Override
    public String getDescription(){
        return super.getDescription() + ", with Milk";
    }
    @Override
    public double getCost(){
        return super.getCost() + 0.5;   
    }
}

class Sugar extends CoffeeDecorator{
    public Sugar(Coffee coffee){
        super(coffee);
    }
    @Override
    public String getDescription(){
        return super.getDescription() + ", with Sugar";
    }
    @Override
    public double getCost(){
        return super.getCost() + 0.2;
    }
}

public class DecoratorPattern {
    public static void main(String[] args){
        Coffee myCoffee = new SimpleCoffee();
        System.out.println(myCoffee.getDescription() + " - $" + myCoffee.getCost());

        myCoffee = new Milk(myCoffee);
        System.out.println(myCoffee.getDescription() + " - $" + myCoffee.getCost()); // Simple Coffee, with Milk - $2.5

        myCoffee = new Sugar(myCoffee);
        System.out.println(myCoffee.getDescription() + " - $" + myCoffee.getCost()); // Simple Coffee, with Milk, with Sugar - $2.5


    }
}
