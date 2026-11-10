public class Matrix
{
    int[][] arr;        //instance variables
    int m,n;
    public Matrix(int[][] arr,int m,int n)      //Parameterised Constructor
    {
        this.arr=arr;
        this.m=m;
        this.n=n;
    }
    public void display()                   //displaying after matrix multiplication
    {
        int i,j;
        for(i=0;i<this.m;i++)
        {
            for (j=0;j<this.n;j++)
            {
                System.out.print(this.arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    static Matrix multiply(Matrix m1,Matrix m2)   //method having objects as arguments
    {
        int i,j,k;
        int[][] arr=new int[m1.m][m2.n];        //accesing members
        for (i=0;i<m1.m;i++)
        {
            for (j=0;j<m2.n;j++)
            {
                arr[i][j]=0;
                for (k=0;k<m1.n;k++)
                {
                    arr[i][j]+=m1.arr[i][k]*m2.arr[k][j];
                }
            }
        }
        return new Matrix(arr,m1.m,m2.n);       
    }
    public static void main(String[] args)
    {
        int m=3,n=2,p=2,q=2;        //User Input
        int[][] a={{1,2},
                  {3,4},
                  {5,6}};
        int[][] b={{10,20},
                  {40,50}};
        Matrix m1=new Matrix(a,m,n);
        Matrix m2=new Matrix(b,p,q);
        Matrix m3=Matrix.multiply(m1,m2);
        System.out.println("After Matrix Multiplication : ");
        m3.display();

    }
}

