package learnJava;

// Write Code In Java To Simulate Stack Of Type Data

package learnJava;

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


class StringStack {
	private String[] arr;
	private int size;
	private static int i = 0;

	public IntegerStack(String n) {
		this.arr = new String[n];
		this.size = n;
	}

	public void push(String x) {
		if(i == size)
			System.out.println("Overflow");
		else {
			arr[i++] = x;
		}
	}

	public String pop() {
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
public class MyGenericsStack<T> { 
    private int stackSize;
    private T[] stackArr;
    private int top;
    
    @SuppressWarnings("unchecked") 
    public MyGenericsStack(int size) {
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
     
    public static void main(String a[]){
        MyGenericsStack<String> stringStack = new MyGenericsStack<String>(2);
        stringStack.push("java2novice");

        MyGenericsStack<Integer> integerStack = new MyGenericsStack<Integer>(2);
        integerStack.push(23);
    }
}

class GenericStack <T> {
   private ArrayList<T> stack = new ArrayList<T> ();
   private int top = 0;

   public int size () { return top; }

   public void push (T item) {
      stack.add (top++, item);
   }

   public T pop () {
      return stack.remove(--top);
   }

   public static void main (String[] args) {
      GenericStack<Integer> s = new GenericStack<Integer> ();
      s.push (17);
      int i = s.pop ();
      System.out.format ("%4d%n", i);
   }

}

class StackDemo {
	public static void main(String[] args) {
		IntegerStack S = new IntegerStack(4);
		for(int i=0; i<6; i++) {
			S.push(i.toString());
		}

		System.out.println(S);
		S.pop();
		
		System.out.println(S);
		S.pop();
		
		System.out.println(S);
	}
}