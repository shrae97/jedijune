package learnJava;

/*
javac -version
javac InheritanceInJava.java -d ClassFiles
java -cp ClassFiles learnJava.InheritanceInJava
*/

import java.util.Objects;
import java.util.Scanner;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.lang.reflect.Array;

// class Employee extends Objects { // Parent Class
class Employee { // Parent Class
    private String name;
    private double salary;
        
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;    
    }
    // Final Method Cann't Be Overridden 
    public final String getName() 	{ return name; }
    public double getSalary() 		{ 
    	System.out.println("Employee : getSalary got called");
    	return salary; 
    }
}

// Inheritance
// Manager Is Also Type of Employee
class Manager extends Employee { // Child Class
    private double bonus;
    // private String name; 	// Shadow Inherited Member Variables with Same Name
    // private double salary; 	// Shadow Inherited Member Variables with Same Name
    
    public Manager(String name, double salary) {
        super(name, salary);
        bonus = 0;
    }
    
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
 	
 	// Overriding Function   
    public double getSalary() { 
    	System.out.println("Manager : getSalary got called");
    	return 909090909090.90 + bonus;
    	//return super.getSalary() + bonus; 
    }
    //public String getName()   { return super.getName(); }
} 

class InheritanceDemo {
    public static void workingWithInheritance() {
        Manager boss = new Manager("Gabbar Singh", 200000);
        boss.setBonus(10000); // Defined in subclass
        System.out.println(boss.getName());
        System.out.println(boss.getSalary());
        boss.raiseSalary(5); // Inherited from superclass
        System.out.println(boss.getSalary());

        Employee emp = new Employee("Samabha Singh", 10000);
        // emp.setBonus(10000); // Defined in subclass
        System.out.println(emp.getName());
        System.out.println(emp.getSalary());
        emp.raiseSalary(5); // Inherited from superclass
        System.out.println(emp.getSalary());

        if (emp instanceof Employee) {
        	System.out.println("emp is Employee Tyoe");
        } else {
        	System.out.println("emp is Not Employee Type");
        }
    
        if (emp instanceof Manager) {
        	System.out.println("emp is Manager Tyoe");
        } else {
        	System.out.println("emp is Not Manager Type");
        }

        if (boss instanceof Employee) {
        	System.out.println("boss is Employee Tyoe");
        } else {
        	System.out.println("boss is Not Employee Type");
        }
    
        if (boss instanceof Manager) {
        	System.out.println("boss is Manager Tyoe");
        } else {
        	System.out.println("boss is Not Manager Type");
        }
    }

    public static void workingWithInheritanceOnceMore() {
        Manager boss = new Manager("Gabbar Singh", 200000);
        boss.setBonus(10000); // Defined in subclass
        System.out.println(boss.getName());
        System.out.println(boss.getSalary());
        boss.raiseSalary(5); // Inherited from superclass
        System.out.println(boss.getSalary());

        Employee emp = boss; // boss is of Manager as well as Employee Type
        System.out.println(emp.getName());
        System.out.println(emp.getSalary());
        emp.raiseSalary(5); 
        System.out.println(emp.getSalary());
        // emp.setBonus(8888); // 
  		// Manager : getSalary got called
		// 9.090909190909E11
		// Manager : getSalary got called
		// 9.090909190909E11
    }
}

// ___________________________________________________________________________

interface Named {
    default String getName() { return ""; }
}

abstract class Person {
    private String name;

    public Person(String name) { this.name = name; } 
    public final String getName() { return name; } // Method With Implementation

    public abstract int getId(); // Method Without Implementation
}

class Student extends Person implements Named {
    private int id;

    public Student(String name, int id) { super(name); this.id = id; }
    public int getId() { return id; }
}

class StudentDemo {
    public void workingWithStudentDemo() {
        Person p = new Student("Ram Singh", 1729); // OK, a concrete subclass
        System.out.println(p.getName());
        Student s = (Student) p;
        System.out.println(s.getName());
        Named n = s;
        System.out.println(n.getName());
    }
}

// ___________________________________________________________________________

class Worker {
    public void work() { 
        for (int i = 0; i < 100; i++) System.out.println("Working"); 
    }
}

class ConcurrentWorker extends Worker {
    public void work() { 
        Thread t = new Thread(super::work);
        t.start();
    }
}

// ___________________________________________________________________________
// import java.util.Objects;
// Class Object is the root of the class hierarchy. 
// Every class has Object as a superclass. 
// All objects, including arrays, implement the methods of this class.
// class Item extends Object {
class Item {
    private String description;
    private double price;
    // private marks float [];
        
    public Item(String description, double price) {
        this.description = description;
        this.price = price;
    }

	// Professional Equal Example
    public boolean equals(Object otherObject) {
        // A quick test to see if the objects are identical
        if (this == otherObject) return true;

        // Must return false if the explicit parameter is null
        if (otherObject == null) return false;
        
        // Check that otherObject is a Item
        // Both Objects Are Of Same Type
        if (getClass() != otherObject.getClass()) return false;
        
        // Test whether the instance variables have identical values
        Item other = (Item) otherObject;
        return Objects.equals(description, other.description)
            && price == other.price;
    }
    
    public int hashCode() {
        return Objects.hash(description, price);
    }

    // Item[description=oeproep, price=909090]
    public String toString() {
        return getClass().getName() + "[description=" + description
            + ",price=" + price + "]";
    }
}

class DiscountedItem extends Item {
    private double discount;

    public DiscountedItem(String description, double price, double discount) {
        super(description, price);
        this.discount = discount;
    }

    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject)) return false;
        DiscountedItem other = (DiscountedItem) otherObject;
        return discount == other.discount;
    }
    
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount);
    }
}

// __________________________________________________________

enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
    private String abbreviation;

    Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() { return abbreviation; }
}

// Compiler Will Generate Code Similar To Following
// class Size {
// 		static final Size SMALL = new Size("S");
// 		static final Size MEDIUM = new Size("M");
// 		static final Size LARGE = new Size("L");
// 		static final Size EXTRA_LARGE = new Size("XL");

//     private String abbreviation;

//     private Size(String abbreviation) {
//         this.abbreviation = abbreviation;
//     }

//     public String getAbbreviation() { return abbreviation; }
// }


class EnumDemo {
	public void workingWithSizeEnum() {
        Size notMySize = Size.valueOf("SMALL");
        System.out.println(notMySize);
        
        for (Size s : Size.values()) { 
        	System.out.println(s); 
        }
        
        System.out.println(Size.MEDIUM.ordinal());
    }
}

// ___________________________________________________________________________
// import java.util.Scanner;

enum Operation {
    ADD("+") {
        public int eval(int arg1, int arg2) { return arg1 + arg2; }
    },
    SUBTRACT("-") {
        public int eval(int arg1, int arg2) { return arg1 - arg2; }
    },
    MULTIPLY("*") {
        public int eval(int arg1, int arg2) { return arg1 * arg2; }
    },
    DIVIDE("/") {
        public int eval(int arg1, int arg2) { return arg1 / arg2; }
    };

    private String symbol;
    Operation(String symbol) { this.symbol = symbol; }
    public String getSymbol() { return symbol; }
    
    public abstract int eval(int arg1, int arg2);
}

// ___________________________________________________________________________

class Calculator {
    public static void compute() {
        Scanner in = new Scanner(System.in);
        System.out.print("First operand: ");
        int a = in.nextInt();
        System.out.print("Operator: ");
        String opSymbol = in.next();
        System.out.print("Second operand: ");
        int b = in.nextInt();
        
        for (Operation op : Operation.values()) {
            if (op.getSymbol().equals(opSymbol)) {
                int result = op.eval(a, b);
                System.out.println(result);
            } 
        }
    }
}

// Reflection APIs
class ClassDemo {
    public static void workingWithClassDemo() {
        Object obj = System.out;
    
        Class<?> cl = obj.getClass();        
        System.out.println("This object is an instance of " + cl.getName());

        String className = "java.util.Scanner";
        // cl = Class.forName(className);
        // An object describing the java.util.Scanner class
        cl = java.util.Scanner.class;
        System.out.println(cl.getName());

        Class<?> cl2 = String[].class; // Describes the array type String[]
        System.out.println(cl2.getName());
        System.out.println(cl2.getCanonicalName());
        
        Class<?> cl3 = Runnable.class; // Describes the Runnable interface 
        System.out.println(cl3.getName());
        
        Class<?> cl4 = int.class; // Describes the int type
        System.out.println(cl4.getName());
        
        Class<?> cl5 = void.class; // Describes the void type
        System.out.println(cl5.getName());
    }
}
// This object is an instance of java.io.PrintStream
// java.util.Scanner
// [Ljava.lang.String;
// java.lang.String[]
// java.lang.Runnable
// int
// void

//___________________________________________________________________________
// import java.lang.reflect.Method;
// import java.lang.reflect.Modifier;
// import java.util.Arrays;
// import java.util.Scanner;

class MethodPrinter {
    public static void workingWithClassMethodList() throws ReflectiveOperationException {

        System.out.print("Class name: ");
        Scanner in = new Scanner(System.in);
        String className = in.nextLine();
        Class<?> cl = Class.forName(className);

        while (cl != null) {
            for (Method m : cl.getDeclaredMethods()) { 
                System.out.println(
                    Modifier.toString(m.getModifiers()) + " " +
                    m.getReturnType().getCanonicalName() + " " +
                    m.getName() +
                    Arrays.toString(m.getParameters()));                    
            }
            cl = cl.getSuperclass();
        }
    }
}

//___________________________________________________________________________
// import java.lang.reflect.Array;
// import java.util.Arrays;

class ArrayReflection {
    public static Object[] badCopyOf(Object[] array, int newLength) {
        Object[] newArray = new Object[newLength];
        for (int i = 0; i < Math.min(array.length, newLength); i++)
            newArray[i] = array[i];
        return newArray;
    }
    
    public static Object goodCopyOf(Object array, int newLength) {
        Class<?> cl = array.getClass(); // type()
        if (!cl.isArray()) return null;
        Class<?> componentType = cl.getComponentType();
        int length = Array.getLength(array);
        
        Object newArray = Array.newInstance(componentType, newLength);
        for (int i = 0; i < Math.min(length, newLength); i++)
            Array.set(newArray, i, Array.get(array,  i));
        return newArray;
    }
    
    public static void workingWithArrayReflection() {
        int[] primes = { 2, 3, 5, 7, 11 };
        primes = (int[]) goodCopyOf(primes, 10);
        System.out.println(Arrays.toString(primes));
    }
}

class InheritanceInJava {
	public static void playWithArrayReflection() {
		ArrayReflection.workingWithArrayReflection();
	}

	public static void playWithClassMethodList() {
		try {
			MethodPrinter.workingWithClassMethodList();
		} catch( Exception ex) { }
	}

	public static void playWithClassDemo() {
		ClassDemo object = new ClassDemo();
		object.workingWithClassDemo();
	}

	public static void playWithEnumDemo() {
		EnumDemo object = new EnumDemo();
		object.workingWithSizeEnum();
	}

	public static void playWithConcurrentWorker() {
        ConcurrentWorker worker = new ConcurrentWorker();
        worker.work();
        System.out.println("Done");
    }

	public static void playWithStudentDemo() {
		StudentDemo object = new StudentDemo();
		object.workingWithStudentDemo();
	}

	public static void playWithInheritanceDemo() {
		InheritanceDemo object = new InheritanceDemo();
		object.workingWithInheritance();
		object.workingWithInheritanceOnceMore();
	}
	
	public static void main(String[] args) {
        System.out.println("\nFunction : playWithInheritanceDemo");
        playWithInheritanceDemo();

        System.out.println("\nFunction : playWithStudentDemo");
        playWithStudentDemo();

        System.out.println("\nFunction : playWithConcurrentWorker");
        playWithConcurrentWorker();

        System.out.println("\nFunction : playWithEnumDemo");
        playWithEnumDemo();

        System.out.println("\nFunction : playWithClassDemo");
        playWithClassDemo();

        System.out.println("\nFunction : playWithClassMethodList");
        playWithClassMethodList();

        System.out.println("\nFunction : playWithArrayReflection");
        playWithArrayReflection();
        // System.out.println("\nFunction : ");
        // System.out.println("\nFunction : ");
        // System.out.println("\nFunction : ");
        // System.out.println("\nFunction : ");
        // System.out.println("\nFunction : ");
        // System.out.println("\nFunction : ");
        // System.out.println("\nFunction : ");
    }
}

