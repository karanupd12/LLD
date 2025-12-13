package Decorator_Pattern;

// Base interface for all Pizza types
interface Pizza {
    String getDescription();
    int getCost();
}

// Concrete base pizza without any toppings
class PlainPizza implements Pizza {

    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public int getCost() {
        return 100;
    }
}

// Abstract decorator that wraps a Pizza object
abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}

// Concrete decorator that adds Cheese topping
class CheeseToppings extends PizzaDecorator {

    public CheeseToppings(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Cheese";
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 30;
    }
}

// Concrete decorator that adds Mushroom topping
class MushroomToppings extends PizzaDecorator {

    public MushroomToppings(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Mushroom";
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 40;
    }
}

// Concrete decorator that adds Paneer topping
class PaneerToppings extends PizzaDecorator {

    public PaneerToppings(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Paneer";
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 25;
    }
}

// Client class demonstrating Decorator pattern usage
public class DecoratorPattern {

    public static void main(String[] args) {

        // Create base pizza
        Pizza pizza = new PlainPizza();
        System.out.println(pizza.getDescription() + " -> Rs." + pizza.getCost());

        // Add toppings dynamically at runtime 
        pizza = new CheeseToppings(pizza);     //costs 40, so pizza = 140
        pizza = new MushroomToppings(pizza);   //costs 30, so pizza = 170
        pizza = new PaneerToppings(pizza);     //costs 25, so pizza = 195

        System.out.println(pizza.getDescription() + " -> Rs." + pizza.getCost());
    }
}
