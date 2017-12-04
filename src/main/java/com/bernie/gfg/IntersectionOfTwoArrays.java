package com.bernie.gfg;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Stream;

public class IntersectionOfTwoArrays {
    // Prints union of arr1[0..m-1] and arr2[0..n-1]
    static void printUnion(int arr1[], int arr2[])
    {
        HashSet<Integer> hs = new HashSet<>();
         
        for (int i = 0; i < arr1.length; i++) 
            hs.add(arr1[i]);        
        for (int i = 0; i < arr2.length; i++) 
            hs.add(arr2[i]);
        System.out.println(hs);        
    }
     
    // Prints intersection of arr1[0..m-1] and arr2[0..n-1]
    static void printIntersection(int arr1[], int arr2[])
    {
        HashSet<Integer> hs = new HashSet<>();
         
        for (int i = 0; i < arr1.length; i++) 
            hs.add(arr1[i]);
        boolean found = false; 
        for (int i = 0; i < arr2.length; i++) 
            if (hs.contains(arr2[i]))
            {
               System.out.print(arr2[i] + " ");
               if (!found)
            	   found = true;
            }
        if (!found)
        	System.out.print("Zero");
    }
     
    // Driver method to test the above function
    public static void main(String[] args) 
    {
    	Scanner sc = new Scanner(System.in);
    	int t = sc.nextInt(); sc.nextLine();
    	while (t>0)
    	{    	
	    	String[] sizes = sc.nextLine().split(" ");
	    	
	    	int[] arr1 = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
	    	int[] arr2 = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
	    	
	        System.out.println("Union of two arrays is : ");
	        printUnion(arr1, arr2);
	         
	        System.out.println("Intersection of two arrays is : ");
	        printIntersection(arr1, arr2);  
	        
	        System.out.println();
	        t--;
    	}
        
        sc.close();
    }
	
}
