import java.util.Scanner;

class userinput 
{
    public static void main(String[]args)
    {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter name : ");
        String name=input.nextLine();
        System.out.print("Enter Age : ");
        int age=input.nextInt();
        System.out.println("User : "+name);
        System.out.println("Age : "+age);
    }
}
