package org.testing.assertions;

public class Assertions {
	
	
	public static Boolean assert1(int actual , int expected )
	{
		if (actual==expected)
		{
			System.out.println("Status code is matching ");
			return true;
			
		}
		
		else 
		{
			System.out.println("Status code is not matching ");
			return false;
			
		}
			
	}

	
	public static Boolean assert2(String actual , String expected )
	{
		if (actual==expected)
		{
			System.out.println("Data is matching ");
			return true;
			
		}
		
		else 
		{
			System.out.println("Data is not matching ");
			return false;
			
		}
			
	}
	
}
