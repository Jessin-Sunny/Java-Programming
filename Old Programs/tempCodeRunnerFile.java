class Callme {
    void call(String msg) {
    System.out.print("[" + msg);
    try {
    Thread.sleep(1000);
    } catch(InterruptedException e) {
    System.out.println("Interrupted");
    }
    System.out.println("]");
    }
}

class Caller implements Runnable {
    String msg;
    Callme target;
    Thread t;

    public Caller(Callme targ, String s) {
        target = targ;
        msg = s;
    }

    public void run() {
        target.call(msg);
    }
}

class Synch {
    public static void main(String args[]) {
        Callme target = new Callme();
        Thread ob1=new Thread(new Caller(target, "Hello"));
        Thread ob2 = new Thread(new Caller(target, "Synchronized"));
        Thread ob3 = new Thread(new Caller(target, "World"));
        ob1.start();
        ob2.start();
        ob3.start();
        // wait for threads to end
        try {
            ob1.join();
            ob2.join();
            ob3.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}