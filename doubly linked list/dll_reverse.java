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
public class dll_reverse
{
    public static Node reverse(Node head)
    {
        if(head==null||head.next==null)
        return head;
        Node curr=head;
        Node temp=null;
        while(curr!=null)
        {
            temp=curr.prev;
            curr.prev=curr.next;
            curr.next=temp;
            curr=curr.prev;
        }
        return temp.prev;
    }
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
        head=dll_reverse.insert_at_end(head, 2);
        head=dll_reverse.insert_at_end(head, 1);
        dll_reverse.display(head);
        head=dll_reverse.reverse(head);
        dll_reverse.display(head);
    } 
}
