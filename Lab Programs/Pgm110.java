import java.util.Random;
class FlagVariable
{
    public static int num;
    public static boolean numgen=false;
}
class Square extends Thread
{
    int n,sqr;
    public void run()
    {
        n=FlagVariable.num;
        while(true)
        {
            if(n%2==0)
            {
                sqr=n*n;
                System.out.println("Square of "+n+" = "+sqr);
            }
            try 
            {
                Thread.sleep(3000);
            } 
            catch (InterruptedException ex) 
            {
                System.out.println("Exception : " + ex);
            }
        }
    }
}
class Cube extends Thread
{
    int n,cube;
    public void run()
    {
        n=FlagVariable.num;
        if(n%2!=0)
        {
            cube=n*n*n;
            System.out.println("Cube of "+n+" = "+cube);
        }
        try 
        {
            Thread.sleep(3000);
        } 
        catch (InterruptedException ex) 
        {
            System.out.println("Exception : " + ex);
        }
    }
}
class NumberGenerator extends Thread
{
    public void run()
    {
        Random randnum=new Random();
        while(true)
        {
            FlagVariable.num=randnum.nextInt(100);
            FlagVariable.numgen=true;
            System.out.println("Number Generated : "+FlagVariable.num);
            try 
            {
                Thread.sleep(3000);
            } 
            catch (InterruptedException ex) 
            {
                System.out.println("Exception : " + ex);
            }
        }
    }
}

public class Pgm110 
{
    public static void main(String args[]) 
    {
        NumberGenerator t1 = new NumberGenerator();
        t1.start();
        while(true)
        {
            Square t2 = new Square();
            Cube t3 = new Cube();
            t2.start();
            t3.start();
            try {
                t1.join();
                t1.sleep(2000);
                t2.join();
                t3.join();
            } catch (InterruptedException ex) {
                System.out.println("Exception : " + ex);
            }
        }
    }
}
