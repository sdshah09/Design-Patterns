interface Image{
    void display();
}

class RealImage implements Image{
    private String fileName;
    public RealImage(String filename){
        this.fileName = filename;
        loadFromDisk(); // Simulate loading from disk
    }
    public void loadFromDisk(){
        System.out.println("loading" + fileName + " from disk");
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    @Override
    public void display(){
        System.out.println("Displaying " + fileName);
    }
}

class ProxyImage implements Image{
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename){
        this.filename = filename;
    }
    @Override
    public void display(){
        if(realImage == null){
            realImage = new RealImage(filename); // Load only when needed
        }
        realImage.display();
    }
}
public class ProxyPattern {
    public static void main(String[] args) {
        Image image = new ProxyImage("photo.jpg");
        System.out.println("Image object created, but not loaded yet."); //Proof
        image.display();
        image.display();
        Image anotherImage = new ProxyImage("picture.png");
        anotherImage.display();
    }
}
