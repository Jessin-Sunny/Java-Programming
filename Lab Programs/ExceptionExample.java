/*Accepting a number from user and generation EvenException if it is an even number and similarly for odd number */

import java.io.*;
import java.util.Scanner;

class EvenException extends Exception
{
    public String toString()
    {
        return "Number entered is an even number";
    }
}

class OddException extends Exception
{
    public String toString()
    {
        return "Number entered is a odd number";
    }
}

public class ExceptionExample
{
    public static void checknum(int num) throws EvenException,OddException
    {
        if(num%2==0)
        {
            throw new EvenException();
        }
        else
        {
            throw new OddException();
        }
    }
    public static void main(String args[])
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner(System.in);
        int num;
        System.out.print("Enter a number : ");
        num=sc.nextInt();
        try
        {
            ExceptionExample.checknum(num);
        }
        catch(EvenException ex)
        {
            System.out.println("Exception : "+ex);
        }
        catch(OddException ex)
        {
            System.out.println("Exception : "+ex);
        }
    }
}