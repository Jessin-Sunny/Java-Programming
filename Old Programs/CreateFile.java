import java.io.*;

public class CreateFile {
    public static void main(String args[]) {
        try {
            String fileName = "MyFile.txt";
            String content = "This is the University Exam for OODP.\nThis a program to illustrate the use of files\n";
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
            System.out.println("File created successfully!");
        } catch (IOException ex) {
            System.out.println("Error in writing "+ex);
        }
    }
}


