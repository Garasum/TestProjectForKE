package temp.exeptino;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//http://www.quizful.net/post/java-exceptions
public class ExeptionHierarcy {
    public static void main(String[] args) {
        String fileName = "qwe";
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
        } catch (FileNotFoundException ex) {
            System.out.println("Oops, FileNotFoundException caught");
        } catch (IOException e) {
            System.out.println("IOEXCEOTION");
        }
    }
}
