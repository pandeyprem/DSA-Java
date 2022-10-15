class Node
{
    int data;
    Node next;
    Node prev;
    Node(int x)
    {
        data=x;
        next=null;
        prev=null;
    }
}
class dll
{
    public static Node insert_at_begin(Node head,int data)
    {
        Node temp=new Node(data);
        temp.next=head;
        
        if(head!=null)
        head.prev=temp;
        return temp;
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
        head=dll.insert_at_begin(head, 2);
        head=dll.insert_at_begin(head, 1);
        dll.display(head);
    }
}