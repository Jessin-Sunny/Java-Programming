public class Casting {
    public static void main(String[] args) {
        int x =10;
        float f = 10.1F;    //F is needed last to represent it as float
        double y = x + 2.2; //Implicit Casting
        int z = (int)y + 2; //Explicit Casting
        String val = "20";
        int value = Integer.parseInt(val);  // String to Integer
        System.out.println(y);
        System.out.println(z);
        System.out.println(value);
    }
}