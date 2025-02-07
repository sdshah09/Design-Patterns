class DVDPlayer{
    public void on(){
        System.out.println("DVD Player is On");
    }
    public void playMovie(String movie){
        System.out.println("Playing "+ movie);
    }
    public void off(){
        System.out.println("DVD player if off");
    }
}

class Projector{
    public void on(){
        System.out.println("Projector is on");
    }
    public void setInput(String input){
        System.out.println("Projector input set to " + input);
    }
    public void off(){
        System.out.println("Projector is off");
    }
}

class Amplifier{
    public void on(){
        System.out.println("Amplifier is on");
    }
    public void setVolume(int volume){
        System.out.println("Amplifier volume set to " + volume);   
    }
    public void off(){
        System.out.println("Amplifier is off");
    }
}

class HomeTheaterFacade{
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private Amplifier amplifier;

    public HomeTheaterFacade(DVDPlayer dvdPlayer, Projector projector, Amplifier amplifier){
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.amplifier = amplifier;
    }

    public void watchMovie(String movie){
        dvdPlayer.on();
        dvdPlayer.playMovie(movie);
        projector.on();
        projector.setInput("DVD");
        amplifier.on();
        amplifier.setVolume(10);
        System.out.println("Lights dimmed"); // Add a simple action
    }
    public void endMovie(){
        dvdPlayer.off();
        projector.off();
        amplifier.off();
        System.out.println("Lights on");
    }
}
public class FacadePattern {
    private DVDPlayer dvdPlayer; // Declare instance variables
    private Projector projector;
    private Amplifier amplifier;
    private HomeTheaterFacade homeTheater;

    public FacadePattern() {  // Constructor to initialize
        dvdPlayer = new DVDPlayer();
        projector = new Projector();
        amplifier = new Amplifier();
        homeTheater = new HomeTheaterFacade(dvdPlayer, projector, amplifier);
    }

    public static void main(String[] args) {
        FacadePattern facadePattern = new FacadePattern(); // Create an instance of the class
        facadePattern.homeTheater.watchMovie("The Shawshank Redemption");
        System.out.println("----------------------");
        facadePattern.homeTheater.endMovie();

    }


}
