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
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LibraryController {
    private ArrayList<BookTitle> bookCollection;
    private ArrayList<BookCopy> bookCopyList;
    private Scanner scanner;

    public LibraryController() {
        bookCollection = new ArrayList<>();
        bookCopyList = new ArrayList<>();
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
            System.out.println("5. Are you adding a book copy?");
            System.out.println("6. Loan or Return a book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> updateBook();
                case 4 -> deleteBook();
                //lamba function
                case 5 -> addBookCopy();
                //case 6 -> loanOrReturn();
                case 7 -> exit = true;
                default -> System.out.println("Invalid choice. Please try again.");
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
        List<String> headers = Arrays.asList("Title", "Author", "Publisher","Catalog Number");
        int[] columnWidths = new int[headers.size()];

        // Calculate column widths
        for (int i = 0; i < headers.size(); i++) {
            columnWidths[i] = headers.get(i).length();
        }
        if (bookCollection.isEmpty()) {
            System.out.println("No books in the collection.");
        } else {
            for (int i = 0; i < headers.size(); i++) {
            System.out.print(String.format("%-" + columnWidths[i] + "s ", headers.get(i)));
        }
        System.out.println();
        // Print separator
        for (int width : columnWidths) {
            for (int i = 0; i < width; i++) {
                System.out.print("-");
            }
            System.out.print(" ");
        }
        System.out.println();

            for (int i = 0; i < bookCollection.size(); i++) {
                System.out.print(String.format("%-" + columnWidths[i] + "s ",
                        bookCollection.get(i).getTitle()));
                System.out.print(String.format("%10s-" + columnWidths[i] + "s ",
                        bookCollection.get(i).getAuthor()));
                System.out.print(String.format("%10s-" + columnWidths[i] + "s ",
                        bookCollection.get(i).getPublisher()));
                System.out.print(String.format("%10s-" + columnWidths[i] + "s ",
                        bookCollection.get(i).getCatalogNumber()));
                //System.out.println("Book " + (i + 1) + ":");
                //System.out.println(bookCollection.get(i));
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
    
    private void addBookCopy() {
    System.out.print("Enter the catalog number of the book to add a copy: ");
    String catalogNumber = scanner.nextLine();

    for (BookTitle book : bookCollection) {
        if (book.getCatalogNumber().equals(catalogNumber)) {
            int copyNumber = getNextCopyNumber(catalogNumber);
            System.out.print("Enter edition: ");
            int edition;
            try {
                edition = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for edition. Please enter a valid integer.");
                return;
            }
            System.out.print("Enter publication year: ");
            int publicationYear;
            try {
                publicationYear = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for publication year. Please enter a valid integer.");
                return;
            }
            System.out.print("Enter ISBN: ");
            String ISBN = scanner.nextLine();
            System.out.print("Enter book status: ");
            String bookStatus = scanner.nextLine();

            BookCopy newCopy = new BookCopy();
            newCopy.setTitle(book.getTitle());
            newCopy.setAuthor(book.getAuthor());
            newCopy.setPublisher(book.getPublisher());
            newCopy.setCatalogNumber(catalogNumber);
            newCopy.setCopyNumber(copyNumber);
            newCopy.setEdition(edition);
            newCopy.setPublicationYear(publicationYear);
            newCopy.setISBN(ISBN);
            newCopy.setBookStatus(bookStatus);

            bookCopyList.add(newCopy);
            System.out.println("Book copy added successfully.");
            return;
        }
    }
    System.out.println("Book with catalog number " + catalogNumber + " not found.");
}

    private int getNextCopyNumber(String catalogNumber) {
        int maxCopyNumber = 0;
        for (BookCopy copy : bookCopyList) {
            if (copy.getCatalogNumber().equals(catalogNumber)) {
                maxCopyNumber = Math.max(maxCopyNumber, copy.getCopyNumber());
            }
        }
        return maxCopyNumber + 1;
    }

    public static void main(String[] args) {
        LibraryController controller = new LibraryController();
        controller.run();
    }
}
