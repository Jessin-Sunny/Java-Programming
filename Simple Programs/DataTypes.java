import java.awt.*;
import java.util.Arrays;
public class DataTypes {
    public static void main(String[] args) {
        int x = 5; //Primitive datatypes
        int y = x;
        Point point1 = new Point(1, 2);
        Point point2 = point1;
        x = 7;
        point1.x = 2;
        //System.out.println("x = " + x);
        //System.out.println(y);
        //System.out.println(point1);
        //System.out.println(point2);

        int arr[] = new int[5];
        for (int i=0;i<5;i ++){
            arr[i] = i;
        }

        //System.out.println(Arrays.toString(arr)); //Int array return address

        int matrix[][] = new int[5][5];
        for (int i=0;i<5;i++) {
            for (int j=0;j<5;j++) {
                matrix[i][j] = i*j;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}
