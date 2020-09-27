package learnJava;

/*
javac -version
javac CollectionsInJava.java -d ClassFiles
java -cp ClassFiles learnJava.CollectionsInJava
*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.PriorityQueue;

class IteratorDemo {
    public static void playWithIteratorDemo() {
        Collection<String> coll = new ArrayList<>();
        coll.add("Peter");
        coll.add("Paul");
        coll.add("Mary");

        Iterator<String> iter = coll.iterator();
        
        while (iter.hasNext()) {
            String element = iter.next();
            process(element);
        }
        
        iter = coll.iterator();
        while (iter.hasNext()) {
            String element = iter.next();
            if (element.startsWith("M"))
                iter.remove();
        } 
        
        coll.removeIf(e -> e.endsWith("r"));
        
        for (String element : coll) 
            process(element);

        // Compiler Will Generate Following Code For This Line
        // for (String element : coll) 

	  //       Iterator<String> iterator = coll.iterator();
			// while (iterator.hasNext()) {
	  //           String element = iterator.next();
	  //           process(element);
	  //       }
    }
    
    public static void process(String s) { System.out.println("Processing " + s); }
}

class ListIteratorDemo {
    public static void playWithListIteratorDemo() {
        List<String> friends = new LinkedList<>();
        ListIterator<String> iter = friends.listIterator();
        iter.add("Fred"); // Fred |
        iter.add("Wilma"); // Fred Wilma |
        iter.previous(); // Fred | Wilma
        iter.set("Barney"); // Fred | Barney

        System.out.println(friends);
    }
}

// import java.util.ArrayList;
// import java.util.Collection;
// import java.util.Iterator;

class ConcurrentModificationDemo {
    public static void playWithConcurrentModificationDemo() {
        Collection<String> coll = new ArrayList<>();
        coll.add("Peter");
        coll.add("Paul");
        coll.add("Mary");
        System.out.println(coll);
        
        Iterator<String> iter1 = coll.iterator();
        Iterator<String> iter2 = coll.iterator();
        
        iter2.next();
        // iter2.remove();
        System.out.println(coll);
        
        iter1.next();
        System.out.println(coll);
    }
}

// import java.util.HashSet;
// import java.util.Scanner;
// import java.util.Set;
// import java.util.TreeSet;

class SetDemo {
    public static void playWithSetDemo() {
        Set<String> badWords = new HashSet<>();
        badWords.add("sex");
        badWords.add("drugs");
        badWords.add("c++");
        
        Scanner in = new Scanner(System.in);
        System.out.print("Please choose a user name: ");
        String username = in.next();        
        if (badWords.contains(username.toLowerCase()))
            System.out.println("Please choose a different user name");
        else
            System.out.println("Registered " + username + " since it wasn't one of " + badWords);
        
        TreeSet<String> countries = new TreeSet<>( (u, v) ->
            u.equals(v) ? 0
            : u.equals("USA") ? -1
            : v.equals("USA") ? 1
            : u.compareTo(v));
        
        countries.add("Bahrain");
        countries.add("Australia");
        countries.add("USA");
        countries.add("Canada");
        System.out.println(countries);
    }
}

// import java.util.HashMap;
// import java.util.Map;

// Map is Set of (K, V) Tuples
// { (K,V), K in RangeOfType1 and V in RangeOfType2, K is Hashable }

class MapDemo {
    public static void playWithMapDemo() {
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Alice", 1); // Adds the key/value pair to the map
        counts.put("Alice", 2); // Updates the value for the key
        
        int count = counts.get("Alice");
        System.out.println(count);
        count = counts.getOrDefault("Barney", 0);
        System.out.println(count);
        
        String word = "Fred";
        counts.merge(word, 1, Integer::sum);
        counts.merge(word, 1, Integer::sum);
        System.out.println(counts.get(word));

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            process(key, value);
        }
        
        counts.forEach((k, v) -> process(k, v));
    }
    
    public static void process(String key, Integer value) {
        System.out.printf("Processing key %s and value %d\n", key, value);
    }
        
}

// import java.util.ArrayDeque;
// import java.util.Queue;

class StackQueueDemo {
    public static void playWithStackAndQueue() {
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("Peter");
        stack.push("Paul");
        stack.push("Mary");
        while (!stack.isEmpty())
            System.out.println(stack.pop());
        
        System.out.println();
        
        Queue<String> queue = new ArrayDeque<>();
        queue.add("Peter");
        queue.add("Paul");
        queue.add("Mary");
        while (!queue.isEmpty())
            System.out.println(queue.remove());
        
    }
}

// import java.util.PriorityQueue;

class Job implements Comparable<Job> {
    private int priority;
    private String description;
    
    public Job(int priority, String description) {
        this.priority = priority;
        this.description = description;
    }

    public int compareTo(Job other) {
        return priority - other.priority;
    }
    
    public String getDescription() {
        return description;
    }
}

class PriorityQueueDemo {
    public static void playWithPriorityQueueDemo() {
        PriorityQueue<Job> jobs = new PriorityQueue<>();
        jobs.add(new Job(4, "Collect garbage"));
        jobs.add(new Job(9, "Match braces"));
        jobs.add(new Job(1, "Fix memory leak"));
        
        while (jobs.size() > 0) {
            Job job = jobs.remove(); // The most urgent jobs are removed first
            execute(job);
        } 
    }
    
    public static void execute(Job job) {
        System.out.println(job.getDescription());
    }
}


class CollectionsInJava {
	public static void main(String[] args) {
		System.out.println("\nFunction : playWithIteratorDemo");
		IteratorDemo.playWithIteratorDemo();

		System.out.println("\nFunction : playWithListIteratorDemo");
		ListIteratorDemo.playWithListIteratorDemo();
		
		System.out.println("\nFunction : playWithConcurrentModificationDemo");
		ConcurrentModificationDemo.playWithConcurrentModificationDemo();
		
		System.out.println("\nFunction : playWithSetDemo");
		SetDemo.playWithSetDemo();

		System.out.println("\nFunction : playWithStackAndQueue");
		StackQueueDemo.playWithStackAndQueue();

		System.out.println("\nFunction : playWithPriorityQueueDemo");
		PriorityQueueDemo.playWithPriorityQueueDemo();

		// System.out.println("\nFunction : ");
		// System.out.println("\nFunction : ");
		// System.out.println("\nFunction : ");
		// System.out.println("\nFunction : ");

	}
}