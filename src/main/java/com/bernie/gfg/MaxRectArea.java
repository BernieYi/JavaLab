package com.bernie.gfg;

import java.util.Scanner;
import java.util.stream.Stream;

public class MaxRectArea {
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while (t>0)
		{
			int size = sc.nextInt();			
			sc.nextLine();
			int[] arr = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();			
			System.out.println(maxArea(arr, size));			
			t--;
		}
		
		sc.close();
	}
	
	private static int maxArea(int[] arr, int size)
	{
		int maxArea = -1;
		
		for (int i=0; i<size; i++)
		{
			int length = 1;
			int hight = arr[i];
			boolean leftEnded = false;
			boolean rightEnded = false;
			
			for (int j=1; j<size; j++)
			{
				if (!leftEnded && i-j>=0 && arr[i-j]>=arr[i])
					length++;
				else
					leftEnded = true;
				
				if (!rightEnded && i+j<size && arr[i+j]>=arr[i])
					length++;
				else
					rightEnded = true;
				
				if (leftEnded & rightEnded)
					break;
			}
			
			int area = length * hight;
			if (area > maxArea) maxArea = area;	
		}
		
		return maxArea;
	}
	
}
