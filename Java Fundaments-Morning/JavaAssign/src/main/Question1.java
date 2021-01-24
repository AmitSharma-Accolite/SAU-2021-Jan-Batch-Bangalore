package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;



public class Question1 {
    public static void main(String []args) {
    	
    	Scanner sc = new Scanner(System.in);
        
    	
    	/*
    	 * Create  Sortedset to store value 
    	 * 
    	 */
    	SortedSet<Integer> set = new TreeSet<>();  
    	
    	String indicater = "s";
    	Integer insert = 0;
    	
    	/*
    	 * Every iteration ask for exit or continue for add new number in the set 
    	 */
    	while(indicater.equals("s")) {
    		System.out.println("Enter Number");
    		insert = sc.nextInt();
    		set.add(insert);
    		
    		
    		System.out.println("Enter any character for exit or Enter s for continue add element");
    		indicater = sc.next();
    		
    	}
    	
    	/*
    	 * Creating iterator to traverse the set and print the result 
    	 * Elements inside the Treeset are already store in stored passion 
    	 */
    	System.out.println("Result");
    	Iterator<Integer> itr=set.iterator();  
    	while(itr.hasNext()){  
    	System.out.println(itr.next());  
    	} 
    	
    	
    	/*
    	 *  List have to sort and after that print 
    	 *   input Hard coded 
    	 */
    	ListSort();
    	
    }
    
    
    public static void ListSort() {
    	
    	 System.out.println("For List ");
    	List<Integer> list=new ArrayList<>();
        list.add(2);
        list.add(-2);
        list.add(10);
        list.add(0);
        System.out.println("Result");
    
    	/*
    	 * Sorting elements of list by using Collections.sort()
    	 */
    	Collections.sort(list);
    	System.out.println(list);

    }
    
    
    
    
    
    
    
}
