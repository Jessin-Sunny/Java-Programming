class InvalidNumberException extends Exception {
    public InvalidNumberException(String message) {
        super(message);
    }
}

public class AverageN {
    public static void main(String[] args) throws InvalidNumberException {
        int sum = 0;
        int count = 0;
        for (int i=0;i<args.length;i++) {
            int num = Integer.parseInt(args[i]);
            if (num <= 0) {
                throw new InvalidNumberException("Invalid input: " + num);
            }
            sum += num;
            count++;
        }
        double average = (double) sum / count;
        System.out.println("Average of " + count + " positive numbers is " + average);
    }
}


