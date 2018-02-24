package com.ctci.solutions;
/**
 * 1.1 Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
 * @author Sanket Patil
 *
 */
public class IsUnique {
	/**
	 * Method1: Using ASCII Map
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * @param inputString
	 * @return
	 */
	public static boolean isUnique(String inputString)
	{
		//Create ascii map of type boolean. Here index of map will be treated as ascii value
		boolean[] asciiMap = new boolean[128];
		for(int i=0; i< inputString.length(); i++)
		{
			char c = inputString.charAt(i);
			
			if(asciiMap[c])
			{
				return false;
			}
			
			asciiMap[c]=true;
		}
		return true;
	}
	

	public static void main(String args[])
	{
		String[] inputs= new String[] {"1bc", "ssss", "abc"};
		
		for(String input: inputs)
		{
			System.out.println(isUnique(input));
		}
	}

}
