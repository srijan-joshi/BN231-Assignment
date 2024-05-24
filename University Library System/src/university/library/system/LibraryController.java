/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university.library.system;

/**
 *
 * @author User
 */


import java.util.ArrayList;
import java.util.Scanner;

public class LibraryController {
    private ArrayList<BookTitle> bookCollection;
    private Scanner scanner;

    public LibraryController() {
        bookCollection = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean exit = false;

        while (!exit) {
            System.out.println("Library System Menu:");
            System.out.println("1. Add a new book");
            System.out.println("2. View all books");
            System.out.println("3. Update a book");
            System.out.println("4. Delete a book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("Enter book catalog number: ");
        String catalogNumber = scanner.nextLine();

        BookTitle newBook = new BookTitle(title, author, publisher, catalogNumber);
        bookCollection.add(newBook);
        System.out.println("Book added successfully.");
    }

    private void viewBooks() {
        if (bookCollection.isEmpty()) {
            System.out.println("No books in the collection.");
        } else {
            for (int i = 0; i < bookCollection.size(); i++) {
                System.out.println("Book " + (i + 1) + ":");
                System.out.println(bookCollection.get(i));
                System.out.println();
            }
        }
    }

    private void updateBook() {
        System.out.print("Enter the catalog number of the book to update: ");
        String catalogNumber = scanner.nextLine();

        for (BookTitle book : bookCollection) {
            if (book.getCatalogNumber().equals(catalogNumber)) {
                System.out.print("Enter new title (leave blank to keep current): ");
                String title = scanner.nextLine();
                if (!title.isEmpty()) {
                    book.setTitle(title);
                }

                System.out.print("Enter new author (leave blank to keep current): ");
                String author = scanner.nextLine();
                if (!author.isEmpty()) {
                    book.setAuthor(author);
                }

                System.out.print("Enter new publisher (leave blank to keep current): ");
                String publisher = scanner.nextLine();
                if (!publisher.isEmpty()) {
                    book.setPublisher(publisher);
                }

                System.out.println("Book updated successfully.");
                return;
            }
        }
        System.out.println("Book with catalog number " + catalogNumber + " not found.");
    }

    private void deleteBook() {
        System.out.print("Enter the catalog number of the book to delete: ");
        String catalogNumber = scanner.nextLine();

        for (int i = 0; i < bookCollection.size(); i++) {
            if (bookCollection.get(i).getCatalogNumber().equals(catalogNumber)) {
                bookCollection.remove(i);
                System.out.println("Book deleted successfully.");
                return;
            }
        }
        System.out.println("Book with catalog number " + catalogNumber + " not found.");
    }

    public static void main(String[] args) {
        LibraryController controller = new LibraryController();
        controller.run();
    }
}
