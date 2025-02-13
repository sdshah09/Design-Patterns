interface Command{
    void execute();
    void undo();
}
class LightOnCommand implements Command{
    private Light light;
    public LightOnCommand(Light light){
        this.light = light;
    }
    @Override
    public void execute(){
        light.turnOn();
    }
    @Override
    public void undo(){
        light.turnOff();
    }
}

class LightOffCommand implements Command{
    private Light light;
    public LightOffCommand(Light light){
        this.light = light;
    }
    @Override
    public void execute(){
        light.turnOff();
    }
    @Override
    public void undo(){
        light.turnOn();
    }
}

class Light{
    public void turnOn(){
        System.out.println("Lights turned On");
    }
    public void turnOff(){
        System.out.println("Lights are turned off");
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

    public void pressUndo() {  // Optional: Undo functionality
        command.undo();
    }
}

public class CommandPattern {
    public static void main(String[] args) {
        Light light = new Light();
        LightOnCommand onCommand = new LightOnCommand(light);
        LightOffCommand offCommand = new LightOffCommand(light);
        RemoteControl remote = new RemoteControl();
        remote.setCommand(onCommand);
        remote.pressButton();
        remote.pressUndo();
        remote.setCommand(offCommand);
        remote.pressUndo();
        remote.pressButton();
        remote.setCommand(onCommand);
        remote.pressButton();
    }
}
