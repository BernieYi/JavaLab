package com.bernie.gfg;

import java.util.Scanner;
import java.util.stream.Stream;

public class OnceAndTwice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t>0)
		{
			int size = sc.nextInt();
			sc.nextLine();
			int[] array = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
			int count = 1;
			if (size==1)
			{
				System.out.println(array[0]);
				t--;
				continue;
			}
				
			for (int i=1; i<size; i++)
			{
				if (array[i-1]==array[i]) 
					count--;
				else
					count++;
				
				if(count==2)
				{
					System.out.println(array[i-1]);
					break;
				} else if (count==1 && i==size-1)
				{
					System.out.println(array[i]);
					break;
				}
			}
			t--;
		}
		sc.close();

	}

}
