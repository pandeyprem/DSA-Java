
#include<stdio.h>
#include<stdlib.h>
 struct tree
 {
     int data;
     struct tree *left,*right;
 }*root=NULL,*newnode,*ptr,*pre;
 
 void insert()
 {
         newnode=(struct tree *)malloc(sizeof(struct tree ));
        printf("Enter Element");
        scanf("%d",&newnode->data);
       if(root==NULL)
     {
         root=newnode;
         root->left=NULL;
         root->right=NULL;
        
     }
     else
     {
         ptr=root;
         while(ptr!=NULL)
         {
             pre=ptr;
             if(ptr->data > newnode->data)
             {
                 ptr=ptr->left;
             }
             else
             {
                 ptr=ptr->right;
             }
         }
         if(newnode->data>pre->data)
         {
             pre->right=newnode;
         }
         else
         {
             pre->left=newnode;
             newnode->right=NULL;
             newnode->left=NULL;
         }
     }
 }
 
 void preorder(struct tree *root)
 {
     if(root!=NULL)
     {
         printf("%d ->",root->data);
         preorder(root->left);
         preorder(root->right);
     }
 }
 
void inorder(struct tree *root)
 {
     if(root!=NULL)
     {
         inorder(root->left);
         printf("%d ->",root->data);
         inorder(root->right);
     }
 }
 
 void postorder(struct tree *root)
 {
     if(root!=NULL)
     {
         postorder(root->left);
         postorder(root->right);
         printf("%d ->",root->data);
     }
 }
 
 void findmin()
 {
     ptr=root;
     while(ptr->left!=NULL)
     {
         ptr=ptr->left;
     }
     printf("%d",ptr->data);
 }
 
 void findmax()
 {
     ptr=root;
     while(ptr->right!=NULL)
     {
         ptr=ptr->right;
     }
     printf("%d",ptr->data);
 }
 
 void search()
 {
     int data,c=0;
     scanf("%d",&data);
     ptr=root;
 
     while(ptr!=NULL)
     {
         if(data==ptr->data)
         {
             c++;
             break;
         }
         else if(data>ptr->data)
         {
             ptr=ptr->right;
         }
         else
         {
             ptr=ptr->left;
         }
     }
     if(c==0)
     {
         printf("Element not found");
     }
     else{
         printf("Found");
     }
 }


struct tree *minValuetree(struct tree *tree)
{
  struct tree *current = tree;

  while (current && current->left != NULL)
    current = current->left;

  return current;
}

struct tree *deletetree(struct tree *root1, int data)
{

  if (root1 == NULL)
    return root1;

  if (data < root1->data)
    root1->left = deletetree(root1->left, data);
  else if (data > root1->data)
    root1->right = deletetree(root1->right, data);

  else
  {

    if (root1->left == NULL)
    {
      struct tree *temp = root1->right;
      free(root1);
      return temp;
    }
    else if (root1->right == NULL)
    {
      struct tree *temp = root1->left; 
      free(root1);
      return temp;
    }

    struct tree *temp = minValuetree(root1->right);

    root1->data = temp->data;

    root1->right = deletetree(root1->right, temp->data);
  }
  return root1;
}





struct tree *inOrderPredecessor(struct tree* root){
    root = root->left;
    while (root->right!=NULL)
    {
        root = root->right;
    }
    return root;
}

struct tree *deleteNode(struct tree *root, int value){

    struct tree* iPre;
    if (root == NULL){
        return NULL;
    }
    if (root->left==NULL&&root->right==NULL){
        free(root);
        return NULL;
    }

    //searching for the tree to be deleted
    if (value < root->data){
        root-> left = deleteNode(root->left,value);
    }
    else if (value > root->data){
        root-> right = deleteNode(root->right,value);
    }
    //deletion strategy when the tree is found
    else{
        iPre = inOrderPredecessor(root);
        root->data = iPre->data;
        root->left = deleteNode(root->left, iPre->data);
    }
    return root;
}
 




 
 int main()
 {
     int c;
     do{
         printf("\nEnter\n1.Insert\n2.Inorder\n3.PreOrder\n4.PostOrder\n5.Search\n6.Delete\n7.Delete2\n8.Exit\n");
         scanf("%d",&c);
         switch(c)
         {
             case 1:
             {
                 insert();
                 break;
             }
             case 2:
             {
                 inorder(root);
                 break;
             }
             case 3:
             {
                 preorder(root);
                 break;
             }
             case 4:
             {
                 postorder(root);
                 break;
             }

             case 5:
             {
                 search();
                 break;
             }
             case 6:
             {
                 int del;
                 printf("Enter the node to be deleted : ");
                 scanf("%d",&del);
                 root=deletetree(root,del);
                 break;
             }

             case 7:
             {
                 int del;
                 printf("Enter the node to be deleted : ");
                 scanf("%d",&del);
                 root=deleteNode(root,del);
                 break;

             }

             case 8:
             {
                exit(0);
             }
             
         }
     }while(1);
  

 }