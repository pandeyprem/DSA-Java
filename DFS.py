import java.lang.*;
import java.io.*;
import java.util.*;
 
// Main class
public class Main {
 
    public static int V;
    // Adjacency List Representation
    public static LinkedList<Integer> adj[];
 
    // Constructor
    @SuppressWarnings("unchecked") Main(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }
 
    // Method 1
    // To add an edge into the graph
    static void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's list.
    }
 
    // Method 2
    // DFS function
    static void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
 
    // Method 3
    // To Partition the tree as it calls DFS
    // for parent, Right and Left trees.
    static void Partition(int v) {
 
        Iterator<Integer> i = adj[v].listIterator();
        int k = 1;
        boolean visited[] = new boolean[V];
        // Flag variable
        visited[v] = true;
 
        // The current element is separated from partition
        while (i.hasNext()) {
 
            // DFS for all the partitions like parent ,left and right.
            System.out.println();
            System.out.println(k + "Tree");
 
            ++k;
 
            int n = i.next();
            DFSUtil(n, visited);
        }
    }
 
    // Method 4
    // main driver method
    public static void main(String args[]) {
 
        // Creating an object of class
        // in main() method
        Main g = new Main(10);
 
        // Sample illustration of a tree
        // as how it will look like
 
        /*  0
           /  \
          1    2 -> Target Node.
         / \  / \
        3  4 5   6
 
            / \   \
           7   8   9
        */
 
        // Adding edges passing arguments
        // as per above generated tree
        g.addEdge(0, 1); g.addEdge(1, 0);
        g.addEdge(0, 2); g.addEdge(2, 0);
        g.addEdge(1, 3); g.addEdge(3, 1);
        g.addEdge(1, 4); g.addEdge(4, 1);
        g.addEdge(2, 5); g.addEdge(5, 2);
        g.addEdge(2, 6); g.addEdge(6, 2);
        g.addEdge(5, 7); g.addEdge(7, 5);
        g.addEdge(5, 8); g.addEdge(8, 5);
        g.addEdge(6, 9); g.addEdge(9, 6);
 
        // Calling the Method3 to
        // partition the tree
        Partition(2);
    }
}
