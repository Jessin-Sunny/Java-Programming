/*Program for understanding Collections*/
import java.util.*;
public class CollectionExample
{
    public static void main(String args[])
    {
        ArrayList<String> al=new ArrayList<String>();
        //adding elements
        al.add("Ten");
        al.add("Twenty");
        al.add("Thirty");
        al.add("Fifty");
        al.remove("Fifty");
        Iterator<String> it=al.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }

    }
}
