interface AnimalVisitor{
    void visit(Lion lion);
    void visit(Elephant elephant);
    void visit(Monkey monkey);
}
class FeedingVisitor implements AnimalVisitor{
    @Override
    public void visit(Lion lion){
        System.out.println("Feeding lion raw meat");
    }
    @Override
    public void visit(Elephant elephant){
        System.out.println("Feeding grass to elephant");
    }
    @Override
    public void visit(Monkey monkey){
        System.out.println("Feeding monkey bananas");
    }
}

class CheckupVisitor implements AnimalVisitor{
    @Override
    public void visit(Lion lion){
        System.out.println("Health Checkup for lion");
    }
    @Override
    public void visit(Elephant elephant){
        System.out.println("Health Checkup for elephant");
    }
    @Override
    public void visit(Monkey monkey){
        System.out.println("Health Checkup for monkey");
    }
}

interface Animal{
    void accept(AnimalVisitor visitor);
}

class Lion implements Animal{
    @Override
    public void accept(AnimalVisitor visitor){
        visitor.visit(this);
    }
}
class Elephant implements Animal{
    @Override
    public void accept(AnimalVisitor visitor){
        visitor.visit(this);
    }
}
class Monkey implements Animal{
    @Override
    public void accept(AnimalVisitor visitor){
        visitor.visit(this);
    }
}

public class VisitorPattern {
    public static void main(String[] args) {
        Lion lion = new Lion();
        Elephant elephant = new Elephant();
        Monkey monkey = new Monkey();

        AnimalVisitor feedingVisitor = new FeedingVisitor();
        AnimalVisitor checkupVisitor = new CheckupVisitor();

        lion.accept(feedingVisitor);
        elephant.accept(checkupVisitor);
        monkey.accept(checkupVisitor);

        lion.accept(checkupVisitor);
        elephant.accept(checkupVisitor);
        monkey.accept(checkupVisitor);

        class GroomingVisitor implements AnimalVisitor{
            @Override
            public void visit(Lion lion){
                System.out.println("Grooming the lion's name");
            }
            @Override
            public void visit(Elephant elephant){
                System.out.println("Batching the elephant");
            }
            @Override
            public void visit(Monkey monkey){
                System.out.println("Brushing the monkey's fur");
            }
        }
        AnimalVisitor groomingVisitor = new GroomingVisitor();
        lion.accept(groomingVisitor);
        elephant.accept(groomingVisitor);
        monkey.accept(groomingVisitor);
    }
}
