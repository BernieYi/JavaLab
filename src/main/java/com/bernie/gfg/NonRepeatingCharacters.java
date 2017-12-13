package com.bernie.gfg;

/**
 * Given a string s consisting of lowercase Latin Letters, find the first non repeating character in s.

	Input:
	
	The first line contains T denoting the number of testcases. Then follows description of testcases.
	Each case begins with a single integer N denoting the length of string. The next line contains the string s.
	 
	Output:	
	
	 For each testcase, print the first non repeating character present in string.
	 
	 Print -1 if there is no non repeating character.
	 
	Constraints:	
	
	 1<=T<=50
	 1<=N<=100	
	
	Example:	
	
	Input :
	
	3
	5  
	hello
	12
	zxvczbtxyzvy
	6
	xxyyzz	 
	
	Output :
	
	h
	c
	-1

 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class NonRepeatingCharacters {
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while (t>0)
		{
			int length = sc.nextInt();
			sc.nextLine();
			String input = sc.nextLine();
			ArrayList<Character> singles = new ArrayList<Character>();
			HashSet<Character> multiples = new HashSet<Character>();
			for (int i=0; i<length; i++)
			{
				Character current = input.charAt(i);
				if (multiples.contains(current))
					continue;
				else
				{
					if (singles.contains(current)) 
					{
						multiples.add(current);
						singles.remove(current);
					} else
					{
						singles.add(current);
					}
				}
			}
			System.out.println(singles.isEmpty()?-1:""+singles.get(0));
			t--;
		}
		sc.close();
	}

}
