// import java.io.*;

class Singleton {
    private static Singleton instance;
    private Singleton(){
        System.out.println("Singleton is instantiated");
    }
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    } 
    public static void doSomething(){
        System.out.println("Something is done");
    }   
}

class SingletonPattern{
    public static void main(String[] args){
        Singleton.getInstance().doSomething();
    }
}
