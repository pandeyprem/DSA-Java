class Node
{
    Node next;
    Node prev;
    int data;
    Node(int x)
    {
        data=x;
        next=null;
        prev=null;
    }
    
}
public class dll_insert_at_end 
{
    public static Node insert_at_end(Node head,int data)
    {
        Node temp = new Node(data);
        if(head==null)
        return temp;
        Node curr=head;
        while(curr.next!=null)
        {
            curr=curr.next;
        }
        curr.next=temp;
        temp.prev=curr;
        return head;
    }   
    public static void display(Node head)
    {
        System.out.println("linked list values are : ");
        while(head.next!=null)
        {
            System.out.print(head.data+"->");
            head=head.next;
        }
        System.out.println(head.data);
    }
    public static void main(String[] args) 
    {  
      
        Node head=new Node(3);
        head=dll_insert_at_end.insert_at_end(head, 2);
        head=dll_insert_at_end.insert_at_end(head, 1);
        dll_insert_at_end.display(head);
    } 
}
