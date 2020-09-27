/*
javac -version
javac JavaFundamentals.java -d ClassFiles
java -cp ClassFiles learnJava.JavaFundamentals
*/

package learnJava;

import java.util.Random;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Scanner;

class HelloWorld {
	public void helloWorld() {
		System.out.println("Hello World!!!");
	}
}

class NumberDemo {
    public void printNumberValues() {

    	// Constant Literals

        System.out.println(4000000000L); // long literal , base 10
        System.out.println(0xCAFEBABE); // hex literal, base 16
        System.out.println(0b1001); // binary literal, base 2
        System.out.println(011); // octal literal, base 8
        
        // Underscores in literals , Underscore will be ignore by compiler
        // For Programmer Convenience 
        System.out.println(1_000_000_000); 
        System.out.println(0b1111_0100_0010_0100_0000);
        
        // Advanced topic: Unsigned quantities
        System.out.println(Byte.toUnsignedInt( (byte )-127) );
        
        System.out.println(3.14F); // float literal, making it float type, base 10
        System.out.println(3.14); // double literal, default is double type, base 10
        System.out.println(3.14D); // double literal, base 10
        System.out.println(0x1.0p-3); // hex double literal, base 16

        // Infinity and NaN
        System.out.println(1.0 / 0.0); 
        System.out.println(-1.0 / 0.0);
        System.out.println(0.0 / 0.0);
  		// Infinity
		// -Infinity
		// NaN

        // BAD CODE : NEVER EVERY USE EQUALITY OPERATOR TO COMPARE INFINITIES AND NaN
        System.out.println(1.0 / 0.0 == Double.POSITIVE_INFINITY);
        System.out.println(-1.0 / 0.0 == Double.NEGATIVE_INFINITY);
        System.out.println(0.0 / 0.0 == Double.NaN);
  		//  true
		// true
		// false
        
        System.out.println(Double.isInfinite(1.0 / 0.0));
        System.out.println(Double.isInfinite(-1.0 / 0.0));
        System.out.println(Double.isNaN(0.0 / 0.0));
        System.out.println(Double.isFinite(0.0 / 0.0));
		System.out.println(Double.isInfinite(2.0 / 0.0));
		
		System.out.println(2.0 - 1.1);

		// BAD CODE        
		// if (2.0 - 1.1 == 0.9 ) {
		// } else {
		// }

        // Character literals    
        // Unicode Character    
        System.out.println('J'); 
        System.out.println('J' == 74); 
        System.out.println('\u004A'); 
        System.out.println('\u263A'); 
    }
}

// Creating Variables, Constants and Instances/Objects of Given Type
class VariableDemo {
    public static final int DAYS_PER_YEAR = 365; // Constant and Immutable
    
    enum Weekday { MON, TUE, WED, THU, FRI, SAT, SUN };
    
    // BEST PRACTICE
    // Always Initialise Variables/Instance with Legal Values

    public void printVariables() {
        int total = 0;
        System.out.println(total);

        int i = 0, count;
		// System.out.println(count);        

        Random generator = new Random();
        double lotsa$ = 1000000000.0; // Legal, but not a good idea
        double elevation = 0.0;
        double π = 3.141592653589793;
        String Count = "Dracula"; // Not the same as count
        int countOfInvalidInputs = 0; // Example of camelCase

        // BEST PRACTICE
        // Constats are named in CAPTITALS
        final int DAYS_PER_WEEK = 7;  	// Constant or Immutable
        Weekday startDay = Weekday.MON; // startDay is Type of Weekday Enum Constants
	}
}

class ArithmeticDemo {
    public void doArithmatic() {
        // Division and remainder
        System.out.println(17 / 5);
        System.out.println(17 % 5);
        System.out.println(Math.floorMod(17, 5));
        
        System.out.println(-17 / 5);
        System.out.println(-17 % 5);
        System.out.println(Math.floorMod(-17, 5));
        
        // Increment and decrement
        int[] a = { 17, 29 };
        int n = 0;
        System.out.printf("%d %d\n", a[n++], n); 
        n = 0;
        System.out.printf("%d %d\n", a[++n], n);
        
        // Powers and roots
        System.out.println(Math.pow(10, 9));
        System.out.println(Math.sqrt(1000000));
        
        // Number conversions        
		// R.H.S Type in int
		// L.H.S Type is double
        double x = 42; // int implicitly getting converted to double
        System.out.println(x); // 42.0
        
        float f = 123456789; // int implicitly getting converted to float
        System.out.println(f); // 1.23456792E8
        
        x = 3.75;    // 3.75 is double type value getting assigned to x of double type
        n = (int) x; // double explicitly getting converted to int
        System.out.println(n); // 3
        
        n = (int) Math.round(x); 
        System.out.println(n); // 4
        
        System.out.println('J' + 1); // 75
        char next = (char) ('J' + 1); 
        System.out.println(next); // 'K'
        
        n = (int) 3000000000L; 
        System.out.println(n); // -1294967296
    }
}

// import java.math.BigDecimal;
// import java.math.BigInteger;

class BigNumberDemo {
    public void doCalculation() {
        BigInteger n = BigInteger.valueOf(876543210123456789L);
        BigInteger k = new BigInteger("9876543210123456789");
        BigInteger r = BigInteger.valueOf(5).multiply(n.add(k)); // r = 5 * (n + k)
        
        System.out.println(r);
        System.out.println(2.0 - 1.1);

        BigDecimal d = BigDecimal.valueOf(2, 0).subtract(BigDecimal.valueOf(11, 1));
        System.out.println(d);
    }
}

class RelationalDemo {
    public void doRelationalOperations() {
        int length = 10;
        int n = 7;
        System.out.println(0 <= n && n < length);
        
        // Short circuit evaluation
        int s = 30;
        System.out.println(n != 0 && s + (100 - s) / n < 50);
        n = 0;
        System.out.println(n != 0 && s + (100 - s) / n < 50);
        System.out.println(n == 0 || s + (1 - s) / n >= 50);
        
        int time = 7;
        System.out.println(time < 12 ? "am" : "pm");
    }
}

// import java.time.ZoneId;
// import java.util.Arrays;

// Design Thinking : Mutability and Immutability
// Design Systems Towards Immutability Rather Than Mutability

class StringDemo {
    public void stringExperients() {
        String location = "Java"; // "Java" String Literal is Immutable/Constant
        String greeting = "Hello " + location; // "Hello " String Literal is Immutable/Constant
        System.out.println(greeting);
        
        int age = 42;
        String output = age + " years"; // Implicit Type Conversion: int to String
        System.out.println(output);
        
        System.out.println("Next year, you will be " + age + 1); // Logical Error
        System.out.println("Next year, you will be " + (age + 1)); // Ok
        
        String names0 = ", " + "Peter" + "Paul" + "Mary"; // Inefficient Space/Time Wise
        
        // Prefer Join Function To Concatenate Large Number Of Strings
        String names = String.join(", ", "Peter", "Paul", "Mary"); 
        System.out.println(names);

		// String Builder
        StringBuilder builder = new StringBuilder();
        for (String id : ZoneId.getAvailableZoneIds()) {
            builder.append(id);
            builder.append(", ");
        }
        String result = builder.toString(); // Immutable String Generated

        System.out.println(result.substring(0, 200) + "...");
        System.out.println(result.length());

        // Substring
        greeting = "Hello, World!";
        location = greeting.substring(7, 12);
        System.out.println(location);

		// Equality testing
        System.out.println(location.equals("World"));
        System.out.println(location == "World");
        System.out.println(location.equalsIgnoreCase("world"));
        System.out.println("word".compareTo("world"));

        // Converting between numbers and strings
        int n = 42;
        String str = Integer.toString(n, 2);
        System.out.println(str);
        
        n = Integer.parseInt(str);
        System.out.println(n);

        n = Integer.parseInt(str, 2);
        System.out.println(n);

        double x = Double.parseDouble("3.14"); 
        System.out.println(x);
        
        System.out.println(greeting.toUpperCase());
        System.out.println(greeting); // greeting is not changed

        // Unicode
        String javatm = "Java\u2122"; // Unicode String : UTF16
        System.out.println(javatm);
        System.out.println(Arrays.toString(javatm.codePoints().toArray()));
        System.out.println(javatm.length());
        
        String octonions = "\ud835\udd46";
        System.out.println(octonions);
        System.out.println(Arrays.toString(octonions.codePoints().toArray()));
        System.out.println(octonions.length()); // Counts code units, not Unicode code points
	}
}

// import java.util.Scanner;
class InputDemo {
    public void takeInputs() {
        Scanner in = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = in.nextLine();
        System.out.println("How old are you?");
        if (in.hasNextInt()) {
            int age = in.nextInt();
            System.out.printf("Hello, %s. Next year, you'll be %d.\n", name, age + 1);
        } else {
            System.out.printf("Hello, %s. Are you too young to enter an integer?", name);
        }
    }
}


public class JavaFundamentals {
	public static void playWithInputDemo() {
		InputDemo object = new InputDemo();
		object.takeInputs();
	}

	public static void playWithStringDemo() {
		StringDemo object = new StringDemo();
		object.stringExperients();
	}

	public static void playWithRelationalDemo() {
		RelationalDemo relational = new RelationalDemo();
		relational.doRelationalOperations();
	}

	public static void playWithBigNumbers() {
		BigNumberDemo bignumbers = new BigNumberDemo();
		bignumbers.doCalculation();
	}

	public static void playWithArithmaticDemo() {
		ArithmeticDemo arithmatic = new ArithmeticDemo();
		arithmatic.doArithmatic();
	}

	public static void playWithVariables() {
		VariableDemo variables = new VariableDemo();
		variables.printVariables();
	}

	public static void playWithNumbers() {
		NumberDemo numbers = new NumberDemo();
		numbers.printNumberValues();
	}

	public static void playWithHelloWorld() {
		// hello is Instance/Object of Type HelloWorld
		HelloWorld hello = new HelloWorld();
		
		// Invoking a Member Function With Instance/Object
		hello.helloWorld(); 
	}

	public static void main( String[] args ) {
		System.out.println("\nFunction : playWithHelloWorld");
		playWithHelloWorld();

		System.out.println("\nFunction : playWithNumbers");
		playWithNumbers();

		System.out.println("\nFunction : playWithVariables");
		playWithVariables();

		System.out.println("\nFunction : playWithArithmaticDemo");
		playWithArithmaticDemo();

		System.out.println("\nFunction : playWithBigNumbers");
		playWithBigNumbers();

		System.out.println("\nFunction : playWithRelationalDemo");
		playWithRelationalDemo();

		System.out.println("\nFunction : playWithStringDemo");
		playWithStringDemo();

		System.out.println("\nFunction : playWithInputDemo");
		playWithInputDemo();
		// System.out.println("\nFunction : ");
		// System.out.println("\nFunction : ");
		// System.out.println("\nFunction : ");
	}
}

