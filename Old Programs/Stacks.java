interface DataStructure {
    void insert(int data);
    void delete(int data);
    void display();
}
class Stack implements DataStructure {
    private int[] stack;
    private int top;
    private int size;

    public Stack(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    public void insert(int data) {
        if (top == size - 1) {
            System.out.println("Stack overflow");
        } else {
            stack[++top] = data;
        }
    }

    public void delete(int data) {
        if (top == -1) {
            System.out.println("Stack underflow");
        } else {
            int deletedData = stack[top--];
            System.out.println("Deleted data: " + deletedData);
        }
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack elements are:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }
}

class Queue implements DataStructure {
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    public Queue(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    public void insert(int data) {
        if (rear == size - 1) {
            System.out.println("Queue overflow");
        } else {
            if (front == -1) {
                front = 0;
            }
            queue[++rear] = data;
        }
    }

    public void delete(int data) {
        if (front == -1 || front > rear) {
            System.out.println("Queue underflow");
        } else {
            int deletedData = queue[front++];
            System.out.println("Deleted data: " + deletedData);
        }
    }

    public void display() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Queue elements are:");
            for (int i = front; i <= rear; i++) {
                System.out.println(queue[i]);
            }
        }
    }
}
public class Stacks {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.insert(10);
        stack.insert(20);
        stack.insert(30);
        stack.display();
        stack.delete(30);
        stack.display();

        Queue queue = new Queue(5);
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.display();
        queue.delete(10);
        queue.display();
    }
}
