
import java.util.Scanner;

class Node {
    public int data;
    public Node prev;
    public Node next;

    public Node() {
        prev = null;
        next = null;
    }

    public Node(int data) {
        this.data = data;
        prev = null;
        next = null;
    }
}

class DoubleLL {
    Node temp = new Node();
    Node head = new Node();
    Node ptr = new Node();

    public void insert(int element) {
        Node newnode = new Node(element);
        if (head.next == null) {
            head.next = newnode;
            temp = head;
        } else {
            newnode.data = element;
            newnode.prev = temp;
            temp = newnode;
        }
    }

    public void delete(int element) {
        ptr = head;
        while (ptr.next != null) {
            temp = ptr;
            ptr = ptr.next;
            if (ptr.data == element) {
                temp.next = ptr.next;
                break;
            }
        }
    }

    public void display() {
        System.out.print("Elements are: ");
        ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
            System.out.print(ptr.data + " ");
        }
    }
}

public class Pgmn18nn {
    public static void main(String args[]) {
        DoubleLL obj = new DoubleLL();
        int num, element;
        Scanner reader = new Scanner(System.in);
        num = reader.nextInt();
        System.out.print("Enter the elements: ");
        for (int i = 0; i < num; i++) {
            element = reader.nextInt();
            obj.insert(element);
        }
        obj.display();
    }
}
