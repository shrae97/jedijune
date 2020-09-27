
class Employee {
   private String name;
   private int age;

   Employee(String name, int age){
      this.name = name;
      this.age = age;
   }

   // Bad Code
   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      }

      if (!(obj instanceof Employee)) {
         return false;
      }
      
      Employee emp = (Employee) obj;
      return name.equals(emp.name) && Integer.compare(age, emp.age) == 0;
   }
}

public class EqualsExample {
   public static void main(String[] args) {

      Employee emp1 = new Employee("Jhon", 19);
      Employee emp2 = new Employee("Jhon", 19);
    
      //Comparing the two objects
      boolean bool = emp1.equals(emp2);
      System.out.println(bool);
   }
}

// _________________________________________________________________
// Following Code Will Work In All Scenarios... Yes/No?
class Money {
    int amount;
    String currencyCode;
}

class Voucher extends Money { 
    private String store;
 
 	// Very Very Bad Code
    @Override
    public boolean equals(Object o) {
        if (o == null ) return false;

        if (o == this)
            return true;

        if (!(o instanceof Voucher)) // Because of This Line
            return false;
        
        Voucher other = (Voucher)o;
        
        boolean currencyCodeEquals = (this.currencyCode == null && other.currencyCode == null)
          || (this.currencyCode != null && this.currencyCode.equals(other.currencyCode));
        
        boolean storeEquals = (this.store == null && other.store == null)
          || (this.store != null && this.store.equals(other.store));
        
        return this.amount == other.amount && currencyCodeEquals && storeEquals;
    }
    // other methods and hashCode() overriden
}

Money cash = new Money(42, "USD");
Voucher voucher = new Voucher(42, "USD", "Amazon");
 
voucher.equals(cash) => false // As expected.
cash.equals(voucher) => true // That's wrong.


// _____________________________________________________________________
// Geeks For Geeks

class RealNumbers {

}

class Complex extends RealNumbers {  
    private double re, im; 
  
    public Complex(double re, double im) { 
        this.re = re; 
        this.im = im; 
    } 
  
    // Overriding equals() to compare two Complex objects 
    @Override
    public boolean equals(Object o) { 
  
        // If the object is compared with itself then return true   
        if (o == this) { 
            return true; 
        } 
  
        /* Check if o is an instance of Complex or not 
          "null instanceof [type]" also returns false */
        if (!(o instanceof Complex)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        Complex c = (Complex) o; 
          
        // Compare the data members and return accordingly  
        return Double.compare(re, c.re) == 0
                && Double.compare(im, c.im) == 0; 
    } 
} 
  
// Driver class to test the Complex class 
public class Main { 
  
    public static void main(String[] args) { 
        Complex c1 = new Complex(10, 15); 
        Complex c2 = new Complex(10, 15); 
        if (c1.equals(c2)) { 
            System.out.println("Equal "); 
        } else { 
            System.out.println("Not Equal "); 
        } 
    } 
} 





