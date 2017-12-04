package com.bernie.gfg;

import java.util.Scanner;

public class CountPairsInArray {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();  // total number of test cases
		for (int t=0; t<testCase; t++) 
		{
			int arraySize = sc.nextInt();  // the size of the array for current test case
			int arr[] = new int[arraySize];
			for (int i=0; i<arraySize; i++)
			{
				int element = sc.nextInt();
				arr[i] = element*i;
			}
			
			int invert_count = inversionCount(arr, arraySize);
			System.out.println(invert_count);
		}
		sc.close();
		
	}

	private static int inversionCount(int[] arr, int arraySize) {
		int count = 0;
		for (int i=0; i<arraySize; i++)
		{
			int current=arr[i];
			for (int j=i+1; j<arraySize; j++)
			{
				if (current>arr[j])
					count++;
			}
		}
		return count;
	}
}
