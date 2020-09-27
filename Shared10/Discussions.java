________________________________________________________________________

					Unix/Linux Concepts And Commands
________________________________________________________________________

	Current Node 
		pwd : Present Working Directory

	Lists Children Nodes of Current Node
		ls
		ls -a 
		ls -l 
		ls -a -l 
		ls -al 

	cd : Change Directory
		cd .. 		: Change Directory To Parent Directory
		cd NODE 	: Change Directory To Node
		cd PATH 	: Change Directory To Path End Node
			
			PATH : Can Be Relative Path Or Absolute Path
			
			e.g.
				cd Documents
		cd ~
			Change To Home Directory Node

			Tilde Symbol ~ Represents Home Directory
				User Directory : Which User You Have Logged In
				e.g.
					/Users/intelligene
		cd /
			Change Directory To Root Node
			/  : Root Directory

________________________________________________________________________
Creating Nodes

	mkdir NODE : Make Directory Node
	touch NODE : Make Regular File Node

	tree : 
		Display Nodes Tree Starting From Current Directory

		To Install tree Commnad In Ubuntu
			sudo apt install tree
			sudo snap install tree

		To Instal vim 
			sudo apt update
			sudo apt install vim

	Basics of vim
		vimtutor command 


________________________________________________________________________
				Git Version Control System
________________________________________________________________________
	Helps In Tracking, Maintaining Code or Text Files Changes


________________________________________________________________________
				Core Java Concepts
________________________________________________________________________

Type Of Type Relationship
________________________________________________________________________	
	A Type S is Supertype of type T(The Subtype) when any Value of SubType
	Can Be Assigned To A Variable of The SuperType Without Conversion


	S is SuperType(Parent Type) and T is SubType(Child Type)

________________________________________________________________________

equals Contract In Java
________________________________________________________________________

public boolean equals(Object obj)
	Indicates whether some other object is "equal to" this one.
	The equals method implements an equivalence relation on non-null object references:

	It is reflexive: for any non-null reference value x, x.equals(x) should return true.
	It is symmetric: for any non-null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.
	It is transitive: for any non-null reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.
	It is consistent: for any non-null reference values x and y, multiple invocations of x.equals(y) consistently return true or consistently return false, provided no information used in equals comparisons on the objects is modified.

	For any non-null reference value x, x.equals(null) should return false.
	The equals method for class Object implements the most discriminating possible equivalence relation on objects; that is, for any non-null reference values x and y, this method returns true if and only if x and y refer to the same object (x == y has the value true).

	Note that it is generally necessary to override the hashCode method whenever this method is overridden, so as to maintain the general contract for the hashCode method, which states that equal objects must have equal hash codes.

	Parameters:
		obj - the reference object with which to compare.
	Returns:
		true if this object is the same as the obj argument; false otherwise.


________________________________________________________________________


Type Bounds
You can specify a type bound to require that the type
extends certain classes or implements certain interfaces.

- Sometimes, the type parameters of a generic class or method need to fulfill certain requirements. You can specify a type bound to require that the type extends certain classes or implements certain interfaces.

- Suppose, for example, you have an ArrayList of objects of a class that implements the AutoCloseable interface, and you want to close them all:

- The type bound extends AutoCloseable ensures that the element type is a subtype of AutoCloseable. Therefore, the call elem.close() is valid.

- Note that the extends keyword in a type bound actually means “subtype”—the Java designers just used the existing extends keyword instead of coming up with another keyword or symbol.

- NOTE: In this example, we need a type bound because the parameter is of type ArrayList. If the method accepted an array, you wouldn’t need a generic method. You could simply use a regular method

- This works because an array type such as PrintStream[] is a subtype of AutoCloseable[]. 

However, as you will see an ArrayList<PrintStream> is not a subtype of ArrayList<AutoCloseable>. 


RULES FOR WRITING BOUNDS
_________________________________________________________________

- A type parameter can have multiple bounds,
		
		T extends Runnable & AutoCloseable

- This syntax is similar to that for catching multiple exceptions, the only difference being that the types are combined with an “and” operator, whereas multiple exceptions are combined with an “or” operator.

- You can have as many interface bounds as you like, but at most one of the bounds can be a class. If you have a class as a bound, it must be the first one in the bounds list.

________________________________________________________________________
Type Variance and Wildcards
________________________________________________________________________
 
 - Suppose you need to implement a method that processes an array of objects that are subclasses of the class Employee. You simply declare the parameter to have type Employee[]:

		public static void process(Employee[] staff) { ... }

- If Manager is a subclass of Employee, you can pass a Manager[] array to the method since Manager[] is a subtype of Employee[]

- This behavior is called covariance. Arrays vary in the same way as the element types.

- Now, suppose you want to process an array list instead. However, there is a problem: The type ArrayList<Manager> is not a subtype of ArrayList<Employee>.

- There is a reason for this restriction. If it were legal to assign an ArrayList<Manager> to a variable of type ArrayList<Employee>, you could corrupt the array list by storing non managerial employees:

	ArrayList<Manager> bosses = new ArrayList<>();
	// Not legal, but suppose it is...
	ArrayList<Employee> empls = bosses; 
	empls.add(new Employee(...)); // a Non Manager In bosses!

- Since conversion from ArrayList<Manager> to ArrayList<Employee> is disallowed, this error cannot occur.
   

NOTE:
Can you generate the same error with arrays, where the conversion from
Manager[] to Employee[] is permitted?
	Java arrays are covariant, which is convenient but unsound.

- When you store a mere Employee in a Manager[] array, an ArrayStoreException is thrown.

- In contrast, all generic types in Java are invariant generics.
 
- In Java, you use wildcards to specify how method parameter and return types should be allowed to vary. This mechanism is sometimes called use-site variance

 - In many situations it is perfectly safe to convert between different array lists. Suppose a method never writes to the array list, so it cannot corrupt its argument.

	public static void printNames(ArrayList<? extends Employee> staff) { for (int i = 0; i < staff.size(); i++) {
	           Employee e = staff.get(i);
	           System.out.println(e.getName());
	       }
	}

- The wildcard type ? extends Employee indicates some unknown subtype of Employee. You can call this method with an ArrayList<Employee> or an array list of a subtype, such as ArrayList<Manager>.

- The get method of the class ArrayList<? extends Employee> has return type ? extends Employee. The statement is perfectly legal

- Whatever type ? denotes, it is a subtype of Employee, and the result of staff.get(i) can be assigned to the Employee variable e.

- What happens if you try to store an element into an ArrayList<? extends Employee>? That would not work. Consider a call
 	
 		staff.add(x);

- The add method has parameter type ? extends Employee, and there is no object that you can pass to this method. If you pass, say, a Manager object, the compiler will refuse. After all, ? could refer to any subclass, perhaps Janitor, and you can’t add a Manager to an ArrayList<Janitor>.

- NOTE: You can, of course, pass null, but that’s not an object.

- In summary, you can convert from ? extends Employee to Employee, but you can never convert anything to ? extends Employee. This explains why you can read from an ArrayList<? extends Employee> but cannot write to it.

- The wildcard type ? extends Employee denotes an arbitrary subtype of Employee. The converse is the wildcard type ? super Employee which denotes a supertype of Employee

- These wildcards are often useful as parameters in functional objects.

// __________________________________________________________________

- The Predicate interface has a method for testing whether an object of type T has a particular property:

		public interface Predicate<T> {
		    boolean test(T arg);
			... 
		}

- This method prints the names of all employees with a given property:

	public static void printAll(Employee[] staff, Predicate<Employee> filter) {
        for (Employee e : staff)
           	if (filter.test(e))
               	System.out.println(e.getName());
    }

- You can call this method with an object of type Predicate<Employee>. Since that is a functional interface, you can also pass a lambda expression:
 	
 	printAll(employees, e -> e.getSalary() > 100000);

- Now suppose you want to use a Predicate<Object> instead, for example
	
	Predicate<Object> evenLength = e -> e.toString().length() % 2 == 0;
   	printAll(employees, evenLength);

- This should not be a problem. After all, every Employee is an Object with a toString method.

- However, like all generic types, the Predicate interface is invariant, and there is no relationship between Predicate<Employee> and Predicate<Object>.
	
- The remedy is to allow any Predicate<? super Employee>:

	public static void printAll(Employee[] staff, Predicate<? super Employee> filter) { 
		for (Employee e : staff)
			if (filter.test(e)) 
				System.out.println(e.getName());
	}

- Have a close look at the call filter.test(e). Since the parameter of test has a type that is some supertype of Employee, it is safe to pass an Employee object.

- This situation is typical. Functions are naturally contravariant in their parameter types.

- For example, when a function is expected that can process employees, it is OK to give one that is willing to process arbitrary objects.

- In general, when you specify a generic functional interface as a method parameter, you should use a super wildcard.


- NOTE: Some programmers like the “PECS” mnemonic for wildcards: 		
		producer extends, consumer super. 

	An ArrayList from which you read values is a producer, so you use an extends wildcard. A Predicate to which you give values for testing is a consumer, and you use super.



- Consider a generalization of the method of the preceding section that prints arbitrary elements fulfilling a condition:

	public static <T> void printAll(T[] elements, Predicate<T> filter) {
       for (T e : elements)
           if (filter.test(e))
               System.out.println(e.toString());
	}

- This is a generic method that works for arrays of any type. The type parameter is the type of the array that is being passed.

- However, it suffers from the limitation that you saw in the preceding section. 

- The type parameter of Predicate must exactly match the type parameter of the method.

	public static <T> void printAll(T[] elements, Predicate<? super T> filter)

- This method takes a filter for elements of type T or any supertype of T
.

Examples From Java Collection APIs
	
	The Collection<E> interface

	public boolean addAll(Collection<? extends E> c)


	public interface Comparable<T> {
	    int compareTo(T other);
	}

	public static <T extends Comparable<? super T>> void sort(List<T> list)


________________________________________________________________________
Unbounded Wildcards
________________________________________________________________________

- It is possible to have unbounded wildcards for situations where you only do very generic operations
	
	public static boolean hasNulls(ArrayList<?> elements) {
       for (Object e : elements) {
       		if (e == null) return true;
       	}
       return false;
   	}


- Since the type parameter of the ArrayList doesn’t matter, it makes sense to use an ArrayList<?>


	public static <T> boolean hasNulls(ArrayList<T> elements)


- Following Is Not Possible
 	
 	public static void swap(ArrayList<?> elements, int i, int j) {
       ? temp = elements.get(i);
       elements.set(i, elements.get(j));
       elements.set(j, temp);
	}


- Do This One With Wrapper Methods

	public static void swap(ArrayList<?> elements, int i, int j) {
       swapHelper(elements, i, j);
    }
   
   private static <T> void swapHelper(ArrayList<T> elements, int i, int j) {
       T temp = elements.get(i);
       elements.set(i, elements.get(j));
       elements.set(j, temp);
	}

- When generic types and methods were added to Java, the Java designers wanted the generic forms of classes to be compatible with their preexisting versions.

- For example, it should be possible to pass an ArrayList<String> to a method from pre-generic days that accepted the ArrayList class, which collects elements of type Object.

- The language designers decided on an implementation that “erases” the types in the virtual machine. This was very popular at the time since it enabled Java users to gradually migrate to using generics


- there are drawbacks to this scheme, and, as so often happens

- with compromises made in the interest of compatibility, the drawbacks remain long after the migration has successfully completed.

- When you define a generic type, it is compiled into a raw type.

- For example, the Entry<K, V> class 

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

// turns into

	public class Entry { 
		private Object key; 
		private Object value;

		public Entry(Object key, Object value) { 
			this.key = key;
		           this.value = value;
		}
		public Object getKey() 	{ return key; }
		public Object getValue() { return value; } 
	}


- Every K and V is replaced by Object.

- If a type variable has bounds, it is replaced with the first bound.

- Suppose we declare the Entry class as

	public class Entry<K extends Comparable<? super K> & Serializable,
                      V extends Serializable>

- Then it is erased to a class

	public class Entry {
		private Comparable key; 
		private Serializable value; 
		...
	}

- Erasure sounds somehow dangerous, but it is actually perfectly safe.

	Entry<String, Integer> entry = ...;

   	String key = entry.getKey();
   	// replaced with following 

	String key = (String) entry.getKey();

- When erasing method parameter and return types, it is sometimes necessary for the compiler to synthesize bridge methods.

- This is an implementation detail, and you don’t need to know about it unless you want to know why such a method shows up in a stack trace, or you want an explanation for one of the more obscure limitations on Java generics

	public class WordList extends ArrayList<String> {
		public boolean add(String e) {
			return isBadWord(e) ? false : super.add(e);
	    }
		... 
	}

	Object get(int) // Overrides the method defined in ArrayList
	
	String get(int) // Defined in WordList

- These methods have the same parameter types but different return types. 
- In the Java language, you cannot implement such a pair of methods. 
- But in the virtual machine, a method is specified by its name, the parameter types, and the return type, which allows the compiler to generate this method pair.

- NOTE: Bridge methods are not only used for generic types. They are also used to implement covariant return types.


No Primitive Type Arguments
________________________________________________________________________

- A type parameter can never be a primitive type. For example, you cannot form an ArrayList<int>. As you have seen, in the virtual machine there is only one type, the raw ArrayList that stores elements of type Object. An int is not an object.

- When generics were first introduced, this was not considered a big deal. After all,

- one can form an ArrayList<Integer> and rely on autoboxing

- Now that generics are more commonly used, however, the pain is increasing. There is a profusion of functional interfaces such as IntFunction, LongFunction, DoubleFunction, ToIntFunction, ToLongFunction, ToDoubleFunction—and that only takes care of unary functions and three of the eight primitive types.

- In the virtual machine, there are only raw types. For example, you cannot inquire at runtime whether an ArrayList contains String objects.


At Runtime, All Types Are Raw
________________________________________________________________________

- In the virtual machine, there are only raw types. For example, you cannot inquire at runtime whether an ArrayList contains String objects.

- A condition such as

	if (a instanceof ArrayList<String>)

- is a compile-time error since no such check could ever be executed.

- A cast to an instantiation of a generic type is equally ineffective, but it is legal.

		Object result = ...;
	    ArrayList<String> list = (ArrayList<String>) result;


- Such a cast is allowed because there is sometimes no way to avoid it. If result is the outcome of a very general process (such as calling a method through reflection and its exact type is not known to the compiler, the programmer must use a cast and its exact type is not known to the compiler, the programmer must use a cast. A cast to ArrayList or ArrayList<?> would not suffice.

// @SuppressWarnings

	@SuppressWarnings("unchecked")
	ArrayList<String> list = (ArrayList<String>) result;


You Cannot Instantiate Type Variables
________________________________________________________________________

- You cannot use type variables in expressions such as new T(...) or new T[...].

- These forms are outlawed because they would not do what the programmer intends when T is erased.


- If you want to create a generic instance or array, you have to work harder. Suppose you want to provide a repeat method so that Arrays.repeat(n, obj) makes an array containing n copies of obj. Of course, you’d like the element type of the array to be the same as the type of obj. This attempt does not work:

	public static <T> T[] repeat(int n, T obj) {
       T[] result = new T[n]; // Error
       for (int i = 0; i < n; i++) result[i] = obj;
       return result;
	}

	
	// Here is the implementation of the method:   

    public static <T> T[] repeat(int n, T obj, IntFunction<T[]> constr) {
       T[] result = constr.apply(n);
       for (int i = 0; i < n; i++) result[i] = obj;
       return result;
	}

	String[] greetings = Arrays.repeat(10, "Hi", String[]::new);


	// Alternative Approach__________________
	
	public static <T> T[] repeat(int n, T obj, Class<T> cl) {
       @SuppressWarnings("unchecked") T[] result
           = (T[]) java.lang.reflect.Array.newInstance(cl, n);
       for (int i = 0; i < n; i++) result[i] = obj;
       return result;
	}

	String[] greetings = Arrays.repeat(10, "Hi", String.class);



	public class ArrayList<E> {
	    private Object[] elementData;
	    
	    public E get(int index) {
	    	return (E) elementData[index];
	    }   
		... 
	}


