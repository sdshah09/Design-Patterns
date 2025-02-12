interface Handler{
    void handle(String request);
    void setNext(Handler next);
}

class ConcreteHandler1 implements Handler{
    private Handler handler;
    @Override
    public void handle(String request){
        if(request.equals("Request1")){
            System.out.println("Request handled by Handler1");
        }
        else if(handler!=null){
            handler.handle(request);
        }
        else{
            System.out.println("No Handler to handler this request");
        }
    }
    @Override
    public void setNext(Handler handler){
        this.handler = handler;
    }
}

class ConcreteHandler2 implements Handler{
    private Handler handler;
    @Override
    public void handle(String request){
        if(request.equals("Request2")){
            System.out.println("Request handled by Handler 2");
        }
        else if(handler!=null){
            handler.handle(request);
        }
        else{
            System.out.println("No handler to handle this request");
        }
    }
    @Override
    public void setNext(Handler handler){
        this.handler = handler;
    }

}
class ConcreteHandler3 implements Handler{
    private Handler handler;
    @Override
    public void handle(String request){
        if(request.equals("Request3")){
            System.out.println("Request handled by Handler 3");
        }
        else if(handler!=null){
            handler.handle(request);
        }
        else{
            System.out.println("No handler to handle this request");
        }
    }
    @Override
    public void setNext(Handler handler){
        this.handler = handler;
    }

}


public class COR {
    public static void main(String[] args) {
        ConcreteHandler1 handler1 = new ConcreteHandler1();
        ConcreteHandler2 handler2 = new ConcreteHandler2();
        ConcreteHandler3 handler3 = new ConcreteHandler3();
        handler1.setNext(handler2);
        handler2.setNext(handler3);
        handler1.handle("Request1");
        handler1.handle("Request2");
        handler1.handle("Request3");
        handler1.handle("Request4");
    }

}
