package SOLID.LiskovSubst;

/*
Liskov Substitution Principle : Child classes don’t break parent behavior contracts.(Subtypes must be replaceable for their base types)
Ask yourself:

“If I swap the parent with this child everywhere, will anything break or behave differently?”
If yes → LSP violation
If no → LSP respected
*/

interface Bird{
    void eat();
}

interface FlyingBird extends Bird{
    void fly();
}

class Sparrow implements FlyingBird{
    public void eat(){
        System.out.println("Sparrow eating");
    }

    public void fly(){
        System.out.println("Sparrow Flying");
    }
}

class Penguin implements Bird{
    public void eat(){
        System.out.println("Penguine eating");
    }
}

public class LSP {
    public static void main(String[] args) {
        Bird b1 = new Sparrow();
        Bird b2 = new Penguin();

        b1.eat();
        b2.eat();
    }
}
