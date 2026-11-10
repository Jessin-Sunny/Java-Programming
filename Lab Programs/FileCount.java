/*Program for reading line by line and writing to file and counting the number of characters, lines and words*/
import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
public class FileCount
{
    public static void main(String args[])
    {
        int charCount=0,wordCount=0,lineCount=0;
        String str;
        String word;
        StringTokenizer st;
        byte[] by;
        int c;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try
        {
            FileWriter fw=new FileWriter("File1.txt");
            System.out.println("Enter the file contents line by line");
            System.out.println("Type 'quit' to exit : ");
            while(!(str=br.readLine()).equals("quit"))
            {
                st=new StringTokenizer(str," ");
                while(st.hasMoreTokens())
                {
                    word=st.nextToken();
                    charCount=charCount+word.length();
                    wordCount=wordCount+1;
                }
                fw.write(str);
                fw.write('\n');
                lineCount=lineCount+1;
            };

            fw.close();
            FileReader fr=new FileReader("File1.txt");
            System.out.println("File Contents : ");
            
            while((c=fr.read())!=-1)
            {
                System.out.print((char)c);
            };
            System.out.println();
            System.out.println("Number of Characters : "+charCount);
            System.out.println("Number of Words : "+wordCount);
            System.out.println("Number of Lines : "+lineCount);
            fr.close();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Exception arises : "+ex);
        }
        catch(IOException ex)
        {
            System.out.println("Exception arises : "+ex);
        }


    }
}
