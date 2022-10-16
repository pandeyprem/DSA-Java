// Java program to take an integer 
// as input and print it 

import java.io.*; 
import java.util.Scanner; 

class GFG { 
	public static void main(String[] args) 
	{ 

		// Declare the variables 
		int num; 

		// Input the integer 
		System.out.println("Enter the integer: "); 

		// Create Scanner object 
		Scanner s = new Scanner(System.in); 

		// Read the next integer from the screen 
		num = s.nextInt(); 

		// Display the integer 
		System.out.println("Entered integer is: "
						+ num); 
	} 
} 
