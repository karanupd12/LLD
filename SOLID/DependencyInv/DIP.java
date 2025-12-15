package SOLID.DependencyInv;

// Dependency Inversion Principle : High-level logic depends on interfaces, not concrete implementations.
// (High-level modules depend on abstractions)


interface PaymentGateway{
    void pay(int amount);
}

class PayPalGateway implements PaymentGateway{
    public void pay(int amount){
        System.out.println("Paid via PayPal : Rs." + amount);
    }
}

class StripeGateway implements PaymentGateway{
    public void pay(int amount){
        System.out.println("Paid via Stripe : Rs." + amount);
    }
}

class PaymentService{
    private PaymentGateway gateway;

    public PaymentService(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    void makePayment(int amount){
        gateway.pay(amount);
    }
}

public class DIP {
    public static void main(String[] args) {
        PaymentService service1 = new PaymentService(new PayPalGateway());
        service1.makePayment(2000);

        PaymentService service2 = new PaymentService(new StripeGateway());
        service2.makePayment(3000);
    }
}
