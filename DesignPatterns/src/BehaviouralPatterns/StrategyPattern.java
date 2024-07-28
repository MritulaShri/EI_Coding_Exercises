package BehaviouralPatterns;

//Strategy interface
interface PaymentStrategy {
 void pay(int amount);
}

//Concrete strategies
class CreditCardPayment implements PaymentStrategy {
 @Override
 public void pay(int amount) {
     System.out.println("Paid " + amount + " using Credit Card.");
 }
}

class PayPalPayment implements PaymentStrategy {
 @Override
 public void pay(int amount) {
     System.out.println("Paid " + amount + " using PayPal.");
 }
}

class BitcoinPayment implements PaymentStrategy {
 @Override
 public void pay(int amount) {
     System.out.println("Paid " + amount + " using Bitcoin.");
 }
}

//Context
class PaymentContext {
 private PaymentStrategy strategy;

 public void setPaymentStrategy(PaymentStrategy strategy) {
     this.strategy = strategy;
 }

 public void pay(int amount) {
     strategy.pay(amount);
 }
}

//Usage
public class StrategyPattern {
 public static void main(String[] args) {
     PaymentContext context = new PaymentContext();

     context.setPaymentStrategy(new CreditCardPayment());
     context.pay(100);

     context.setPaymentStrategy(new PayPalPayment());
     context.pay(200);

     context.setPaymentStrategy(new BitcoinPayment());
     context.pay(300);
 }
}
