package com.bernie.gfg;

import java.util.Scanner;
import java.util.stream.Stream;

public class Rotate2DArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t>0)
		{
			int size = sc.nextInt();
			sc.nextLine();
			int[][] data = new int[size][size];
			int[] source = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for(int j = 0; j < size; j++)
			{  
			   for(int i = 0; i < size; i++)
			   {
				   data[j][i] = source[j*size + i];
			   }
			}		
			
			for (int i=0; i<size; i++)
				for (int j=size-1; j>=0; j--)
				{
					System.out.print(data[j][i] + " ");
				}
			System.out.println();
			t--;
		}

	}

}
