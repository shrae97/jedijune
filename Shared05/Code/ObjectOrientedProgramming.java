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
    private static int lastId = 0;
    private int id;
    private String name;
    private double salary;
        
    public Employee1() {
        lastId++;
        id = lastId;
    }
    
    public Employee1(String name, double salary) {
        this();
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


public class ObjectOrientedProgramming {
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
        // System.out.println("\nFunction : ");
        // System.out.println("\nFunction : ");
    }
}

