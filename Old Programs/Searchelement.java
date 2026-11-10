import java.util.*;
public class Searchelement
{
	public static void main(String[] args)
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("Red");
        list.add("Blue");
		list.add("Green");
		list.add("Orange");
		list.add("White");
		list.add("Black");
		if (list.contains("Orange"))
		{
			System.out.println("Found the element");
		}
		else
		{
			System.out.println("There is no such element");
		}
	}
}
