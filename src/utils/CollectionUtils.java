package utils;

import java.util.HashMap;
import java.util.Map;

import OnLine_Book_Shop.Book;

public class CollectionUtils 
{
    private static Map<String, Book> booksMap = new HashMap<>();

    public static void addBook(Book book) 
{
        booksMap.put(book.getTitle(), book);
    }

    public static Book getBook(String title) 
{
        return booksMap.get(title);
    }


    public static Map<String, Book> getBooksMap() 
{
        return booksMap;

    }
}
