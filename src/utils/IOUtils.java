package utils;



import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import OnLine_Book_Shop.Book;

public class IOUtils {
    public static void saveCartToFile(String fileName, Map<String, Book> cartContents) 
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("abc.txt"))) {
            oos.writeObject(cartContents);
            System.out.println("Cart contents saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

