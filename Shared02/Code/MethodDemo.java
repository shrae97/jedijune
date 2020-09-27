/*
javac -version
javac MethodDemo.java -d ClassFiles
java -cp ClassFiles learnJava.MethodDemo
*/

package learnJava;

// Importing Libaries 
import java.util.Random;

public class MethodDemo {
	public static void playWithGenerator() {
		System.out.println(new Random().nextInt());

		// Creating Object of Random Type
		// generator is Object/Instance of Type Random
		Random generator = new Random();

		// nextInt is Instance/Object Member Function
		// Invoking Instance Member Function
		// generator.nextInt() is invoking member function
		System.out.println( generator.nextInt() );
		System.out.println( generator.nextInt() );
	}

	public static void main( String[] args ) {
		System.out.println("Hello World!!!");

		playWithGenerator();
	}
}
