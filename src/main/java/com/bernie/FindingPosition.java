package com.bernie.gfg;

import java.util.Scanner;

public class FindingPosition {
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while (testCases > 0)
		{
			//findEven(IntStream.range(1, sc.nextInt()+1).boxed().toArray( Integer[]::new ));
			//findEvenByLog(sc.nextInt());
			int n = sc.nextInt();
		    int k = 1;
			while(n>=k){
		        k = k*2;
		    }
		    System.out.println(k/2);
		    
			testCases--;
		}
		
		sc.close();
	}
	
	/*
	 * Using this function will cause "OutOfMemry" error or "TimeOutException" 
	 * 
	 */
//	private static void findEven(Integer[] source)
//	{	
//		Integer[] result = Arrays.stream(source).filter(s -> (Arrays.asList(source).indexOf(s) % 2 == 1)).toArray(Integer[]::new);
//		
//		if (result.length==1)
//			System.out.println(result[0]);
//		else if (result.length>0)
//			findEven(result);
//		else
//			return;
//	}
	
	private static void findEvenByLog(int max)
	{
		int i=log(max, 2);
		System.out.println(1 << i);
	}
	
	private static int log(int x, int base)
	{
	    return (int) (Math.log(x) / Math.log(base));
	}
										 
}
