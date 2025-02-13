abstract class Vehicle{
    public abstract void printVehicle();
}

class TwoWheeler extends Vehicle{
    public void printVehicle(){
        System.out.println("I am two wheeler");
    }
}

class FourWheeler extends Vehicle{
    public void printVehicle(){
        System.out.println(("I am four wheeler"));
    }
}

// factory class

interface VehicleFactory{
    Vehicle creatVehicle();
}
// concrete class that will implement factory interface
class TwoWheelerFactory implements VehicleFactory{
    public Vehicle creatVehicle(){
        return new TwoWheeler();
    }
}

// concrete class that will implement factory interface
class FourWheelerFactory implements VehicleFactory{
    public Vehicle creatVehicle(){
        return new FourWheeler();
    }
}

// client class

class Client{
    private Vehicle pVehicle;
    public Client(VehicleFactory factory){
        pVehicle = factory.creatVehicle();
    }
    public Vehicle getVehicle(){
        return pVehicle;
    }
}

public class FactoryPattern{
    public static void main(String[] args){
        VehicleFactory twoWheelerFactory = new TwoWheelerFactory();
        Client twoWheelerClient = new Client(twoWheelerFactory);
        Vehicle twoWheeler = twoWheelerClient.getVehicle();
        twoWheeler.printVehicle();
        
        VehicleFactory fourWheelerFactory = new FourWheelerFactory();
        Client fourWheelerClient = new Client(fourWheelerFactory);
        Vehicle fourWheeler = fourWheelerClient.getVehicle();
        fourWheeler.printVehicle();

    }
}