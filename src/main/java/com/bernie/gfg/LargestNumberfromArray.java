package com.bernie.gfg;


/*
 * Given a list of non negative integers, arrange them in such a manner that they form the largest number possible.
	
	The result is going to be very large, hence return the result in the form of a string.
	
	Input:
	
	The first line of input consists number of the test cases. The description of T test cases is as follows:
	
	The first line of each test case contains the size of the array, and the second line has the elements of the array.
	
	
	Output:
	
	In each separate line print the largest number formed by arranging the elements of the array in the form of a string.
	
	
	Constraints:
	
	1 <= T <= 70
	1 <= N <= 100
	0 <= A[i] <= 1000
	
	
	Example:
	
	Input:
	
	2
	5
	3 30 34 5 9
	4
	54 546 548 60
	
	Output:
	
	9534330
	6054854654
 */



import java.util.PriorityQueue;
import java.util.Scanner;

class Element implements Comparable<Element>
{
    int value;
    Element(int value)
    {
        this.value = value;
    }
    
    public int compareTo(Element e2)
    {
        String str1 = String.valueOf(this.value);
        String str2 = String.valueOf(e2.value);
        String str1str2 = str1+str2;
        String str2str1 = str2+str1;
        return Integer.valueOf(str2str1)-Integer.valueOf(str1str2);
    }
}

public class LargestNumberfromArray 
{
	public static void main (String[] args) 
	{
		Scanner scnr = new Scanner(System.in);
	    int testCases = scnr.nextInt();
	    while(testCases-->0)
	    {
	        int testLen = scnr.nextInt();
	        // An unbounded priority queue based on a priority heap
	        // The elements of the priority queue are ordered according to their natural ordering, or by a Comparator provided at queue construction time
	        PriorityQueue<Element> pq = new PriorityQueue<Element>(); 
	        for(int i=0;i<testLen;i++)
	        {
	            pq.add(new Element(scnr.nextInt()));  // The Add method only verify the head of the heap.  Not all elements of the queue is sorted.
	        }
	        for(int i=0;i<testLen;i++)
	        {
	            System.out.print(pq.remove().value);  // the poll() / remove() method will sort the queue to get the right head.  
	        }
	        System.out.println();
	    }		
		
		scnr.close();
	}
}
