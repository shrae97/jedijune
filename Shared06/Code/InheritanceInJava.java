package learnJava;

/*
javac -version
javac InheritanceInJava.java -d ClassFiles
java -cp ClassFiles learnJava.InheritanceInJava
*/

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
    public final String getName() { return name; } // Method Will Implementation

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

class InheritanceInJava {
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

