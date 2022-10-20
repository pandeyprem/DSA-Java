import java.util.Scanner;

public class NodesGreaterThanX {
	
	public static BinaryTreeNode<Integer> takeInput(boolean isRoot, int parentData, boolean isLeft){
		
		if(isRoot) {
			System.out.println("Enter Root Data: ");
		}
		else {
			if(isLeft) {
				System.out.println("Enter left Child of " + parentData);
			}
			else {
				System.out.println("Enter Right Child of " + parentData);
			}
		}
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		
		if(rootData == -1) {
			return null;
		}
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		BinaryTreeNode<Integer> leftChild = takeInput(false,rootData,true);
		BinaryTreeNode<Integer> rightChild = takeInput(false, rootData, false);
		
		root.left = leftChild;
		root.right = rightChild;
		
		return root;
	}
	
	public static int NodeGreaterThanX(BinaryTreeNode<Integer> root, int X) {
		if(root == null) {
			return 0;
		}
		int count = (root.data > X) ? 1 : 0; // Ternary Operator
//		int leftLargest = NodeGreaterThanX(root.left,count);
		if(root.left != null) {
			count += NodeGreaterThanX(root.left, X);
		}
		if(root.right != null) {
			count += NodeGreaterThanX(root.right, X);
		}
		return count;
	}
	
	public static int heightOfTree(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int leftHeight = heightOfTree(root.left);
		int rightHeight = heightOfTree(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
public static void printTreeDetailed(BinaryTreeNode<Integer> root) {
		
//		System.out.println("The Tree looks like: ");
		
		if(root == null) {
			return;
		}
		System.out.print(root.data + ":");
		if(root.left != null) {
			System.out.print("L" + root.left.data + ", ");
		}
		if(root.right != null) {
			System.out.print("R" + root.right.data);
		}
		System.out.println();
		printTreeDetailed(root.left);
		printTreeDetailed(root.right);
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput(true, 0, false);
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the value of X: ");
		int X = s.nextInt();
		printTreeDetailed(root);
		System.out.println(NodeGreaterThanX(root, X));
//		System.out.println("Height of Tree is: " + heightOfTree(root));
		

	}

}
