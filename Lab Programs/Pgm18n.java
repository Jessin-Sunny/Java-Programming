import java.util.Scanner;
class Node
{
    public int data;
    public Node prev=null;
    public Node next=null;
    public Node()
    {

    }
    public Node(int data)
    {
        this.data=data;
        prev=null;
        next=null;
    } 
}

class DoubleLL
{
    protected int data,num;
    Node head=new Node();
    Node ptr=new Node();
    public DoubleLL()
    {

    }
    protected void insert(int element)
    {
        Node newnode=new Node(element);
        Node temp=new Node();
        if(head.next==null)
        {
            head.next=newnode;
            temp=head;
        }
        else
        {
            newnode.data=data;
            newnode.prev=temp;
            temp=newnode;
        }
    }
    protected void delete(int element)
    {
        Node temp=new Node();
        ptr=head;
        while(ptr.next!=null)
        {
            temp=ptr;
            ptr=ptr.next;
            if(ptr.data==element)
            {   
                if(ptr.next!=null)
                {
                    temp.next=ptr.next;
                    break;
                }
            }
        }
    }
    protected void display()
    {
        Node ptr=new Node();
        System.out.print("Element are : ");
        ptr=head;
        while(ptr.next!=null)
        {
            ptr=ptr.next;
            System.out.print(ptr.data);
        }

    }
}

public class Pgm18n
{
    public static void main(String args[])
    {
        DoubleLL obj=new DoubleLL();
        int num,element;
        Scanner reader = new Scanner(System.in);
        System.out.print("How many elements ? : ");
        num=reader.nextInt();
        System.out.print("Enter the elements : ");
        for(int i=0;i<num;i++)
        {
            element=reader.nextInt();
            obj.insert(element);
        }
        obj.display();

    }
}


