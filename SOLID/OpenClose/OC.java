package SOLID.OpenClose;

// Open/Close Principle :  New behavior is added via new classes, not by modifying existing ones.0 
// (Open for extension, closed for modification)

interface Discount{
    double apply(double price);
}

class FestivalDiscount implements Discount{
    public double apply(double price){
        return price * 0.9;    //10% discount
    }
}

class MembershipDiscount implements Discount{
    public double apply(double price){
        return price * 0.8;    //20% discount
    }
}

class PriceCalculator{
    double calculate(double price, Discount discount){
        return discount.apply(price);
    }
}

public class OC {
    public static void main(String[] args) {
        PriceCalculator calc = new PriceCalculator();
        System.out.println(calc.calculate(1000, new FestivalDiscount()));
        System.out.println(calc.calculate(1000, new MembershipDiscount()));
    }
}
