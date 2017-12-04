package com.bernie.gfg;

import java.util.Scanner;

public class RearrangeAnArray {		
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int t=0; t<testCases; t++) {
			int arrSize = sc.nextInt();
			int[] arrOriginal = new int[arrSize];
			for (int j=0; j<arrSize; j++)
			{
				int element = sc.nextInt();
				arrOriginal[j] = element;
			}
			int[] output = new int[arrSize];
			for(int k=0; k<arrSize; k++)
			{
				output[k] = arrOriginal[arrOriginal[k]];
			}
			for (int i=0; i<arrSize; i++) {
				System.out.print(Integer.toString(output[i]) + ' ');
			}
			System.out.println();
		}
		
		sc.close();
	}
}
