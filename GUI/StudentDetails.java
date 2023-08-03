package GUI;
// Java Program to write into a File
// Using BufferedWriter Class
 
// Importing java input output libraries
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//import Classes.*;
 
// Main class
public class StudentDetails{
    //private Object a;
 
    public void writeDetails(String s){
        
        try {
            //String h= s.toString(); 
            BufferedWriter f_writer
                = new BufferedWriter(new FileWriter(
                    "loginDetails.txt"));
            f_writer.write(s);
            System.out.print(s);
            System.out.print(
                "File is created successfully with the content.");
 
            f_writer.close();
        }
 
        // Catch block to handle if exceptions occurs
        catch (IOException e) {
 
          
            System.out.print(e.getMessage());
        }
    }
}
