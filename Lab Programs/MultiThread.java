import java.util.Random;

class Data
{
    public int num;
    public boolean status=false;
    public synchronized void number(int num)
    {
        while(status)
        { 
            try
            {
                wait();
            }
            catch(InterruptedException ex)
            {
                System.out.println("Exception arrises : "+ex);
            }
        }
        System.out.println("Number : "+num);
        this.num=num;
        status=true;
        notifyAll();
    }
    public synchronized void sdisplay(int num)
    {
        if(!status && this.num%2!=0)
        {
            try
            {
                wait();
            }
            catch(InterruptedException ex)
            {   
                System.out.println("Exception arrises : "+ex);
            }
        }
        System.out.println("Square : "+(num*num));
        status=false;
        notify();
    }
    public synchronized void cdisplay(int num)
    {
        while(!status && this.num%2==0)
        {
            try
            {
                wait();
            }
            catch(InterruptedException ex)
            {   
                System.out.println("Exception arrises : "+ex);
            }
        }
        System.out.println("Cube : "+(num*num*num));
        status=false;
        notify();
    }
}

class NumGenerator implements Runnable
{
    Data obj;
    int num;
    Random n=new Random();
    public NumGenerator(Data obj)
    {
        this.obj=obj;
    }
    public void run()
    {
        while(true)
        {     
            num=n.nextInt(100);
            obj.number(num);
            try
            {
                Thread.sleep(3000);
            }
            catch(InterruptedException ex)
            {
                System.out.println("Exception arrises : "+ex);
            }
        }

    }
}

class Square implements Runnable
{    
    Data obj;
    public Square(Data obj)
    {
        this.obj=obj;
    }

    public void run()
    {
        while(true)
        {
            obj.sdisplay(obj.num);
            try
            {
                Thread.sleep(3000);
            }
            catch(InterruptedException ex)
            {
                System.out.println("Exception arrises : "+ex);
            }
        }
    }
}

class Cube implements Runnable
{    
    Data obj;
    public Cube(Data obj)
    {
        this.obj=obj;
    }

    public void run()
    {
        while(true)
        {
            obj.cdisplay(obj.num);
            try
            {
                Thread.sleep(3000);
            }
            catch(InterruptedException ex)
            {
                System.out.println("Exception arrises : "+ex);
            }
        }
    }
}

public class MultiThread
{
    public static void main(String args[])
    {
        Data obj=new Data();

        NumGenerator num=new NumGenerator(obj);
        Square sq=new Square(obj);
        Cube cu=new Cube(obj);

        Thread t1=new Thread(num,"RandomNumber");
        Thread t2=new Thread(sq,"Square");
        Thread t3=new Thread(cu,"Cube");

        t1.start();
        t2.start();
        t3.start();
    }
}