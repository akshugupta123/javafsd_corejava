package file;

//package practiceProject2;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWriteAppendExample 
{
    public static void main(String[] args) 
        {
        String filePath = "example.txt";
        writeToFile(filePath, "Hello, World!");
        String content = readFromFile(filePath);
        System.out.println("Content read from file: " + content);
        appendToFile(filePath, " Appended content!");
        content = readFromFile(filePath);
        System.out.println("Content read from file after appending: " +  content);
        }
private static void writeToFile(String filePath, String content)
 {
 try 
 (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)))            {       
            writer.write(content);
            System.out.println("Successfully wrote to file.");
} 
catch (IOException e) 
      {
       System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
 }
 private static String readFromFile(String filePath) 
    {
    StringBuilder content = new StringBuilder();
    try 
  (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
   String line;
   while ((line = reader.readLine()) != null) {
   content.append(line);
    }
 } 
  catch (IOException e)
 {
    System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        return content.toString();
    }

    private static void appendToFile(String filePath, String content) 
   {
   try 
(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) 
{
      writer.write(content);
      System.out.println("Successfully appended to file.");
        } 
     catch (IOException e) 
     {
       System.out.println("An error occurred while appending to the file: " + e.getMessage());
            }
}
}





