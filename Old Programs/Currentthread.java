class Cuurentthread extends Thread
{
    public static void main(String args[])
    {
        Thread t=Thread.currentThread();
        System.out.println("Thread : "+t);
        t.setName("Current");
        System.out.println("Thread Name Now : "+t);
        try
        {
            for(int i=5;i>=0;i--)
            {
                System.out.println(i);
                t.sleep(2000);
            }
        }
        catch(InterruptedException ex)
        {
            System.out.println("Exception "+ex);
        }

    }
}
