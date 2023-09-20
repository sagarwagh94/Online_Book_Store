package tester;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import customexception.BookHandlingException;
import utils.CollectionUtils;
import utils.IOUtils;
import OnLine_Book_Shop.Book;

import OnLine_Book_Shop.Book.Category;

public class BookShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Adding sample books to the shop
        Book book1 = new Book("JAVA", "Herbert Schildt", 1045.99, Category.NON_FICTION,
                LocalDate.of(2020, 1, 15));
        Book book2 = new Book("YOU CAN WIN", "SHIV KHERA", 530.40, Category.FICTION,
                LocalDate.of(1994, 8, 7));
        Book book3 = new Book("CHAWA", "SHIVAJI SAMANT", 699.99, Category.THRILLER, LocalDate.of(2007, 4, 15));
        Book book4 = new Book("RADHEY", "S SAMANT", 600.50, Category.FICTION, LocalDate.of(1964, 2, 6));
        Book book5 = new Book("MRYTYUNJAY", "S SAMANT", 534.99, Category.SCIENCE_FICTION, LocalDate.of(2021, 10, 21));

        CollectionUtils.addBook(book1);
        CollectionUtils.addBook(book2);
        CollectionUtils.addBook(book3);
        CollectionUtils.addBook(book4);
        CollectionUtils.addBook(book5);

        Map<String, Book> userCart = new HashMap<>();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Display all books from the shop");
            System.out.println("2. Add Book to The Cart");
            System.out.println("3. Show User Cart Contents");
            System.out.println("4. Check out (Exit)");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    displayAllBooks();
                    break;
                case 2:
                    addBookToCart(userCart, sc);
                    break;
                case 3:
                    showUserCartContents(userCart);
                    break;
                case 4:
                    checkOutAndSaveCart(userCart);
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
        sc.close();
    }

    private static void displayAllBooks() {
        System.out.println("\nAvailable Books:");
        CollectionUtils.getBooksMap().values().forEach(System.out::println);
    }

    private static void addBookToCart(Map<String, Book> userCart, Scanner sc) {
        System.out.println("\nEnter the Book Title to add to the cart:");
        String title = sc.nextLine();

        Book book = CollectionUtils.getBook(title);
        if (book == null) {
            throw new BookHandlingException("Book with title: " + title + " not available in the shop!");
        }

        userCart.put(title, book);
        System.out.println("Book added to the cart.");
    }

    private static void showUserCartContents(Map<String, Book> userCart) {
        System.out.println("\nUser's Cart Contents:");
        userCart.values().forEach(System.out::println);
    }

    private static void checkOutAndSaveCart(Map<String, Book> userCart) {
        if (userCart.isEmpty()) {
            System.out.println("\nUser's Cart is empty. No purchase made.");
        } else {
            System.out.println("\nUser's Cart Contents:");
            userCart.values().forEach(System.out::println);

            double totalCartValue = userCart.values().stream().mapToDouble(Book::getPrice).sum();
            System.out.println("\nTotal Cart Value: $" + totalCartValue);

            // Save cart contents to a binary file using serialization
            IOUtils.saveCartToFile("abc.txt", userCart);
        }
        System.out.println("Exiting the application. Thank you!");
    }
}
