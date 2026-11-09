import java.io.FileNotFoundException;
import  java.io.FileReader;
import java.io.IOException;

class Exceptions {
    public static void demo() {
        FileReader reader = null;
        try {
            reader = new FileReader("file.txt");
            var value = reader.read();
        }
        catch(FileNotFoundException e) {
            System.out.println("File cannot be opened!");
        }
        catch(IOException e) {
            System.out.println("Data cannot be read!");
        }
        finally {
            try {
                reader.close();
            } catch (Exception e) {
                System.out.println("File cannot be closed!");
            }
        }
    }

    public static void main(String[] args) {
        Exceptions.demo();
    }
}