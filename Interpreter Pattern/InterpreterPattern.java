abstract class Expression{
    public abstract int interpret();
}
class NumberExpression extends Expression{
    private int number;
    public NumberExpression(int number){
        this.number = number;
    }
    @Override
    public int interpret(){
        return number;
    }
}
class AddExpression extends Expression{
    private Expression left;
    private Expression right;
    public AddExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }
    @Override
    public int interpret(){
        return left.interpret() + right.interpret();
    }
}

class SubtractExpression extends Expression{
    private Expression left;
    private Expression right;
    public SubtractExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }
    @Override
    public int interpret(){
        return left.interpret() + right.interpret();
    }
}
public class InterpreterPattern {
    public static void main(String[] args) {
        Expression three = new NumberExpression(3);
        Expression five = new NumberExpression(5);
        Expression two = new NumberExpression(2);
        Expression add = new AddExpression(three, five);
        System.out.println("Result: " + add.interpret());
        Expression subtract = new SubtractExpression(two, add);  
        System.out.println("Result: " + subtract.interpret());  // Output will be 6
    
    }

}
