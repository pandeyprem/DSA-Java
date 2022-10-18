
import java.util.*;
import java.lang.*;
import java.io.*;

class TrieNode {
    public TrieNode[] children;
    public int wordCount;
    public boolean isEndOfWord;
 
    public TrieNode()
    {
        children = new TrieNode[26];
        // This will keep track of number of strings that
        // are stored in the Trie from root node to any Trie
        // node.
        wordCount = 0;
        isEndOfWord = false;
    }
  
    void insert(TrieNode root, String key)
    {
        // Initialize the currentNode pointer with the root node
        TrieNode currentNode = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';

            // Check if the node exist for the current
            // character in the Trie.
            if (currentNode.children[index] == null) {

                // Keep the reference for the newly created
                // node.
                currentNode.children[index] = new TrieNode();
            }

            // Now, move the current node pointer to the newly
            // created node.
            currentNode = currentNode.children[index];
        }

        // Increment the wordEndCount for the last currentNode
        // pointer this implies that there is a string ending at
        // currentNode.
        currentNode.wordCount++;
        currentNode.isEndOfWord = true;
    }
  
    boolean isPrefixExist(TrieNode root, String key)
    {
        // Initialize the currentNode pointer
        // with the root node
        TrieNode currentNode = root;

        // Iterate across the length of the string
        for (int i = 0 ; i < key.length(); i++)
        {
            int index = key.charAt(i) - 'a';
            // Check if the node exist for the current
            // character in the Trie.
            if (currentNode.children[index] == null) {

                // Given word as a prefix does not exist in Trie
                return false;
            }

            // Move the currentNode pointer to the already
            // existing node for current character.
            currentNode = currentNode.children[index];
        }

          // Prefix exist in the Trie
        return true;
    }
  
    // Returns true if key presents in trie, else false
    boolean search(TrieNode root, String key)
    {
        // Initialize the currentNode
        // with the root node
        TrieNode currentNode = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';

            // Check if the node exist for the current
            // character in the Trie.
            if (currentNode.children[index] == null)
                return false;

            // Move the currentNode to the already
            // existing node for current character.
            currentNode = currentNode.children[index];
        }

        return (currentNode.isEndOfWord);
    }
  
    
    boolean delete(TrieNode root, String key)
    {
        TrieNode currentNode = root;
        TrieNode lastBranchNode = null;
        char lastBrachChar = 'a';

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (currentNode.children[index] == null) {
                return false;
            }
            else {
                int count = 0;
                for (int j = 0; j < 26; j++) {
                    if (currentNode.children[j] != null)
                        count++;
                }

                if (count > 1) {
                    lastBranchNode = currentNode;
                    lastBrachChar = key.charAt(i);;
                }
                currentNode = currentNode.children[i];
            }
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (currentNode.children[i] != null)
                count++;
        }

        // Case 1: The deleted word is a prefix of other words
        // in Trie.
        if (count > 0) {
            currentNode.wordCount--;
            return true;
        }

        // Case 2: The deleted word shares a common prefix with
        // other words in Trie.
        if (lastBranchNode != null) {
            lastBranchNode.children[lastBrachChar] = null;
            return true;
        }
        // Case 3: The deleted word does not share any common
        // prefix with other words in Trie.
        else {
            root.children[key.charAt(0) - 'a'] = null;
            return true;
        }
    }
}
class Main
{
	 public static void main(String args[]) {
       TrieNode root = new TrieNode();
 
        // Stores the strings that we want to insert in the
        // Trie
        String[]  inputStrings = { "and", "ant", "do", "get", "dad", "ball" };
     
        // number of insert operations in the Trie
        int n = inputStrings.length;
     
        for (int i = 0; i < n; i++) {
           root.insert(root, inputStrings[i]);
        }
        
        String[]  searchQueryStrings = { "do", "get", "bat" };
        
        int searchQueries = searchQueryStrings.length;
 
        for (int i = 0; i < searchQueries; i++) {
            System.out.println("Query String : " + searchQueryStrings[i]);
            if (root.search(root, searchQueryStrings[i])) {
                // the queryString is present in the Trie
                System.out.println("The query string is present in the Trie");
            }
            else {
                // the queryString is not present in the Trie
                System.out.println("The query string is not present in the Trie");
            }
        }
        
        String[] deleteQueryStrings = { "get", "tea" };
 
        // number of delete operations from the Trie
        int deleteQueries = deleteQueryStrings.length;
     
        for (int i = 0; i < deleteQueries; i++) {
            System.out.println("Query String : " + deleteQueryStrings[i]);
            if (root.delete(root, deleteQueryStrings[i])) {
                // The queryString is successfully deleted from
                // the Trie
                System.out.println("The query string is successfully deleted") ;
            }
            else {
                // The query string is not present in the Trie
                System.out.println("The query string is not present in the Trie");
            }
        }
     
    }
}
