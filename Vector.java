// Java Program to Demonstrate Working of Vector 
// Via Creating and Using It 
// Importing required classes 
import java.io.*; 
import java.util.*; 
class GFG { 

	// Main driver method 
	public static void main(String[] args) 
	{ 
		// Size of the Vector 
		int n = 5; 

		// Declaring the Vector with 
		// initial size n 
		Vector<Integer> v = new Vector<Integer>(n); 

		// Appending new elements at 
		// the end of the vector 
		for (int i = 1; i <= n; i++) 
			v.add(i); 

		// Printing elements 
		System.out.println(v); 

		// Remove element at index 3 
		v.remove(3); 

		// Displaying the vector 
		// after deletion 
		System.out.println(v); 

		// iterating over vector elements 
		// using for loop 
		for (int i = 0; i < v.size(); i++) 

			// Printing elements one by one 
			System.out.print(v.get(i) + " "); 
	} 
}
