class Computer{
    private String processor;
    private String motherboard;
    private int ram;
    private String storage;
    private String graphicsCard;
    private String caseType;
    private String powerSupply;

    private Computer(ComputerBuilder builder){
        this.processor = builder.processor;
        this.motherboard = builder.motherboard;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.caseType = builder.caseType;
        this.powerSupply = builder.powerSupply;
    }
    public String getProcessor() { return processor; }
    public String getMotherboard() { return motherboard; }
    public int getRam() { return ram; }
    public String getStorage() { return storage; }
    public String getGraphicsCard() { return graphicsCard; }
    public String getCaseType() { return caseType; }
    public String getPowerSupply() { return powerSupply; }

    @Override
    public String toString(){
        return "Computer{" +
                "processor='" + processor + '\'' +
                ", motherboard='" + motherboard + '\'' +
                ", ram=" + ram +
                ", storage='" + storage + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", caseType='" + caseType + '\'' +
                ", powerSupply='" + powerSupply + '\'' +
                '}';
    }

    public static class ComputerBuilder{
        private String processor;
        private String motherboard;
        private int ram;
        private String storage;
        private String graphicsCard;
        private String caseType;
        private String powerSupply;

        public ComputerBuilder(String processor,String motherboard){
            this.processor = processor;
            this.motherboard = motherboard;
        }
        public ComputerBuilder ram(int ram){
            this.ram = ram;
            return this; // Important to return the current object so everytime if we want some specification we don't always need to create different objects
        } // this is called builder instance for chaining
        public ComputerBuilder storage(String storage){
            this.storage = storage;
            return this;
        }
        public ComputerBuilder graphicsCard(String graphicsCard){
            this.graphicsCard = graphicsCard;
            return this;
        }
        public ComputerBuilder caseType(String caseType){
            this.caseType = caseType;
            return this;
        }
        public ComputerBuilder powerSupply(String powerSupply){
            this.powerSupply = powerSupply;
            return this;
        }
        public Computer build(){
            return new Computer(this); // returns the current object of computerbuilder to computer class
        }
    
    }
}
public class BuilderPattern {
    public static void main(String[] args) {
        Computer myComputer = new Computer.ComputerBuilder("Intel i9", "ASUS Z790")
        .ram(32)
        .storage("1TB SSD")
        .graphicsCard("Nvidia RTX 4090")
        .caseType("Cooler Master H500")
        .powerSupply("1000W")
        .build();

        System.out.println(myComputer);

        Computer basicComputer = new Computer.ComputerBuilder("AMD Ryzen 7", "ASRock B550")
                                    .ram(16)
                                    .storage("500Gb SSD")
                                    .build();
        System.out.println(basicComputer);

    }
}

