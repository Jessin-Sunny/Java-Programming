
import java.util.Random;

class FlagVariable {
    public static int num;
    public static boolean numgen = false;
}

class Square extends Thread {
    int n, sqr;

    Square(int n) {
        this.n = n;
    }

    public void run() {
        sqr = n * n;
        System.out.println("Square of " + n + " = " + sqr);
    }
}

class Cube extends Thread {
    int n, cube;

    Cube(int n) {
        this.n = n;
    }

    public void run() {
        cube = n * n * n;
        System.out.println("Cube of " + n + " = " + cube);
    }
}

class NumberGenerator extends Thread {
    Random randnum = new Random();

    public void run() {
        while (true) {
            FlagVariable.num = randnum.nextInt(100);
            System.out.println("Number Generated : " + FlagVariable.num);
            FlagVariable.numgen = true;

            try {
                Thread.sleep(1000); // suspends thread for 1s
            } catch (InterruptedException ex) {
                System.out.println("Exception : " + ex);
            }
        }
    }
}

public class Pgm11n {
    public static void main(String args[]) {
        try {
            NumberGenerator n = new NumberGenerator();
            n.start();

            while (true) {
                if (FlagVariable.numgen) {
                    if (FlagVariable.num % 2 == 0) {
                        Square s = new Square(FlagVariable.num);
                        s.start();
                    } else {
                        Cube c = new Cube(FlagVariable.num);
                        c.start();
                    }

                    FlagVariable.numgen = false;
                }
            }
        } catch (NoSuchMethodError e) {
            System.err.println("Error: NoSuchMethodError - Ensure that you have compiled all your classes.");
            e.printStackTrace();
        }
    }
}
