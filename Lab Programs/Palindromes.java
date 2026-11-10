public class Palindromes 
{
    public static boolean isPalindrome(int num)
    {
        int originalNum,reversedNum,remainder;
        originalNum=num;reversedNum=0;
        while (num > 0) 
        {
            remainder = num % 10;
            reversedNum = reversedNum * 10 + remainder;
            num /= 10;
        }
        return originalNum == reversedNum;
    }
    public static void main(String args[]) 
    {
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        System.out.println("Palindrome numbers between " + num1 + " and " + num2 + " are:");
        for (int i = num1; i <= num2; i++) {
            if (isPalindrome(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
