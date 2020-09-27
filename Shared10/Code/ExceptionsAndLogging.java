package learnJava;

/*
javac -version
javac ExceptionsAndLogging.java -d ClassFiles
java -cp ClassFiles learnJava.ExceptionsAndLogging
*/

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

class ThrowDemo {
    public static int randInt(int low, int high) {
        if (low > high)
            throw new IllegalArgumentException(
                "low should be <= high but low is "
                + low + " and high is " + high);

        return low + (int)(Math.random() * (high - low + 1));
    }
    
    public static void workingWithExceptions() {
        System.out.println("Generating a random number...");
        int r = randInt(10, 20);
        System.out.println("r = " + r);
        System.out.println("And another...");
        r = randInt(10, 5);
        System.out.println("r = " + r);
    }
}


class ThrowsNullPointerException { 	
	public static void throwsNullPointerException(){ 
		String str = null; 
		int a = 10;
		int b = 0, c = 0;

		// Validation : Object/Data Is Valid Or Not
		// Always Do With If/Else
		if (str != null ) System.out.println(str.length()); 
		else System.out.println("Met With Nothingnes..."); 

		if ( b != 0 ) c = a / b; 
		else 	System.out.println("Divion By Zero Not Possible..."); 

		// try {
		// 	int c = a / b; 
		// } catch ( ArithmeticException ex) {
		// 	System.out.println("Divion By Zero Not Possible..."); 
		// }

		// try {
		// 	System.out.println(str.length()); 
		// } catch(NullPointerException ex) {
		// 	System.out.println("Met With Nothingnes..."); 
		// }
	} 
} 

// BAD CODE
// Validation is Replaced with try-catch block
class ExceptionThrown  { 
	static int divideByZero(int a, int b){ 
		int i = a / b; 
		return i; 
	} 
	
	static int computeDivision(int a, int b) { 
		int res =0; 
		try { 
			res = divideByZero(a,b); 
		} catch(NumberFormatException ex) { 
			System.out.println("NumberFormatException is occured"); 
		} 
		return res; 
	} 
	
	public static void workingWithExceptions() { 
		int a = 1; 
		int b = 0; 
		try { 
			int i = computeDivision(a,b); 
		} catch(ArithmeticException ex) { 
			System.out.println(ex.getMessage()); 
		} 
	} 
} 

class ExceptionDemo { 	
	public static void throwsNullPointerException(){ 
		PrintWriter out = null;
		ArrayList<String> lines = new ArrayList<String>();
		lines.add("Ding Dong");
		lines.add("Ling Long");
		lines.add("Ting Tong");
		lines.add("Zing Zong");
	   	
	   	// Resources Are Files, Sockets, Memory, Devices etc.
	   	//		Opened References Are Maintained By Operating System
	   	//		Shared Across Multiple Processes
	   	//		Resouces Must Be Closed To Be Available For Other Processes
	   	
	   	try {
	   		out = new PrintWriter("output.txt");
			for (String line : lines) out.println(line.toLowerCase());
	   	} catch (IOException ex) {
	   		System.out.println("Unable To Open File...");
	   	} finally { // Happy+Unhappy Cases
	   		if (out != null) out.close();
	   	}

	   	// Always Prefer Following Try With Resources
	   	// try with Resources Syntax
		try ( PrintWriter out1 = new PrintWriter("output.txt") ) {
       		for (String line : lines) out1.println(line.toLowerCase());
       	} catch ( IOException ex ) {
       		System.out.println("Unable To Open File...");
       	}
   }
} 

// import java.util.Arrays;
// import java.util.Scanner;

class AssertionDemo {
    public static double[] solveQuadraticEquation(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        assert discriminant >= 0;
        // Assert Check Truthfulness of Expression
        assert a != 0 : "a == 0; not a quadradic equation";
		// If Assert Fails Following Code Has No Value
        
        double discrRoot = Math.sqrt(discriminant);

        return new double[] { 
                (-b - discrRoot) / (2 * a),
                (-b + discrRoot) / (2 * a)
        };
    }
    
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter a b c (e.g. 0 2 1)");
            double a = in.nextDouble();
            double b = in.nextDouble();
            double c = in.nextDouble();
            System.out.println(Arrays.toString(solveQuadraticEquation(a, b, c)));
        }
    }
}

// import java.util.logging.ConsoleHandler;
// import java.util.logging.Handler;
// import java.util.logging.Level;
// import java.util.logging.Logger;

class LoggingDemo {
    public static void playWithLogging() {
        Logger.getGlobal().info("Starting program");
        Logger.getGlobal().setLevel(Level.OFF);
        Logger.getGlobal().info("Global logger turned off");
 
        Logger logger = Logger.getLogger("com.horstmann.corejava");
        logger.fine("Global logger turned off");
        logger.setLevel(Level.FINE);

        logger.fine("Set logger to fine");
        logger.setUseParentHandlers(false);
        Handler handler = new ConsoleHandler();
        
        handler.setLevel(Level.FINE);
        logger.addHandler(handler);
        logger.fine("Configured handler");
    }
}

public class ExceptionsAndLogging {
	public static void playWithLoggingDemo() {
		LoggingDemo.playWithLogging();
	}
	
	public static void playWithThrowDemo() {
		//ThrowDemo.workingWithExceptions();
		ThrowsNullPointerException.throwsNullPointerException();
	}

	public static void main(String[] args) {
		System.out.println("\nFunction : playWithThrowDemo");
		playWithThrowDemo();

		System.out.println("\nFunction : playWithLoggingDemo");
		playWithLoggingDemo();
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