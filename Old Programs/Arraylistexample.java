import java.util.*;
public class Arraylistexample
{
    public static void main(String args[])
    {
        ArrayList<String> list=new ArrayList<String>();
        /*
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("How many elements ? : ");
        num=reader.read();
        for(int i=0;i<num;i++)
        {
            System.out.print("Enter the element : ");
            element=reader.readLine();
            list.add(i,element);
        }
        */
        list.add("one");
        list.add("two");
        list.add("three");
        Iterator itr=list.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }
    }
}