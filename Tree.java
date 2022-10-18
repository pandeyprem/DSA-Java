package com.tutorialspoint.datastructure;

public class Tree {
   private Node root;

   public Tree(){
      root = null;
   }
   
   public Node search(int data){
      Node current = root;
      System.out.print("Visiting elements: ");
      while(current.data != data){
         if(current != null)
            System.out.print(current.data + " "); 
            //go to left tree
            if(current.data > data){
               current = current.leftChild;
            }//else go to right tree
            else{                
               current = current.rightChild;
            }
            //not found
            if(current == null){
               return null;
            }
         }
      return current;
   }

   public void insert(int data){
      Node tempNode = new Node();
      tempNode.data = data;

      //if tree is empty
      if(root == null){
         root = tempNode;
     }else{
         Node current = root;
         Node parent = null;

         while(true){                
            parent = current;
            //go to left of the tree
            if(data < parent.data){
               current = current.leftChild;                
               //insert to the left
               if(current == null){
                  parent.leftChild = tempNode;
                  return;
               }
            }//go to right of the tree
            else{
               current = current.rightChild;
               //insert to the right
               if(current == null){
                  parent.rightChild = tempNode;
                  return;
               }
            }
         }            
      }
   }    

   public void traverse(int traversalType){
      switch(traversalType){
         case 1:
            System.out.print("\nPreorder traversal: ");
            preOrder(root);
            break;
         case 2:
            System.out.print("\nInorder traversal: ");
            inOrder(root);
            break;
         case 3:
            System.out.print("\nPostorder traversal: ");
            postOrder(root);
            break;
         }            
   }   

   private void preOrder(Node root){
      if(root!=null){
         System.out.print(root.data + " ");
         preOrder(root.leftChild);
         preOrder(root.rightChild);
      }
   }

   private void inOrder(Node root){
      if(root!=null){
         inOrder(root.leftChild);
         System.out.print(root.data + " ");            
         inOrder(root.rightChild);
      }
   }

   private void postOrder(Node root){
      if(root!=null){            
         postOrder(root.leftChild);
         postOrder(root.rightChild);
         System.out.print(root.data + " ");
      }
   }
}
