# SOLID Principles in OOPS

SOLID is a set of five object-oriented design principles designed to make software **maintainable, scalable, and easy to understand**.

## The 5 Principles
- **S – Single Responsibility Principle (SRP)**
- **O – Open/Closed Principle (OCP)**
- **L – Liskov Substitution Principle (LSP)**
- **I – Interface Segregation Principle (ISP)**
- **D – Dependency Inversion Principle (DIP)**

## Advantages
1. Avoids duplicate code  
2. Easy to maintain codebase  
3. Improves readability  
4. Enables flexible software development  
5. Reduces complexity  

---

# 1. Single Responsibility Principle (SRP)

### **Definition**  
A class should have only one reason to change — it should handle **one job only**.

### ❌ Bad Example
```java
class Report {
    void generateReport() { System.out.println("Report generated"); }
    void saveToFile() { System.out.println("Report saved to file"); }
}
````

### ✅ Good Example

```java
class Report {
    void generateReport() { System.out.println("Report generated"); }
}

class ReportSaver {
    void saveToFile(Report report) { System.out.println("Report saved to file"); }
}
```

---

# 2. Open/Closed Principle (OCP)

### **Definition**

Classes should be **open for extension** but **closed for modification**.
New behavior must be added **without modifying** existing code.

### ❌ Bad Example

```java
class AreaCalculator {
    double calculate(Object shape) {
        if (shape instanceof Circle c) return Math.PI * c.radius * c.radius;
        else if (shape instanceof Rectangle r) return r.length * r.width;
        return 0;
    }
}
```

### ✅ Good Example

```java
interface Shape { double area(); }

class Circle implements Shape {
    double radius;
    Circle(double r) { radius = r; }
    public double area() { return Math.PI * radius * radius; }
}

class Rectangle implements Shape {
    double length, width;
    Rectangle(double l, double w) { length = l; width = w; }
    public double area() { return length * width; }
}

class AreaCalculator {
    double calculate(Shape shape) { return shape.area(); }
}
```

---

# 3. Liskov Substitution Principle (LSP)

### **Definition**

Subclasses must be substitutable for their base classes **without breaking expected behavior**.
i.e; Subclass should extend the capability of base class not narrow it down.
### ❌ Bad Example

```java
class Bird {
    void fly() { System.out.println("Bird flying"); }
}

class Ostrich extends Bird {
    @Override
    void fly() { throw new RuntimeException("Ostrich cannot fly"); }
}
```

### Why It Fails

Code that expects every `Bird` to fly breaks when Ostrich is passed.

### ✅ Good Example

```java
interface Bird {}

interface FlyingBird extends Bird { void fly(); }

class Sparrow implements FlyingBird {
    public void fly() { System.out.println("Sparrow flying"); }
}

class Ostrich implements Bird {
    // correct: Ostrich doesn't fly, so it's not a FlyingBird
}
```

---

# 4. Interface Segregation Principle (ISP)

### **Definition**

Clients should **not be forced** to depend on methods they don’t use.
Interfaces must be **small, focused, and specific**. i.e; modular and purpose driven.


### ❌ Bad Example

```java
interface Worker {
    void work();
    void eat();
    void sleep();
}

class Robot implements Worker {
    public void work() {}
    public void eat() {}   // irrelevant
    public void sleep() {} // irrelevant
}
```

### ✅ Good Example

```java
interface Workable { void work(); }
interface Feedable { void eat(); }
interface Restable { void sleep(); }

class Human implements Workable, Feedable, Restable {
    public void work() {}
    public void eat() {}
    public void sleep() {}
}

class Robot implements Workable {
    public void work() {}
}
```

---

# 5. Dependency Inversion Principle (DIP)

### **Definition**

* High-level modules should not depend on low-level modules.
* Both should depend on **abstractions (interfaces)**.
* Abstractions should not depend on details – details depend on abstractions.

i.e; Classes should depend on interfaces rather than on concrete classes

### ❌ Bad Example

```java
class MySQLDatabase {
    void connect() { System.out.println("Connected to MySQL"); }
}

class OrderService {
    MySQLDatabase db = new MySQLDatabase(); // tightly coupled

    void placeOrder() {
        db.connect();
        System.out.println("Order placed");
    }
}
```

### ✅ Good Example

```java
interface Database {
    void connect();
}

class MySQLDatabase implements Database {
    public void connect() { System.out.println("Connected to MySQL"); }
}

class PostgreSQLDatabase implements Database {
    public void connect() { System.out.println("Connected to PostgreSQL"); }
}

class OrderService {
    private final Database db;

    OrderService(Database db) {
        this.db = db;
    }

    void placeOrder() {
        db.connect();
        System.out.println("Order placed");
    }
}
```


