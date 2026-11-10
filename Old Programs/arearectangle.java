class Rectangle
{
    float length;
    float breadth;
    float area;

    void readdata(float a,float b)
    {
        length=a;
        breadth=b;
    }

    float findarea()
    {
        area=length*breadth;
        return area;
    }
    void printarea()
    {
        System.out.println("Area="+area);
    }
    
}

public class arearectangle
{
    public static void main(String[]args)
    {
        Rectangle r1;
        r1=new Rectangle();
        r1.readdata(2,3);
        r1.findarea();
        r1.printarea();
    }
}
