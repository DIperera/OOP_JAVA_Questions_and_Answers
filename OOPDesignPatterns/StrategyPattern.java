package beforefinal;

//Strategy Interface
interface PaymentStrategy {
 void pay(int amount);
}

//Concrete Strategy: Credit Card
class CreditCardPayment implements PaymentStrategy {
 private String cardNumber;

 public CreditCardPayment(String cardNumber) { 
     this.cardNumber = cardNumber;
 }
@Override
 public void pay(int amount) {
     System.out.println("Paid $" + amount + " using Credit Card: " + cardNumber); 
 }
}

//Concrete Strategy: PayPal
class PayPalPayment implements PaymentStrategy {
 private String email;

 public PayPalPayment(String email) {
     this.email = email;
 }
 @Override
 public void pay(int amount) {
     System.out.println("Paid $" + amount + " using PayPal: " + email);
 }
}

//Context
class ShoppingCart {
 private PaymentStrategy paymentStrategy; 

 public void setPaymentStrategy(PaymentStrategy strategy) { 
     this.paymentStrategy = strategy; 
 }

 public void checkout(int amount) {
    // if (paymentStrategy == null) {
    //     System.out.println("Payment method not selected.");
    // } else {
         paymentStrategy.pay(amount); 
   //  }
 }
}

//Client
class StrategyPatternExample {
 public static void main(String[] args) {
     ShoppingCart cart = new ShoppingCart();

     // Pay using Credit Card
     cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
     cart.checkout(100);//amount to pay

     // Pay using PayPal
     //cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
     //cart.checkout(250);
 }
}

