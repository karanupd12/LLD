### Chronology : HLD → LLD → Actual Code

**HLD (High-Level Design)**  
- Represents the overall system architecture  
- Focuses on modules, services, data flow, and system interactions  

**LLD (Low-Level Design)**  
- Defines classes, objects, methods, and their interactions  
- Bridges the gap between architecture and code  

**Actual Code**  
- The concrete implementation using DSA concepts, algorithms, and coding practices  

---

# LOW LEVEL DESIGN

LLD focuses on classes, objects, their behavior, and the optimal way to organize them.

### **Goals**
- Write clean code  
- Ensure flexibility and maintainability  
- Simplify testing  
- Understand that multiple good solutions may exist  

### **Categories**
1. **Creational**
2. **Structural**
3. **Behavioral**

> Knowing patterns is not mandatory; they simply help avoid reinventing solutions.

---

# Categories of Design Patterns

### **1. Creational Design Patterns**
- Manage object creation mechanisms  
- Ensure objects are created in a controlled, optimal way  
- **Examples:** Singleton, Builder, Factory, Abstract Factory, Object Pool, Prototype  

### **2. Structural Design Patterns**
- Describe how objects are composed  
- Simplify system structure by identifying relations  
- **Examples:** Adapter, Composite, Proxy, Flyweight, Facade, Bridge, Decorator  

### **3. Behavioral Design Patterns**
- Manage communication and responsibility distribution  
- Define how objects collaborate  
- **Examples:** Observer, Strategy, Command, Chain of Responsibility, Mediator, Memento, State, Visitor, Template Method, Iterator  


---

# Relationships between Classes/Objects

### **1. is-a (Inheritance)**
Basically Inheritance (Vechicle is a Truck, Car, Taxi, Bus)

### **2. has-a (Association)**  
A link between two objects.
Basically Association (Library has Books, Class has Students)


### **Association Types**

#### **1. Aggregation (Weak Association)**  
Child can exist independently  
- Example: Library → Books  
- A Book exists even if the Library is deleted  

```java
public class Library {
    private List<Book> books;
}
````

#### **2. Composition (Strong Association)**

Child cannot exist independently

* Example: House → Rooms
* If House is destroyed, Rooms are destroyed too

```java
public class House {
    private List<Room> rooms;

    public House() {
        rooms = new List<Room>();
        rooms.add(new Room("Living Room"));
        rooms.add(new Room("Bedroom"));
    }
}

```
