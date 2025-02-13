interface Character{
    Character clone();
    String getType();
    int getHealth();
    void setHealth(int health);
    int getAttackPower();
    int getSpeed();
    void display();
}

class Warrior implements Character{
    private int health;
    private int attactPower;
    private int speed;
    public Warrior(int health, int attackPower, int speed){
        this.health = health;
        this.attactPower = attackPower;
        this.speed = speed;
    }
    @Override
    public Warrior clone(){
        return new Warrior(this.health, this.attactPower, this.speed);
    }
    @Override
    public String getType(){
        return "Warrior";
    }
    @Override
    public int getHealth(){
        return health;
    }
    @Override
    public void setHealth(int health){
        this.health = health;
    }
    @Override
    public int getAttackPower(){
        return attactPower;
    }
    @Override
    public int getSpeed(){
        return speed;
    }
    @Override
    public void display() {
        System.out.println("Type: " + getType() + ", Health: " + getHealth() +
                           ", Attack: " + getAttackPower() + ", Speed: " + getSpeed());
    }

}
class Mage implements Character {
    private int health;
    private int magicPower;
    private int speed;

    public Mage(int health, int magicPower, int speed) {
        this.health = health;
        this.magicPower = magicPower;
        this.speed = speed;
    }

    @Override
    public Mage clone() {
        return new Mage(this.health, this.magicPower, this.speed);
    }

    @Override
    public String getType() {
        return "Mage";
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    public int getMagicPower() {
        return magicPower;
    }

    public void setMagicPower(int magicPower) { // Setter for magicPower
        this.magicPower = magicPower;
    }

    @Override
    public int getAttackPower() {
        return magicPower * 2; // Example calculation
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void display() {
        System.out.println("Type: " + getType() + ", Health: " + getHealth() +
                           ", Magic Power: " + getMagicPower() + ", Speed: " + getSpeed());
    }
}

public class PrototypePattern {
    public static void main(String[] args) {
        Warrior warriorPrototype = new Warrior(100,20,10);
        Mage magePrototype = new Mage(80, 30, 12);

        Warrior warrior1 = warriorPrototype.clone();
        Mage mage1 = magePrototype.clone();

        warrior1.setHealth(150);
        mage1.setMagicPower(40);

        System.out.println("Warrior Prototype Health: " + warriorPrototype.getHealth()); // Still 100
        System.out.println("Warrior 1 Health: " + warrior1.getHealth());             // Now 150
        System.out.println("Mage Prototype Magic Power: " + magePrototype.getMagicPower()); // Still 30
        System.out.println("Mage 1 Magic Power: " + mage1.getMagicPower());                 // Now 40
        Warrior warrior2 = warriorPrototype.clone();
        System.out.println("Warrior 2 Health: " + warrior2.getHealth()); // Still 100 (independent)

        warrior2.setHealth(75);
        System.out.println("Warrior 2 Health: " + warrior2.getHealth()); // Now 75, warrior1 is still 150

        warrior1.display();
        warrior2.display();
        mage1.display();


    }
}
