/*Thread Synchronization*/
class CallMe
{
    public void call(String msg)
    {
        System.out.print("["+msg);
    
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }
        System.out.println("]");
    }
}


class Caller implements Runnable
{
    CallMe obj;
    String msg;
    Thread t;
    Caller(CallMe obj,String msg)
    {
        this.obj=obj;
        this.msg=msg;
        t=new Thread(this);
        t.start();
    }
    public void run()
    {
        synchronized(obj)
        {
            obj.call(msg);
        }
    }
}


public class SynchExample
{
    public static void main(String args[])
    {
        CallMe obj=new CallMe();
        Caller ob1=new Caller(obj,"Hello");
        Caller ob2=new Caller(obj,"Java");
        Caller ob3=new Caller(obj,"World");

        try
        {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        }
        catch(InterruptedException ex)
        {
            System.out.println(ex.getStackTrace());
        }
    }
}
