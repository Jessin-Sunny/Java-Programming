import java.util.Random;

class Data {
    public int num;
    public boolean status = false;
    public boolean squareOperation = true; // true for square, false for cube

    public synchronized void number(int num) {
        while (status) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Exception arises: " + ex);
            }
        }
        System.out.println("Number: " + num);
        this.num = num;
        status = true;
        notifyAll();
    }

    public synchronized void sdisplay(int num) {
        while (!status || !squareOperation || num % 2 != 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Exception arises: " + ex);
            }
        }
        System.out.println("Square: " + num * num);
        status = false;
        squareOperation = false; // Switch to cube operation
        notify();
    }

    public synchronized void cdisplay(int num) {
        while (!status || squareOperation || num % 2 == 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Exception arises: " + ex);
            }
        }
        System.out.println("Cube: " + num * num * num);
        status = false;
        squareOperation = true; // Switch to square operation
        notify();
    }
}

class NumGenerator implements Runnable {
    Data obj;
    int num;
    Random n = new Random();

    public NumGenerator(Data obj) {
        this.obj = obj;
    }

    public void run() {
        while (true) {
            num = n.nextInt(100);
            obj.number(num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Exception arises: " + ex);
            }
        }
    }
}

class Square implements Runnable {
    Data obj;

    public Square(Data obj) {
        this.obj = obj;
    }

    public void run() {
        while (true) {
            obj.sdisplay(obj.num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Exception arises: " + ex);
            }
        }
    }
}

class Cube implements Runnable {
    Data obj;

    public Cube(Data obj) {
        this.obj = obj;
    }

    public void run() {
        while (true) {
            obj.cdisplay(obj.num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Exception arises: " + ex);
            }
        }
    }
}

public class Test {
    public static void main(String args[]) {
        Data obj = new Data();

        NumGenerator num = new NumGenerator(obj);
        Square sq = new Square(obj);
        Cube cu = new Cube(obj);

        Thread t1 = new Thread(num, "RandomNumber");
        Thread t2 = new Thread(sq, "Square");
        Thread t3 = new Thread(cu, "Cube");

        t1.start();
        t2.start();
        t3.start();
    }
}

