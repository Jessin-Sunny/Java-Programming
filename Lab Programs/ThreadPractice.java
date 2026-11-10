/*Program to generate a random number and print its square if it is even and cube if it is odd*/

import java.util.*;

class Printer
{
    int num;
    boolean numstatus=false;
    boolean estatus=false;
    synchronized void numgenerator(int n)
    {
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
            System.out.println("Exception : "+ex);
        }
        while(numstatus==true)
        {
            try
            {
                wait();
            }
            catch(InterruptedException ex)
            {
                System.out.println("Exception : "+ex);
            }
        }
        num=n;
        System.out.println("Number : "+num);
        numstatus=true;
        notifyAll();
    }
    synchronized void square()
    {
        while(numstatus==false)
        {
            try
            {
                wait();
            }
            catch(InterruptedException ex)
            {
                System.out.println("Exception : "+ex);
            }
        }
        if(num%2==0)
        {
            numstatus=false;
            System.out.println("Square : "+num*num);
            notifyAll();
        }
    }
    synchronized void cube()
    {
        while(numstatus==false)
        {
            try
            {
                wait();
            }
            catch(InterruptedException ex)
            {
                System.out.println("Exception : "+ex);
            }
        }
        if(num%2!=0)
        {
            System.out.println("Cube : "+num*num*num);
            numstatus=false;
            notifyAll();
        }
    }
}

class RandomNumber implements Runnable
{
    Printer obj;
    Thread t;
    int num;
    Random rm=new Random();
    RandomNumber(Printer obj)
    {
        this.obj=obj;
        t=new Thread(this,"RandomNumber");
        t.start();
    }
    public void run()
    {
        while(true)
        {
            num=rm.nextInt(100);
            obj.numgenerator(num);
        }
    }
}

class Square implements Runnable
{
    Printer obj;
    Thread t;
    Square(Printer obj)
    {
        this.obj=obj;
        t=new Thread(this,"Square");
        t.start();
    }
    public void run()
    {
        while(true)
        {
            obj.square();
        }
    }
}

class Cube implements Runnable
{
    Printer obj;
    Thread t;
    Cube(Printer obj)
    {
        this.obj=obj;
        t=new Thread(this,"Cube");
        t.start();
    }
    public void run()
    {
        while(true)
        {
            obj.cube();
        }
    }
}

public class ThreadPractice
{
    public static void main(String args[])
    {
        Printer obj=new Printer();
        RandomNumber rn=new RandomNumber(obj);
        Square sq=new Square(obj);
        Cube cb=new Cube(obj);
        try
        {
            rn.t.join();
            sq.t.join();
            cb.t.join();
        }
        catch(InterruptedException ex)
        {
            System.out.println("Exception : "+ex);
        }
    }
}
