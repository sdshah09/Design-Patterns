interface PaymentStrategy{
    void pay(double amount);
}
class CreditCardPayment implements PaymentStrategy{
    @Override
    public void pay(double amount){
        System.out.println("Paid $" + amount + " using Credit Card");
    }
}

class PayPalPayment implements PaymentStrategy{
    @Override
    public void pay(double amount){
        System.out.println("Paid $" + amount + " using PayPal");
    }
}

class ShoppingCart{
    private PaymentStrategy paymentStrategy;
    public ShoppingCart(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;;
    }
    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }
    public void checkout(double amount){
        paymentStrategy.pay(amount);
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart(new CreditCardPayment());
        shoppingCart.checkout(25.50);
        shoppingCart.setPaymentStrategy(new PayPalPayment());
        shoppingCart.checkout(10.0);
    }
}
