package learnJava;

/*
javac -version
javac InterfacesInJava.java -d ClassFiles
java -cp ClassFiles learnJava.InterfacesInJava
*/

// Interfaces Purpose Is Declaration
//      Declares What To Do?
interface IntSequence {
    boolean hasNext();
    int next();
}

// Class Purpose Is Implementation
//      Defines How To Do?
//      Class Implmenting Interace Means It Follows Contract
//          Class Must Support All Functionality Required By Contract

// DigitSequence is also Type of IntSequence
class DigitSequence implements IntSequence {
    private int number;

    public DigitSequence(int n) {
        number = n;
    }

    public int rest() {
        return number;
    }

    public boolean hasNext() {  // Must Be Implemented
        return number != 0;
    }

    public int next() {         // Must Be Implemented
        int result = number % 10;
        number /= 10;
        return result;
    }    
}

// SquareSequence is also Type of IntSequence
class SquareSequence implements IntSequence {
    private int i;

    public boolean hasNext() { // Must Be Implemented
        return true;
    }

    public int next() { // Must Be Implemented
        i++;
        return i * i;
    }
}

class CubeSequence implements IntSequence {
    private int i;

    public boolean hasNext() { // Must Be Implemented
        return true;
    }

    public int next() { // Must Be Implemented
        i++;
        return i * i * i;
    }
}

class IntSequenceDemo {
    public double average(IntSequence seq, int n) {
        int count = 0;
        double sum = 0;
        while (seq.hasNext() && count < n) {
            count++;
            sum += seq.next();
        }
        return count == 0 ? 0 : sum / count;
    }

    public void workingWithIntSequenceDemo() {
        SquareSequence squares = new SquareSequence();
        double avg = average(squares, 100);
        System.out.println("Average of first 100 squares: " + avg);
        
        IntSequence digits = new DigitSequence(1729);
        while (digits.hasNext()) System.out.print(digits.next() + " ");
        System.out.println();
        
        digits = new DigitSequence(1729);
        avg = average(digits, 100);
            // Will only look at the first four sequence values
        System.out.println("Average of the digits: " + avg);

        CubeSequence cubes = new CubeSequence();
        avg = average(cubes, 100);
        System.out.println("Average of first 100 cubes: " + avg);
    }
}

//__________________________________________________________________________

interface Identified { 
    // int getId();
    // Simialr Function Definition i.e. Function with Same Signature
    default int getId() { return Math.abs(hashCode()); } 
}

interface Person {
    String getName();
    // int getId();
    // Simialr Function Definition i.e. Function with Same Signature
    default int getId() { return 0; }
}
// Employee Implements Two Interfaces
//      Conflict Because of 2 Implementation
//      Which One To Resolve!
class Employee implements Person, Identified {
    private static int id = 0;
    
    private int empID;
    private String name; // Member Variable
    private double salary;
                    // Argument
    public Employee(String name, double salary) {
        id++;
        this.empID = id;
        this.name = name;
        this.salary = salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;    
    }
    
    public String getName()     { return name; }
    public double getSalary()   { return salary; }
    // public int getId()          { return id; }
    
    // Resolving Conflict : By Selecting Specific Implementtation
    // public int getId() { return Identified.super.getId(); } 
    // public int getId() { return Person.super.getId(); } 
    public int getId() { 
        return Identified.super.getId() + Person.super.getId();
    } 
}

class Employee1 implements Comparable<Employee1> {
    private String name;
    private double salary;
        
    public Employee1(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    
    public Employee1(double salary) {
        this.name = "";
        this.salary = salary;
    }        
    
    public Employee1(String name) {
        // salary automatically set to zero
        this.name = name;
    } 
    
    public Employee1() {
        this("", 0);
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;    
    }
    public String getName() { return name; }
    public double getSalary() { return salary; }    
    public int compareTo(Employee1 other) { // -1, 0, 1
        return Double.compare(salary, other.salary);
    }
}

public class InterfacesInJava {
    public static void playWithEmployee1() {
        Employee1 emp1 = new Employee1("Gabbar Singh", 50000);        
        System.out.println(emp1.getName());
        System.out.println(emp1.getSalary());

        Employee1 emp2 = new Employee1("Samba Singh", 10);
        System.out.println(emp2.getName());
        System.out.println(emp2.getSalary());

        Employee1 emp3 = new Employee1("Kalia", 10);
        System.out.println(emp3.getName());
        System.out.println(emp3.getSalary());

        System.out.println( emp1.compareTo(emp2) );
        System.out.println( emp2.compareTo(emp3) );
    }

    public static void playWithEmployee() {
        Employee emp = new Employee("Gabbar Singh", 50000);
        System.out.println(emp.getId());
        System.out.println(emp.getName());
        System.out.println(emp.getSalary());

        emp = new Employee("Samba Singh", 10);
        System.out.println(emp.getId());
        System.out.println(emp.getName());
        System.out.println(emp.getSalary());
    }
    
    public static void playWithIntSequenceDemo() {
        IntSequenceDemo object = new IntSequenceDemo();
        object.workingWithIntSequenceDemo();
    } 
    
    public static void main(String[] args) {
        System.out.println("\nFunction : playWithIntSequenceDemo");
        playWithIntSequenceDemo();

        System.out.println("\nFunction : playWithEmployee");
        playWithEmployee();

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
    }
}

