package com.bernie.gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class WordBoggle {

	WordBoggle()
	{		
	}
	
	int[] dimension;
	
	String[][] boggle;
	
	class Point
	{
		int x;
		int y;
		
		Point(){
			
		}
		
		Point(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		
		@Override
	    public boolean equals(Object other) 
	    {
	        if (this == other)
	          return true;

	        if (!(other instanceof Point))
	          return false;

	        Point otherPoint = (Point) other;
	        return otherPoint.x == x && otherPoint.y == y;
	    }


	    @Override
	    public int hashCode()
	    {
	        return (Integer.toString(x) + "," + Integer.toString(y)).hashCode();
	    }

	}
		
	public static void main(String[] args) {
		
		WordBoggle wb = new WordBoggle();
		Scanner sc = new Scanner(System.in);
		int t  = sc.nextInt();
		while (t>0)
		{
			sc.nextInt();
			sc.nextLine();
			HashSet<String> dic = new HashSet<String>(Arrays.asList(sc.nextLine().split(" ")));
			wb.dimension = Stream.of(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			wb.boggle = wb.getBoggle(wb.dimension, sc.nextLine().split(" "));
			wb.boggling(dic, wb.boggle, wb.dimension);
			if (dic.isEmpty())
				System.out.println("-1");
			else
			{
				dic.stream().sorted().forEach(d -> System.out.print(d + " "));
				System.out.println();
			}
			t--;
		}
		
		sc.close();
	}
	
	String[][] getBoggle(int[] dimension, String[] source)
	{
		int rowSize = dimension[0];
		int columnSize = dimension[1];
		String[][] boggle = new String[rowSize][columnSize];
		for(int j = 0; j < rowSize; j++)
		{  
		   for(int i = 0; i < columnSize; i++)
		   {
			   boggle[j][i] = source[j*columnSize + i];
		   }
		}		
		return boggle;
	}
	
	void boggling(HashSet<String> dic, String[][] boggle, int[] dimension)
	{
		// Get the first characters of each word from dictionary
		Map<String, String> starters = new HashMap<String, String>();
		dic.stream().forEach(d -> starters.put(d, d.substring(0, 1)));
		
		HashMap<String, List<Point>> meta = measure(boggle);
		for (String word: starters.keySet())
		{
			String key = starters.get(word);
			if (meta.containsKey(key))
			{	
				List<Point> points = meta.get(key);		
				boolean found = false;
				for (Point startPoint:points)
				{
					HashSet<Point> usedPoints = new HashSet<Point>();
					if (backtracking(startPoint, 0, word, usedPoints))
					{
						found = true;
						break;
					}
				}
				if (!found)
					dic.remove(word);
			}
			else
			{				
				dic.remove(word);
			}
		}
		
	}

	
	boolean backtracking(Point currentPoint, int currentIndex, String word, HashSet<Point> usedPoints)
	{	
		currentIndex++;
		List<Point> destinations = findNeighbours(currentPoint, dimension, usedPoints);
		boolean isFound= false;
		if (word.length()==currentIndex)
		{
			if (boggle[currentPoint.x][currentPoint.y].equals(word.substring(currentIndex-1, currentIndex)))
			{
				isFound = true;
				return true;
			} else 
			{
				return false;
			}
		}
		String nextKey = word.substring(currentIndex, currentIndex+1);
		for (Point d:destinations)
		{			
			if (boggle[d.x][d.y].equals(nextKey))
			{
				if (word.length()==currentIndex+1)
				{
					isFound = true;
					return true;
				}
				else
				{
					// update current position & previous point
					usedPoints.add(currentPoint);
					Point nextPoint = new Point(d.x, d.y);		
					isFound=backtracking(nextPoint, currentIndex, word, usedPoints);	
					if(!isFound)
						continue;
					else
						return true;
				}
			}
		}
		return isFound;

	}

	HashMap<String, List<Point>> measure(String[][] boggle)
	{
		HashMap<String, List<Point>> boggleMeta = new HashMap<String, List<Point>>();
		for (int i=0; i<boggle.length; i++ )
			for (int j=0; j<boggle[i].length; j++)
			{
				if (boggleMeta.containsKey(boggle[i][j]))
				{
					boggleMeta.get(boggle[i][j]).add(new Point(i,j));
				} else 
				{
					List<Point> locations = new ArrayList<Point>();
					locations.add(new Point(i, j));
					boggleMeta.put(boggle[i][j], locations);
				}
			}
		return boggleMeta;
	}
	
	void findNextKey(Map<String, String> starters, int currentIndex)
	{
		for (String word: starters.keySet()) 
		{
			String newKey = null;
			if (currentIndex <= word.length())
			{
				newKey = word.substring(currentIndex-1, currentIndex);
				starters.put(word, newKey);
			} else
				starters.put(word, null);
		}
	}
	
	List<Point> findNeighbours(Point current, int[] dimension, HashSet<Point> usedPoints)
	{
		List<Point> destinations = new ArrayList<Point>();
		int MIN_X = 0;
		int MIN_Y = 0;
		int MAX_X = dimension[0]-1; 
		int MAX_Y = dimension[1]-1;
		int thisPosX = current.x;
		int thisPosY  = current.y;
		
		int startPosX = (thisPosX - 1 < MIN_X) ? thisPosX : thisPosX-1;
		int startPosY = (thisPosY - 1 < MIN_Y) ? thisPosY : thisPosY-1;
		int endPosX =   (thisPosX + 1 > MAX_X) ? thisPosX : thisPosX+1;
		int endPosY =   (thisPosY + 1 > MAX_Y) ? thisPosY : thisPosY+1;

		// See how many are alive
		for (int rowNum=startPosX; rowNum<=endPosX; rowNum++) {
		    for (int colNum=startPosY; colNum<=endPosY; colNum++) 
		    {
		        if (thisPosX!=rowNum || thisPosY!=colNum)  // do not add the same location as its own neighbours
		        {
		        	Point des = new Point(rowNum, colNum);
		        	if (!usedPoints.contains(des)) // do not all the previous point
				    	// All the neighbors will be grid[rowNum][colNum]
				    	destinations.add(des);
		        }
		    }
		}		
		
		return destinations;
	}


}
