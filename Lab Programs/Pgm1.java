class palindrome
{
    int len;
    char[] str;
    //str=new char[25];
    char[] input()
    {
        char []str={'M','A','L','A','Y','A','L','A','a'};
        return str;
    }
    int len(int a)
    {
        len=a;
        return len;
    }
    int checkpalindrome()
    {
        int i,l,h;
        i=0;
        l=len-1;
        while (i>l)
        {
            if (str[i++]!=str[l--])
            {
                return 0;
            }
        }
        return 1;
    }

}

public class Pgm1
{
    public static void main(String[]args)
    {
        int val;
        palindrome str;
        str=new palindrome();
        str.input();
        str.len(9);
        val=str.checkpalindrome();
        if (val==1)
        {
            System.out.println("The given string is palindrome");
        }
        else
        {
            System.out.println("The given string is not palindrome");
        }
    }    
}