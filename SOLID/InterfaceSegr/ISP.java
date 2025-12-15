package SOLID.InterfaceSegr;

// Interface Segregation Principle : Clients should not depend on unused methods  //here in example, robotWorker can not eat, so we made a separate interface to handle eat ability
// (Multiple small interfaces are better than one large interface.)


interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class HumanWorker implements Workable, Eatable{
    public void work(){
        System.out.println("Human working");
    }

    public void eat(){
        System.out.println("Human eating");
    }
}

class RobotWorker implements Workable{
    public void work(){
        System.out.println("Robot working");
    }
}

public class ISP {
    public static void main(String[] args) {
        RobotWorker robot = new RobotWorker();
        robot.work();

        HumanWorker human = new HumanWorker();
        human.work();
        human.eat();
    }
}
