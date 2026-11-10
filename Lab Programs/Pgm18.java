import java.util.Scanner;
class Search
{
    protected int low=0,high,mid,sno,n;
    private int arr[];
    Search(int a[],int sno,int n)
    {
        arr=a;
        this.sno=sno;
        this.n=n;
    }
    protected int binarysearch()
    {
        high=n-1;
        while(low<=high)
        {
            mid=(low+high)/2;
            if (arr[mid]==sno)
            {
                return mid+1;
            }
            if (arr[mid]>sno)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return -1;
    }

}

public class Pgm18
{
    public static void main(String args[])
    {
        int n,sno,result;
        Scanner reader=new Scanner(System.in);
        int a[]=new int[25];
        System.out.print("How many elements ? :");
        n=reader.nextInt();
        System.out.print("Enter the elements : ");
        for(int i=0;i<n;i++)
        {
            a[i]=reader.nextInt();
        }
        System.out.print("Enter the number to be searched : ");
        sno=reader.nextInt();
        Search obj=new Search(a,sno,n);
        result=obj.binarysearch();
        if (result==-1)
        {
            System.out.println(sno+" Not Found");
        }
        else
        {
            System.out.println(sno+" is present at "+result);
        }

    }
}