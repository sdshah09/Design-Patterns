interface CarFactory{
    Car createCar();
    CarSpecification createSpecification();
}

class NorthAmericaCarFactory implements CarFactory{
    public Car createCar(){
        return new Sedan();
    }
    public CarSpecification createSpecification(){
        return new NorthAmericaSpecification();
    }
}

class EuropeCarFactory implements CarFactory{
    public Car createCar(){
        return new HatchBack();
    }
    public CarSpecification createSpecification(){
        return new EuropeSpecification();
    }
}

interface Car{
    void assemble();
}
interface CarSpecification{
    void display();
}

class Sedan implements Car{
    public void assemble(){
        System.out.println("Sedan car assemebled");
    }
}

class HatchBack implements Car{
    public void assemble(){
        System.out.println("Hatchback car assembled");
    }
}

class NorthAmericaSpecification implements CarSpecification{
    public void display(){
        System.out.println("North America Car specification: safety features compliant with local regulations");
    }
}

class EuropeSpecification implements CarSpecification{
    public void display(){
        System.out.println("Europe Car specification: fuel efficiency and emissions compliant with EU standards");
    }
}
public class AbstractPattern {
    public static void main(String[] args){
        NorthAmericaCarFactory northAmericaCarFactory = new NorthAmericaCarFactory();
        Car northCar = northAmericaCarFactory.createCar();
        CarSpecification northAmericaSpecification = northAmericaCarFactory.createSpecification();
        northCar.assemble();
        northAmericaSpecification.display();

        EuropeCarFactory europeCarFactory = new EuropeCarFactory();
        Car europeCar = europeCarFactory.createCar();
        CarSpecification europeSpecification = europeCarFactory.createSpecification();
        europeCar.assemble();
        europeSpecification.display();
    }    
}
