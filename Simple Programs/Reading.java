import java.util.Scanner;

public class Reading {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   //Inputting from keyboard, terminal
        System.out.print("RollNo: ");
        int rno = scanner.nextInt();
        System.out.print("Name: ");
        String name = scanner.next().trim();
        System.out.println("RollNo: "+rno+" Name: "+name);
        scanner.close();
    }
}
