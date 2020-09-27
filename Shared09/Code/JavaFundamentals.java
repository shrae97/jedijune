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
import java.util.Scanner;
import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


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

// import java.util.*;

class DoDemo {
   public void doWhileLoop() {
      Random generator = new Random();      
      int target = 5;
      int count = 1;
      int next;
      
      do {
         next = generator.nextInt(10);
         count++;
      } while (next != target);
         
      System.out.println("After " + count + " iterations, there was a values of " + target);
   }
}

// import java.util.*;

class ForDemo {
   public void forLoop() {
      Random generator = new Random();      
      int count = 20;
      int sum = 0;
      
      for (int i = 1; i <= count; i++) {
         int next = generator.nextInt(10);
         sum = sum + next;         
      }
      System.out.println("After " + count 
         + " iterations, the sum is " + sum);
   }
}

// import java.util.*;

class WhileDemo {
   public void whileLoop() {
      Random generator = new Random();
      int sum = 0;
      int count = 0;
      int target = 90;
      while (sum < target) {
         int next = generator.nextInt(10);
         sum = sum + next;
         count++;
      }
      System.out.println("After " + count 
         + " iterations, the sum is " + sum);
   }
}

// import java.util.Arrays;

class ArrayDemo {
    public void workWithArrays() {
    	// new wrapper malloc
        // Ten Elements : Inialised With null Value
        String[] names = new String[10];
        // String * names = ( String * ) malloc( sizeof(String *) * 10 )

        for (int i = 0; i < names.length / 2; i++) {
            names[i] = "";
        }

        System.out.println("names="+Arrays.toString(names));
        
        // Pointer Operator/Indirection Operation  
        // 		*  Not Available In Java
        names[0] = "Fred";
        names[1] = names[0];
        System.out.println("names="+Arrays.toString(names));

        names[0] = "Ding Dong";
        names[3] = "Fred";
		System.out.println("names="+Arrays.toString(names));
    }
}

class ArrayListDemo {
    public void workWithArrayList() {
        ArrayList<String> friends = new ArrayList<>();
        friends.add("Peter");
        friends.add("Paul");
        friends.remove(1);
        friends.add(0, "Paul"); 
        
        System.out.println("friends=" + friends);
        
        String first = friends.get(0);
        System.out.println("first=" + first);

        friends.set(1, "Mary");        
        for (int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }

        ArrayList<String> people = friends;
        people.set(0, "Mary"); // now friends.get(0) is also "Mary"
        System.out.println("friends=" + friends);

        // In Java Assignment (=) Is
        //      Just Reference Assignment
        //      Of New Object Created On Heap
        ArrayList<String> copiedFriends = new ArrayList<>(friends);
        copiedFriends.set(0, "Fred");
        System.out.println("copiedFriends=" + copiedFriends);
        System.out.println("friends=" + friends);

        // In Java Assignment (=) Is
        //      Just Reference Assignment
        //      Of Existing Object On Heap
        ArrayList<String> copiedFriends1 = friends;
        copiedFriends1.set(0, "Fred");
        System.out.println("copiedFriends1=" + copiedFriends1);
        System.out.println("friends=" + friends);

        // friends = new ArrayList<>(List.of("Peter", "Paul", "Mary"));
        // String[] names = friends.toArray(new String[0]);
        // System.out.println("names=" + Arrays.toString(names));               
    
        Collections.reverse(friends);
        System.out.println("After reversing, friends=" + friends);
        
        Collections.shuffle(friends);
        System.out.println("After shuffling, friends=" + friends);
        
        Collections.sort(friends);        
        System.out.println("After sorting, friends=" + friends);
    }
}

class TwoDimentionalArrayDemo {
    public void workingWith2DArray() {
        // 2D Array
        int[][] square = {
                { 16, 3, 2, 13 },
                { 3, 10, 11, 8 },
                { 9, 6, 7, 12 },
                { 4, 15, 14, 1}
        };

        int[] temp = square[0];
        square[0] = square[1];
        square[1] = temp;
        System.out.println(Arrays.deepToString(square));
        // [[3, 10, 11, 8], [16, 3, 2, 13], [9, 6, 7, 12], [4, 15, 14, 1]]
        
        int n = 5;
        
        // 2D Array
        //      Array of Pointers/Reference To Arrays
        //      
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
            triangle[i][0] = 1;
            triangle[i][i] = 1;
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }

        for (int r = 0; r < triangle.length; r++) {
            for (int c = 0; c < triangle[r].length; c++) {
                System.out.printf("%4d", triangle[r][c]);
            }
            System.out.println();
        }

        // Array Internals
        for (int[] row : triangle) {
            for (int element : row) {
               System.out.printf("%4d", element);
            }
            System.out.println();
        }
    }
}


class ArrayMethodDemo {
    // In Java//C/C++
    //     Array Are Passed By Reference
    //     But Reference To Array Is Pass By Value
    //     Becase Array Names Are Constant Pointers In C/C++
    //        and In Java final
    public void swap(int[] values, int i, int j) {
        int temp = values[i];  // temp = * (values + i)
        // values = { 10, 20, 30 } ;
        values[i] = values[j]; // * (values + i) = * (values + j)
        values[j] = temp;      // * (values + j) = temp
    }
    
    public int[] firstLast(int[] values) {
        if (values.length == 0) return new int[0];
        else return new int[] { values[0], values[values.length - 1] };
    }

    public void workWithArrayMethodDemo() {
        int[] fibs = { 1, 1, 2, 3, 5, 8, 11, 13 };
        swap(fibs, 2, fibs.length - 2);
        System.out.println(Arrays.toString(fibs));
        System.out.println(Arrays.toString(firstLast(fibs)));        
    }
}

// GIFT QUESTIONS....
// How Compiler, Runtime Enviroment Able To Figure Out
    // How To Figure Out Size Of Memory For Varidiac Arugments?
    // Where It Will Be Allocated?
    // How It will Be Allocated?


class VarargsDemo {
    // Varidiac Functions
    //      Variable Number of Arguments
    //      Of Same Type
    public double average(double... values) {
        double sum = 0;
        // values will be array of double type
        for (double v : values) sum += v;
        return values.length == 0 ? 0 : sum / values.length;
    }    

    // Varidiac Functions
    //      Variable Number of Arguments
    //      Of Same Type
    // As Well As Fixed Arguments    
    //      Fixed Arguments Followed By Varidiac Arguments Not Otherwise
    public double max(double first, double... rest) {
        double result = first;
        // Programmer Perceptive
        // 
        for (double v : rest) result = Math.max(v, result);
        return result;
    }

    // Compilation Error
    // Following Is Not Allowed By Compiler
    //      Because It Makes Function Call Ambigious
    //      On Failer To Map Values Supplied To Arguments
    // double largest = max1(3, 4.5, 10, 0);
    // public double max1(double... rest, double first) {
    //     double result = first;
    //     for (double v : rest) result = Math.max(v, result);
    //     return result;
    // }

    public void workingWithVarargsDemo() {
        int n = 42;
        System.out.printf("%d\n", n);
        System.out.printf("%d %s\n", n, "widgets");
        
        double[] scores = { 3, 4.5, 10, 0 };
        double avg = average(scores);
        System.out.println(avg);
        
        double largest = max(3, 4.5, 10, 0);
        System.out.println(largest);
    }
}

// Function : playWithVarargsDemo
// 42
// 42 widgets
// 4.375
// 10.0

public class JavaFundamentals {
    public static void playWithVarargsDemo() {
        VarargsDemo object = new VarargsDemo();
        object.workingWithVarargsDemo();                
    }
    public static void playWithArrayMethodDemo() {
        ArrayMethodDemo object = new ArrayMethodDemo();
        object.workWithArrayMethodDemo();                
    }
    public static void playWithTwoDimentionalArrayDemo() {
        TwoDimentionalArrayDemo object = new TwoDimentionalArrayDemo();
        object.workingWith2DArray();                
    }
    public static void playWithArrayListDemo() {
        ArrayListDemo object = new ArrayListDemo();
        object.workWithArrayList();        
    }

    public static void playWithArrayDemo() {
		ArrayDemo object = new ArrayDemo();
		object.workWithArrays();
	}

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

		// System.out.println("\nFunction : playWithInputDemo");
		// playWithInputDemo();

		System.out.println("\nFunction : playWithArrayDemo");
		playWithArrayDemo();

		System.out.println("\nFunction : playWithArrayListDemo");
        playWithArrayListDemo();

		System.out.println("\nFunction : playWithTwoDimentionalArrayDemo");
        playWithTwoDimentionalArrayDemo();

		System.out.println("\nFunction : playWithArrayMethodDemo");
        playWithArrayMethodDemo();

        System.out.println("\nFunction : playWithVarargsDemo");
        playWithVarargsDemo();

		// System.out.println("\nFunction : ");
		// System.out.println("\nFunction : ");
		// System.out.println("\nFunction : ");
		// System.out.println("\nFunction : ");
		// System.out.println("\nFunction : ");
		// System.out.println("\nFunction : ");
	}
}


