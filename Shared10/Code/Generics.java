package learnJava;

/*
javac -version
javac Generics.java -d ClassFiles
java -cp ClassFiles learnJava.Generics
*/

import java.util.ArrayList;
import java.io.PrintStream;
import java.util.function.Predicate;

// Write Code In Java To Simulate Stack Of Type Data

class IntegerStack {
	private int[] arr;
	private int size;
	private static int i = 0;

	public IntegerStack(int n) {
		this.arr = new int[n];
		this.size = n;
	}

	public void push(int x) {
		if(i == size)
			System.out.println("Overflow");
		else {
			arr[i++] = x;
		}
	}

	public int pop() {
		if(i == 0) {
			System.out.println("Underflow");
			return -1;
		}
		else {
			i--;
			return arr[i];
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int j=0; j<i; j++)
			sb.append(", ").append(arr[j]);
		return sb.toString();
	}
}


// Generics In Java
// 		Generics Is Code To Generate Code

// Polymorphism 
class GenericsStack<T> { 
    private int stackSize;
    private T[] stackArr;
    private int top;
    
    @SuppressWarnings("unchecked") 
    public GenericsStack(int size) {
        this.stackSize = size;
        this.stackArr = (T[]) new Object[stackSize];
        this.top = -1;
    }
 
    public void push(T entry){
        if(this.isStackFull()){
            System.out.println(("Stack is full. Increasing the capacity."));
            this.increaseStackCapacity();
        }
        System.out.println("Adding: "+entry);
        this.stackArr[++top] = entry;
    }
 
    public T pop() throws Exception {
        if(this.isStackEmpty()){
            throw new Exception("Stack is empty. Can not remove element.");
        }
        T entry = this.stackArr[top--];
        System.out.println("Removed entry: "+entry);
        return entry;
    }
     
    public T peek() {
        return stackArr[top];
    }
 
    private void increaseStackCapacity(){
    	@SuppressWarnings("unchecked")
        T[] newStack = (T[]) new Object[this.stackSize*2];
        for(int i=0;i<stackSize;i++){
            newStack[i] = this.stackArr[i];
        }
        this.stackArr = newStack;
        this.stackSize = this.stackSize*2;
    }
     
    public boolean isStackEmpty() {
        return (top == -1);
    }
 
    public boolean isStackFull() {
        return (top == stackSize - 1);
    }
     
}

// _________________________________________________________________
// Type Placeholders : K and V

// Generic Type Entry<K, V>
//		Generate Other Types After Substition of K and V

class Entry<K, V> {
    private K key;
    private V value;
    
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public K getKey() { return key; }
    public V getValue() { return value; }
}

// _________________________________________________________________

class ArrayUtil {
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <T> T[] swap(int i, int j, T... values) {
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        return values;
    }
}

// Type Bounds
// You can specify a type bound to require that the type
// extends certain classes or implements certain interfaces.

// - Sometimes, the type parameters of a generic class or method need to fulfill certain requirements. You can specify a type bound to require that the type extends certain classes or implements certain interfaces.

// - Suppose, for example, you have an ArrayList of objects of a class that implements the AutoCloseable interface, and you want to close them all:

// - The type bound extends AutoCloseable ensures that the element type is a subtype of AutoCloseable. Therefore, the call elem.close() is valid.

// - Note that the extends keyword in a type bound actually means “subtype”—the Java designers just used the existing extends keyword instead of coming up with another keyword or symbol.

// - NOTE: In this example, we need a type bound because the parameter is of type ArrayList. If the method accepted an array, you wouldn’t need a generic method. You could simply use a regular method

// - This works because an array type such as PrintStream[] is a subtype of AutoCloseable[]. 

// However, as you will see an ArrayList<PrintStream> is not a subtype of ArrayList<AutoCloseable>. 


// RULES FOR WRITING BOUNDS
// _________________________________________________________________

// - A type parameter can have multiple bounds,
		
// 		T extends Runnable & AutoCloseable

// - This syntax is similar to that for catching multiple exceptions, the only difference being that the types are combined with an “and” operator, whereas multiple exceptions are combined with an “or” operator.

// - You can have as many interface bounds as you like, but at most one of the bounds can be a class. If you have a class as a bound, it must be the first one in the bounds list.



// import java.io.PrintStream;
// import java.util.ArrayList;
class Closeables {
	  //   Generics.java:162: error: cannot find symbol
	  //       	elem.close();
	  //       	    ^
	  // symbol:   method close()
	  // location: variable elem of type T
	  // where T is a type-variable:
	  //   T extends Object declared in method <T>closeAll(ArrayList<T>)
	
	// You are putting Upper Bound on T 
    public static <T extends AutoCloseable> void closeAll(ArrayList<T> elems){ 
        for (T elem : elems) {
        	try { elem.close(); } catch(Exception ex) {}
        	System.out.println("CLosing Resource...");
        }
    }
}

//_____________________________________________________________

class Employee {
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
    
    public final String getName() {
        return name;
    }
    
    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    private double bonus;
    
    public Manager(String name, double salary) {
        super(name, salary);
        bonus = 0;
    }
    
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    
    public double getSalary() { // Overrides superclass method
        return super.getSalary() + bonus;
    }
} 

class Employees {
    public static void printNames(ArrayList<? extends Employee> staff) {
        for (int i = 0; i < staff.size(); i++) {
            Employee e = staff.get(i);
            System.out.println(e.getName());
        }
    }
    
    public static void printAll1(Employee[] staff, Predicate<Employee> filter) {
        for (Employee e : staff) 
            if (filter.test(e))
                System.out.println(e.getName());
    }

    public static void printAll2(Employee[] staff, Predicate<? super Employee> filter) {
        for (Employee e : staff) 
            if (filter.test(e))
                System.out.println(e.getName());
    }
    
    public static void workingWithEmployees() {
        Employee[] employees = {
          new Employee("Fred", 50000),
          new Employee("Wilma", 60000),
        };
        printAll1(employees, e -> e.getSalary() > 100000);
        printAll2(employees, e -> e.getSalary() > 100000);
        Predicate<Object> evenLength = e -> e.toString().length() % 2 == 0; 
        // printAll1(employees, evenLength);
        printAll2(employees, evenLength);
    }
}
public class Generics {
	public static void playWithEmployees() {
		Employees.workingWithEmployees();
	}

	public static void playWithCloseables() throws Exception {
        PrintStream p1 = new PrintStream("/tmp/1");
        PrintStream p2 = new PrintStream("/tmp/2");
        
        ArrayList<PrintStream> ps = new ArrayList<>();
        ps.add(p1);
        ps.add(p2);
        Closeables.closeAll(ps);
 
	 // error: method closeAll in class Closeables cannot be applied to given types;
		// 	Closeables.closeAll(stringList);
		// 	          ^
	 //  required: ArrayList<T>
	 //  found: ArrayList<String>
	 //  reason: inference variable T has incompatible bounds
	 //    equality constraints: String
	 //    upper bounds: AutoCloseable
	 //  where T is a type-variable:
	 //    T extends AutoCloseable declared in method <T>closeAll(ArrayList<T>)   

		// ArrayList<String> stringList = new ArrayList<>();
		// stringList.add("Ding");
		// stringList.add("Dong");
		// stringList.add("Ting");
		// stringList.add("Tong");
		// Closeables.closeAll(stringList);
    }

    public static void playWithArrayUtil() {
        String[] friends = { "Peter", "Paul", "Mary" };
        ArrayUtil.swap(friends, 0, 1);
        ArrayUtil.swap(friends, 0, 1);
	}
	
	public static void playWithEntry() {
		Entry<String, Integer> entry0 = new Entry<String, Integer>("Fred Floyd", 42);
		Entry<String, Integer> entry1 = new Entry<>("Fred Floyd", 42);
		Entry<String, Integer> entry2 = new Entry<>("Gabaar Singh", 40);
		Entry<String, Integer> entry3 = new Entry<>("Sambha", 30);

		Entry<String, String> entry4 = new Entry<>("Sambha", "Gabaar Team");
	}

	public static void playWithGenericStack() {
        GenericsStack<String> stringStack = new GenericsStack<String>(2);
        stringStack.push("java2novice");
        stringStack.push("Ding");
        stringStack.push("Dong");
		stringStack.push("Ping");
        stringStack.push("Pong");

        GenericsStack<Integer> integerStack = new GenericsStack<Integer>(2);
        integerStack.push(23);
        integerStack.push(29);
        integerStack.push(100);
    }

	public static void playWithIntegerStack() {
		IntegerStack S = new IntegerStack(4);
		for(int i=0; i<6; i++) {
			S.push(i);
		}
		System.out.println(S);
		S.pop();
		System.out.println(S);
		S.pop();
		System.out.println(S);
	}

	public static void main(String[] args) {
		System.out.println("\nFunction : playWithIntegerStack");
		playWithIntegerStack();

		System.out.println("\nFunction : playWithGenericStack");
		playWithGenericStack();

		System.out.println("\nFunction : playWithCloseables");
		try { playWithCloseables(); } catch(Exception ex) { } 

		System.out.println("\nFunction : playWithEmployees");
		playWithEmployees();
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