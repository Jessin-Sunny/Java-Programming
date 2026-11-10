class Rectangle {
    private int length;
    private int breadth;

    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public Rectangle(Rectangle rectangle) {
        this.length = rectangle.length;
        this.breadth = rectangle.breadth;
    }

    public int getLength() {
        return length;
    }

    public int getBreadth() {
        return breadth;
    }
}
public class Rect {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(5, 10);
        Rectangle rectangle2 = new Rectangle(rectangle1);

        System.out.println("Rectangle 1: Length = " + rectangle1.getLength() + ", Breadth = " + rectangle1.getBreadth());
        System.out.println("Rectangle 2: Length = " + rectangle2.getLength() + ", Breadth = " + rectangle2.getBreadth());
    }
}


