// JAVA program to connect nodes
// at same level using extended
// pre-order traversal
import java.util.*;
class GFG {

	static class node {

		int data;
		node left;
		node right;
		node nextRight;

		/*
		* Constructor that allocates a new node with the
		* given data and null left and right pointers.
		*/
		node(int data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
			this.nextRight = null;
		}
	};

	// Sets the nextRight of
	// root and calls connectRecur()
	// for other nodes
	static void connect(node p)
	{
		// Set the nextRight for root
		p.nextRight = null;

		// Set the next right for rest of the nodes
		// (other than root)
		connectRecur(p);
	}

	/*
	* Set next right of all descendants of p. Assumption: p
	* is a complete binary tree
	*/
	static void connectRecur(node p)
	{
		// Base case
		if (p == null)
			return;

		// Set the nextRight pointer for p's left child
		if (p.left != null)
			p.left.nextRight = p.right;

		// Set the nextRight pointer
		// for p's right child p.nextRight
		// will be null if p is the right
		// most child at its level
		if (p.right != null)
			p.right.nextRight = (p.nextRight) != null
									? p.nextRight.left
									: null;

		// Set nextRight for other
		// nodes in pre order fashion
		connectRecur(p.left);
		connectRecur(p.right);
	}

	/* Driver code */
	public static void main(String[] args)
	{

		/*
		* Constructed binary tree is 10 / \ 8 2 / 3
		*/
		node root = new node(10);
		root.left = new node(8);
		root.right = new node(2);
		root.left.left = new node(3);

		// Populates nextRight pointer in all nodes
		connect(root);

		// Let us check the values
		// of nextRight pointers
		System.out.print(
			"Following are populated nextRight pointers in the tree"
			+ " (-1 is printed if there is no nextRight)\n");
		System.out.print(
			"nextRight of " + root.data + " is "
			+ (root.nextRight != null ? root.nextRight.data
									: -1)
			+ "\n");
		System.out.print("nextRight of " + root.left.data
						+ " is "
						+ (root.left.nextRight != null
								? root.left.nextRight.data
								: -1)
						+ "\n");
		System.out.print("nextRight of " + root.right.data
						+ " is "
						+ (root.right.nextRight != null
								? root.right.nextRight.data
								: -1)
						+ "\n");
		System.out.print(
			"nextRight of " + root.left.left.data + " is "
			+ (root.left.left.nextRight != null
				? root.left.left.nextRight.data
				: -1)
			+ "\n");
	}
}

// This code is contributed by umadevi9616
