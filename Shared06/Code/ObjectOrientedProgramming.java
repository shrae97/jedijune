/*
javac -version
javac ObjectOrientedProgramming.java -d ClassFiles
java -cp ClassFiles learnJava.ObjectOrientedProgramming
*/

package learnJava;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

class DateAndTimeDemo {
    public void workingWithDateAndTime(String[] args) {
        LocalDate date = LocalDate.now().withDayOfMonth(1);
        int month;
        if (args.length >= 2) {        
            month = Integer.parseInt(args[0]);
            int year = Integer.parseInt(args[1]);
            date = LocalDate.of(year, month, 1);
        } else {
            month = date.getMonthValue();
        }
        
        System.out.println(" Mon Tue Wed Thu Fri Sat Sun");
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue(); // 1 = Monday, ... 7 = Sunday
        for (int i = 1; i < value; i++) 
            System.out.print("    ");
        while (date.getMonthValue() == month) {
            System.out.printf("%4d", date.getDayOfMonth());
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) 
                System.out.println();
        }
        if (date.getDayOfWeek().getValue() != 1) 
           System.out.println();
    }
}

class ReferenceDemo {
    public void workingWithReferences() {
        ArrayList<String> friends = new ArrayList<>();
            // friends is empty
        friends.add("Peter");
            // friends has size 1
        ArrayList<String> people = friends;
            // Now people and friends refer to the same object
        people.add("Paul");
        System.out.println(friends);
        System.out.println(people);
    }
}

// Encapsulation
//      Functions | Behaviour | Message
//      States
//      Are Together
class Employee0 {
    // State We Make Private
    private String name;    // Member Variable
    private double salary;  // Member Variable

    // Constuctor is Member Function Having...
    //      Name Same As class Name Itself
    public Employee0(String name, double salary) { // Member Function
        this.name = name;
        this.salary = salary;
    }

    // Messages
    public void raiseSalary(double raise) {  // Member Function
        salary = salary + raise;
    }

    public String getName() {       // Member Function
        return name;
    }

    public double getSalary() {     // Member Function
        return salary;
    }
}

//import java.util.Random;
class EvilManager {
    private Random generator;
    
    public EvilManager() {
        generator = new Random();
    }
    
    public void giveRandomRaise(Employee0 e) {
        double percentage = 10 * generator.nextDouble();
        e.raiseSalary(percentage);
    }
    
    public void increaseRandomly(double x) { // Won't work
        double amount = x * 10 * generator.nextDouble();
        x += amount;
    }
    
    public void replaceWithZombie(Employee0 e) {
        e = new Employee0("", 0);
    }
}

class Employee {
    private String name = ""; // Default Value is: ""
    private double salary;    // Default Value is: 0.0
    private final int id;     // Default Value is: 0
        
    { // An initialization block
        Random generator = new Random(); 
        id = 1 + generator.nextInt(1_000_000);
    }

    // Creates Employee with name and salary    
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    
    // Creates Employee with salary    
    public Employee(double salary) {
        // name already set to ""
        this.salary = salary;
    }        
    
    // Creates Employee with name
    public Employee(String name) {
        // salary automatically set to zero
        this.name = name;
    } 
    // Default Constructor
    //      It Doesn't Take Any Arguments
    // Creates Employe With Default Values
    public Employee() {
    // Constructor Call 
        this("", 0); // Employee(String name, double salary)
    }
    
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;    
    }
    
    public String getName() {
        return name;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public int getId() {
        return id;
    }
}

class Employee1 {
    // Persist Values w.r.t Process LifeTime
    private static int lastId = 0; 
    private int id;
    private String name;
    private double salary;
        
    public Employee1() {
        lastId++;
        id = lastId;
    }
    
    // Explicitly Programming Over Implicity Programming
    public Employee1(String name, double salary) {
        this();  // Constructor 
        this.name = name;
        this.salary = salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;    
    }
    
    public String getName() {
        return name;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public int getId() {
        return id;
    }
}

//import java.util.ArrayList;
class Invoice {
    // Nested Classes
    //      You Can Define Class Inside Another Class i.e. Localised
    private class Item { // Item is nested inside Invoice
        String description;
        int quantity;
        double unitPrice;
        double price() { return quantity * unitPrice; }
        public String toString() { 
            return quantity + " x " + description + " @ $" + unitPrice + " each";
        }
    }
    // Collection of Data Is Internally Localised
    private ArrayList<Item> items = new ArrayList<>();
    public void addItem(String description, int quantity, double unitPrice) {
        Item newItem = new Item();
        newItem.description = description;
        newItem.quantity = quantity;
        newItem.unitPrice = unitPrice;
        items.add(newItem);
    }

    // Remove Item Functionality
    // Change Existing Item Functionality   
    public void print() {
        double total = 0;
        for (Item item : items) {
            System.out.println(item);
            total += item.price();
        }
        System.out.println(total);
    }
}

// Playing Card Suites Doesn't Have Any Significance Beyond Playing Card Deck
//      Hence It's Should Be Locally Defined Inside Playing Card Deck
class PlayingCardDeck {
    private class Suites {

    }    
}

// People Network Design
//      Network Consists of Members, Members Can Be Enrolled
//      Each Member Can Have Friends, Friends Can Be Added
class Network {
    // this points to Object of Network Class/Type
    public class Member { // Nested Class : Localised
        // this points to Object of Member Class/Type
        private String name;
        private ArrayList<Member> friends = new ArrayList<>();
        
        public Member(String name)  { this.name = name; }
        public void deactivate()    { members.remove(this); }
        public void addFriend(Member newFriend) { friends.add(newFriend); }
        public boolean belongsTo(Network n) { return Network.this == n; }    
        
        public String toString() { 
            StringBuilder result = new StringBuilder(name);
            result.append(" with friends ");
            for (Member friend : friends) {
                result.append(friend.name);
                result.append(", ");
            }
            return result.subSequence(0, result.length() - 2).toString();
        }
    }    
    private ArrayList<Member> members = new ArrayList<>();
    public Member enroll(String name) {
        Member newMember = new Member(name);
        members.add(newMember);
        return newMember;
    }
    public String toString() { return members.toString(); }
}

public class ObjectOrientedProgramming {
    public static void playWithNetwork() {
        Network myFace = new Network();
        Network tooter = new Network();
        Network.Member fred = myFace.enroll("Fred");
        Network.Member wilma = myFace.new Member("Wilma");
        fred.addFriend(wilma);
        Network.Member barney = tooter.enroll("Barney");
        fred.addFriend(barney);
        System.out.println(myFace);
        System.out.println(barney.belongsTo(myFace));
    }
    public static void playWithInvoice() {
        Invoice invoice = new Invoice();
        invoice.addItem("Blackwell Toaster", 2, 24.95);
        invoice.addItem("ZapXpress Microwave Oven", 1, 49.95);
        invoice.addItem("Jack and Denial", 1, 50.00);
        invoice.addItem("Maggi", 10, 100.00);
        invoice.print();
    }
    public static void playWithEmployee1() {
        Employee1 gabbar = new Employee1("Gabbar Singh", 40000);
        System.out.println( gabbar.getId() );
        System.out.println( gabbar.getName() );
        System.out.println( gabbar.getSalary() );

        gabbar.raiseSalary(50000);              // Head Price
        System.out.println( gabbar.getName() );
        System.out.println( gabbar.getSalary() );        

        Employee1 sambha = new Employee1("Sambha Singh", 40000);
        System.out.println( sambha.getId() );
        System.out.println( sambha.getName() );
        System.out.println( sambha.getSalary() );

        Employee1 uselessGuy = new Employee1("Dharam Bhaji!", 9090);
        System.out.println( uselessGuy.getId() );
        System.out.println( uselessGuy.getName() );
        System.out.println( uselessGuy.getSalary() );

        Employee1 kalia = new Employee1("Kalia", 100);
        System.out.println( kalia.getId() );
        //System.out.println( kalia.getId().toString() );
        System.out.println( kalia.getName() );
        System.out.println( kalia.getSalary() );

        Employee1 basanti = new Employee1("Basanti", 8000);
        System.out.println( basanti.getId() );
        System.out.println( basanti.getName() );
        System.out.println( basanti.getSalary() );
    }

    public static void playWithEmployeeOnceMore() {
        Employee gabbar = new Employee("Gabbar Singh", 40000);
        System.out.println( gabbar.getName() );
        System.out.println( gabbar.getSalary() );

        gabbar.raiseSalary(50000);              // Head Price
        System.out.println( gabbar.getName() );
        System.out.println( gabbar.getSalary() );        

        Employee sambha = new Employee("Sambha Singh", 40000);
        System.out.println( sambha.getName() );
        System.out.println( sambha.getSalary() );

        Employee uselessGuy = new Employee();
        System.out.println( uselessGuy.getName() );
        System.out.println( uselessGuy.getSalary() );

        Employee kalia = new Employee("Kalia");
        System.out.println( kalia.getName() );
        System.out.println( kalia.getSalary() );

        Employee unknown = new Employee(8000);
        System.out.println( unknown.getName() );
        System.out.println( unknown.getSalary() );
        // System.out.println( gabbar.name );
        // System.out.println( gabbar.salary );
    }

    public static void playWithEvilManagerAndEmployee() {
        EvilManager boss = new EvilManager();
        
        Employee0 fred = new Employee0("Fred", 50000);
        System.out.println("Salary before: " + fred.getSalary());            
        boss.giveRandomRaise(fred);
        System.out.println("Salary after: " + fred.getSalary());

        double sales = 100000;
        System.out.println("Sales before: " + sales);
        boss.increaseRandomly(sales);
        System.out.println("Sales after: " + sales);
        
        System.out.println("Employee before: " + fred.getName());            
        boss.replaceWithZombie(fred);
        System.out.println("Employee after: " + fred.getName());            
    }

    public static void playWithEmployee() {
        // Invoking Constructor With Given Arugments
        //      To Create Object of Employee Type
        Employee0 gabbar = new Employee0("Gabbar Singh", 40000);
        System.out.println( gabbar.getName() );
        System.out.println( gabbar.getSalary() );

        gabbar.raiseSalary(50000); // Head Price
        System.out.println( gabbar.getName() );
        System.out.println( gabbar.getSalary() );        
        // System.out.println( gabbar.name );
        // System.out.println( gabbar.salary );
    }

    public static void playWithReferenceDemo() {
        ReferenceDemo object = new ReferenceDemo();
        object.workingWithReferences();
    }

    public static void playWithDateAndTime(String[] args) {
        DateAndTimeDemo object = new DateAndTimeDemo();
        object.workingWithDateAndTime(args);
    }

    public static void main(String[] args)  {
        System.out.println("\nFunction : playWithDateAndTime");
        playWithDateAndTime(args);

        System.out.println("\nFunction : playWithReferenceDemo");
        playWithReferenceDemo();

        System.out.println("\nFunction : playWithEmployee");
        playWithEmployee();

        System.out.println("\nFunction : playWithEvilManagerAndEmployee");
        playWithEvilManagerAndEmployee();

        System.out.println("\nFunction : playWithEmployeeOnceMore");
        playWithEmployeeOnceMore();

        System.out.println("\nFunction : playWithEmployee1");
        playWithEmployee1();
        
        System.out.println("\nFunction : playWithInvoice");
        playWithInvoice();

        System.out.println("\nFunction : playWithNetwork");
        playWithNetwork();
        // System.out.println("\nFunction : ");
        // System.out.println("\nFunction : ");
        // System.out.println("\nFunction : ");
        // System.out.println("\nFunction : ");
        // System.out.println("\nFunction : ");
        // System.out.println("\nFunction : ");
        // System.out.println("\nFunction : ");
        // System.out.println("\nFunction : ");
        // System.out.println("\nFunction : ");
        // System.out.println("\nFunction : ");
        // System.out.println("\nFunction : ");
        // System.out.println("\nFunction : ");
        // System.out.println("\nFunction : ");
        // System.out.println("\nFunction : ");
        // System.out.println("\nFunction : ");
        // System.out.println("\nFunction : ");
    }
}

