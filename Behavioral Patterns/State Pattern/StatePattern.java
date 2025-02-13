interface State{
    void doAction(Context context);
}
class ConcreteStateA implements State{
    @Override
    public void doAction(Context context){
        System.out.println("State A: doing action");
        context.setState(new ConcreteStateB());
    }
}

class ConcreteStateB implements State{
    @Override
    public void doAction(Context context){
        System.out.println("State B: Doing action");
        context.setState(new ConcreteStateA());
    }
}
class Context{
    private State state;
    public Context(){
        state = new ConcreteStateA();
    }
    public void setState(State state){
        this.state = state;
    }
    public void request(){
        state.doAction(this);
    }
}
public class StatePattern {
    public static void main(String[] args) {
        Context context = new Context();
        context.request();
        context.request();
        context.request();
        context.setState(new ConcreteStateB());
        context.request();
        context.request();
        context.request();
    }
}
