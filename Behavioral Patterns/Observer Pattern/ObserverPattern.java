import java.util.ArrayList;
import java.util.List;

interface Subject{
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

class WeatherStation implements Subject{
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    public int getTemperature(){ return temperature;}
    public void setTemperature(int temperature){
        this.temperature = temperature;
        notifyObservers();
    }
    @Override
    public void registerObserver(Observer o){
        observers.add(o);
    }
    @Override
    public void removeObserver(Observer o){
        observers.remove(o);
    }
    @Override
    public void notifyObservers(){
        for(Observer observer: observers){
            observer.update(temperature);
        }
    }
}

interface Observer {
    void update(int temperature);
}

// Concrete Observer (e.g., PhoneDisplay)
class PhoneDisplay implements Observer {
    @Override
    public void update(int temperature) {
        System.out.println("Phone Display: Temperature is now " + temperature);
    }
}

// Another Concrete Observer (e.g., Thermostat)
class Thermostat implements Observer {
  @Override
  public void update(int temperature) {
    System.out.println("Thermostat: Adjusting to " + temperature + " degrees.");
  }
}
  
public class ObserverPattern {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        PhoneDisplay phoneDisplay = new PhoneDisplay();
        Thermostat thermostat = new Thermostat();

        station.registerObserver(phoneDisplay);
        station.registerObserver(thermostat);

        station.setTemperature(25);
        station.setTemperature(30);

        station.removeObserver(phoneDisplay);
        station.setTemperature(20);
    }
}
