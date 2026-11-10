/*Generating Even Number and Odd Number*/

class Printer
{
    int value;
    boolean estatus=false;
    synchronized void edisplay(int n)
    {
        while(estatus)
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
        value=n;
        estatus=true;
        System.out.println("Even Number : "+value);
        notify();
    }
    synchronized void odisplay(int n)
    {
        while(!estatus)
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
        value=n;
        estatus=false;
        System.out.println("Odd Number : "+value);
        notify();
    }
}

class Enumber implements Runnable
{
    Printer obj;
    Thread t;
    int i=0;
    Enumber(Printer obj)
    {
        this.obj=obj;
        t=new Thread(this,"Even");
        t.start();
    }
    public void run()
    {
        while(true)
        {
            obj.edisplay(i);
            i=i+2;
        }
    }
}

class Onumber implements Runnable
{
    Printer obj;
    Thread t;
    int i=1;
    Onumber(Printer obj)
    {
        this.obj=obj;
        t=new Thread(this,"Odd");
        t.start();
    }
    public void run()
    {
        while(true)
        {
            obj.odisplay(i);
            i=i+2;
        }
    }
}



public class SynchPractice
{
    public static void main(String args[])
    {
        Printer obj=new Printer();
        Enumber even=new Enumber(obj);
        Onumber odd=new Onumber(obj);
        try
        {
            even.t.join();
            odd.t.join();
        }
        catch(InterruptedException ex)
        {
            System.out.println("Exception : "+ex);
        }
    }
}
