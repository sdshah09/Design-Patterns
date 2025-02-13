import java.util.HashMap;
import java.util.Map;

interface Tree{
    void draw(int x, int y); // x and y are extrinsic state(position)
} 
class TreeType implements Tree{
    private String name;
    private String color;
    private String texture;
    public TreeType(String name, String color, String texture){
        this.name = name;
        this.color = color;
        this.texture = texture;
    }
    @Override
    public void draw(int x, int y){
        System.out.println("Drawing " + name + " tree at (" + x + ", " + y + ") with color " + color + " and texture " + texture);

    }
    public String getName() {return name;}
    public String getColor() {return color;}
    public String getTexture() {return texture;}
}

class TreeFactory{
    private static Map<String,TreeType> treeTypes = new HashMap<>();
    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + "-" + color + "-" + texture; // Unique key for each TreeType
        TreeType treeType = treeTypes.get(key);
        if(treeType==null){
            treeType = new TreeType(name, color, texture);
            treeTypes.put(key,treeType);
            System.out.println("Creating new TreeType: " + name); // Show when a new Flyweight is created
        }
        return treeType;
    }
    public static int getTreeTypeCount() {
        return treeTypes.size();
    }


}
public class FlyweightPattern {
    public static void main(String[] args) {
        TreeType oakTreeType = TreeFactory.getTreeType("Oak", "Green", "Rough");
        TreeType pineTreeType = TreeFactory.getTreeType("Pine", "Green", "Needles");
        TreeType oakTreeType2 = TreeFactory.getTreeType("Oak", "Green", "Rough"); // Reuse existing Flyweight

        // Draw trees using the Flyweights and extrinsic state (position)
        oakTreeType.draw(10, 20);
        pineTreeType.draw(30, 40);
        oakTreeType.draw(50, 60);  // Same TreeType, different position
        oakTreeType2.draw(70, 80); // Same TreeType, different position (and reused Flyweight)

        System.out.println("\nNumber of TreeTypes created: " + TreeFactory.getTreeTypeCount()); 
    }
}
