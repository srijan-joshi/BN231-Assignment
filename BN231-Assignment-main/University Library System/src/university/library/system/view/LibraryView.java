/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university.library.system.view;

/**
 *
 * @author DELL
 */
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import university.library.system.controller.CheckOutHandler;
import university.library.system.controller.NewBookController;
import university.library.system.model.BookCopy;
import university.library.system.model.BookStatus;
import university.library.system.model.BookTitle;
import university.library.system.model.Patron;
import university.library.system.model.PatronType;

public class LibraryView {
    
    Scanner scanner = new Scanner(System.in);
    private NewBookController controller;
    private CheckOutHandler checkOutHandler;

    public void run() {
        controller = new NewBookController();
        checkOutHandler = new CheckOutHandler();

        boolean exit = true;

        while (exit) {
            System.out.println("Library System Menu:");
            System.out.println("1. Add a new book");
            System.out.println("2. View all books");
            System.out.println("3. Update a book");
            System.out.println("4. Delete a book");
            System.out.println("5. Are you adding a book copy?");
            System.out.println("6. Loan / Return / Reserve a book");
            System.out.println("7: Patron System");
            System.out.println("8. Exit");
            System.out.println("");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> controller.updateBook();
                case 4 -> controller.deleteBook();
                //lamba function
                case 5 -> controller.addBookCopy();
                case 6 -> loanOrReturn();
                case 7 -> patronsView();
                case 8 -> exit = false;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
//    private void viewBooks() {
//        List<BookTitle> bookCollection = controller.viewBooks() ;
//        List<String> headers = Arrays.asList("Title", "Author", "Publisher","Catalog Number");
//        int[] columnWidths = new int[headers.size()];
//
//        // Calculate column widths
//        for (int i = 0; i < headers.size(); i++) {
//            columnWidths[i] = headers.get(i).length();
//        }
//        if (bookCollection.isEmpty()) {
//            System.out.println("No books in the collection.");
//        } else {
//            for (int i = 0; i < headers.size(); i++) {
//            System.out.print(String.format("%-" + columnWidths[i] + "s ", headers.get(i)));
//        }
//        System.out.println();
//        // Print separator
//        for (int width : columnWidths) {
//            for (int i = 0; i < width; i++) {
//                System.out.print("-");
//            }
//            System.out.print(" ");
//        }
//        System.out.println();
//
//            for (int i = 0; i < bookCollection.size(); i++) {
//                System.out.print(String.format("%-" + columnWidths[i] + "s ",
//                        bookCollection.get(i).getTitle()));
//                System.out.print(String.format("%-" + columnWidths[i]*2 + "s ",
//                        bookCollection.get(i).getAuthor()));
//                System.out.print(String.format("%-" + columnWidths[i]*2 + "s ",
//                        bookCollection.get(i).getPublisher()));
//                System.out.print(String.format("%-" + columnWidths[i]*2 + "s ",
//                        bookCollection.get(i).getCatalogNumber()));
//                //System.out.println("Book " + (i + 1) + ":");
//                //System.out.println(bookCollection.get(i));
//                System.out.println();
//            }
//        }
//        
//    }

    private void viewBooks() {
    List<BookTitle> bookCollection = controller.viewBooks();
    String[] headers = {"Title", "Author", "Publisher", "Catalog Number"};

    System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+");
    System.out.printf("| %-20s | %-20s | %-20s | %-20s |\n", headers[0], headers[1], headers[2], headers[3]);
    System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+");

    for (BookTitle book : bookCollection) {
        System.out.printf("| %-20s | %-20s | %-20s | %-20s |\n", book.getTitle(), book.getAuthor(), book.getPublisher(), book.getCatalogNumber());
    }
    System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+");
}

    private void patronsView() {
            System.out.println("Patron Details:");
            System.out.println("1. Add Patron");
            System.out.println("2. View all Patron");
            System.out.println("3. Return to Main Menu");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addPatron();
                case 2 -> viewPatron();
                case 3 -> run();
                default -> System.out.println("Invalid choice. Please try again.");
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
        controller.addBook(newBook);
        System.out.println("Book added successfully.");


    }

//    private void viewPatron() {
//        List<Patron> patrons = controller.getAllPatrons();
//        for(Patron p : patrons){
//            System.out.println(p.getName());
//            System.out.print(p.getAddress()  + "   " + p.getPatrontype() + "   ");
//            System.out.print(p.getId());
//            System.out.println("");
//
//
//        }
//    }
    private void viewPatron() {
        List<Patron> patrons = controller.getAllPatrons();

        System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+");
        System.out.printf("| %-20s | %-20s | %-10s | %-10s |\n", "Name", "Address", "Patron Type", "ID");
        System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+");

        for (Patron p : patrons) {
            System.out.printf("| %-20s | %-20s | %-10s | %-10s |\n", p.getName(), p.getAddress(), p.getPatrontype(), p.getId());
        }
        System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+");
    }

    private void addPatron() {
        PatronType patrontype = null;
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Telephone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Patron Type ");
        System.out.print("1 for Faculty member, 2 for Undergrad, 3 for postgrad :");
        Integer patrontypeInput = scanner.nextInt();
        if (patrontypeInput == 1){
            patrontype = PatronType.FAC;
        }
        else if (patrontypeInput == 2) {
            patrontype = PatronType.UG;
        }
        else if (patrontypeInput == 3) {
            patrontype = PatronType.PG;
        }
        else{
            System.out.println("Invalid Input");
        }
        Patron patron = new Patron(0,name, address, phone, patrontype);
        controller.addPatron(patron);
    }

    private void loanOrReturn() {
            System.out.println("1. Loan Book");
            System.out.println("2. Return Book");
            System.out.println("3. Reservation");
            System.out.println("4. View all Copy Status");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> loanBook();
                case 2 -> returnBook();
                case 3 -> cancelOrReserveBook();
                case 4 -> viewBookStatus();
                case 5 -> run();
                default -> System.out.println("Invalid choice. Please try again.");
            }
    }

//    private void loanBook() {
//        List<BookCopy> listBookCopy = controller.getAllBookCopy();
//        for(BookCopy b : listBookCopy) {
//            if(b.getBookStatus() != BookStatus.LOAN)
//                System.out.println(b);
//                System.out.println(" ");
//        }
//        System.out.print("Enter catalog number: ");
//        String cn = scanner.nextLine();
//        System.out.print("Enter copy number: ");
//        Integer copyNumber = scanner.nextInt();
//        System.out.println("Enter your ID:");
//        Integer patronId = scanner.nextInt();
//        controller.loanBookCopy(cn,copyNumber,patronId);
//    }
    private void loanBook() {
    List<BookCopy> listBookCopy = controller.getAllBookCopy();

    System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");
    System.out.printf("| %-20s | %-20s | %-10s | %-10s | %-10s | %-10s |\n", "Book Title", "Catalog Number", "Copy Number", "Book Status", "Due Date", "Patron ID");
    System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");

    for(BookCopy b : listBookCopy) {
        if(b.getBookStatus() != BookStatus.LOAN)
            System.out.printf("| %-20s | %-20s | %-10s | %-10s | %-10s | %-10d |\n", b.getTitle(), b.getCatalogNumber(), b.getCopyNumber(), b.getBookStatus().toString(), b.getDueDate() == null ? "": b.getDueDate().toString(), b.getPatronId() == null ? 0 : b.getPatronId());
    }
    System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");

    System.out.print("Enter catalog number: ");
    String cn = scanner.nextLine();
    System.out.print("Enter copy number: ");
    Integer copyNumber = scanner.nextInt();
    System.out.print("Enter your ID:");
    Integer patronId = scanner.nextInt();
    controller.loanBookCopy(cn,copyNumber,patronId);
}
//    private void returnBook() {
//        List<BookCopy> listBookCopy = controller.getAllBookCopy();
//        for(BookCopy b : listBookCopy) {
//            if(b.getBookStatus() == BookStatus.LOAN)
//                System.out.println(b);
//                System.out.println(" ");
//        }
//        System.out.print("Enter catalog number: ");
//        String cn = scanner.nextLine();
//        System.out.print("Enter copy number: ");
//        Integer copyNumber = scanner.nextInt();
//        System.out.println("Enter your ID:");
//        Integer patronId = scanner.nextInt();
//        controller.loanBookCopy(cn,copyNumber,patronId);
//    }
private void returnBook() {
    List<BookCopy> listBookCopy = controller.getAllBookCopy();

    System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");
    System.out.printf("| %-20s | %-20s | %-10s | %-10s | %-10s | %-10s |\n", "Book Title", "Catalog Number", "Copy Number", "Book Status", "Due Date", "Patron ID");
    System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");

    for(BookCopy b : listBookCopy) {
        if(b.getBookStatus() == BookStatus.LOAN)
            System.out.printf("| %-20s | %-20s | %-10s | %-10s | %-10s | %-10d |\n", b.getTitle(), b.getCatalogNumber(), b.getCopyNumber(), b.getBookStatus().toString(), b.getDueDate() == null ? "": b.getDueDate().toString(), b.getPatronId() == null ? 0 : b.getPatronId());
    }
    System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");

    System.out.print("Enter catalog number: ");
    String cn = scanner.nextLine();
    System.out.print("Enter copy number: ");
    Integer copyNumber = scanner.nextInt();
    System.out.print("Enter your ID:");
    Integer patronId = scanner.nextInt();
    controller.returnBookCopy(cn,copyNumber,patronId);
}
    private void cancelOrReserveBook() {
    List<BookCopy> listBookCopy = controller.getAllBookCopy();

    System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+");
    System.out.printf("| %-20s | %-20s | %-10s | %-10s |\n", "Book Title", "Catalog Number", "Copy Number", "Book Status");
    System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+");

    for(BookCopy b : listBookCopy) {
        System.out.printf("| %-20s | %-20s | %-10s | %-10s |\n", b.getTitle(), b.getCatalogNumber(), b.getCopyNumber(), b.getBookStatus().toString());
    }
    System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+");

    System.out.print("Enter catalog number: ");
    String cn = scanner.nextLine();
    System.out.print("Enter copy number: ");
    Integer copyNumber = scanner.nextInt();
    controller.cancelOrReserveBook(cn,copyNumber);
}
    private void viewBookStatus() {
    List<BookCopy> listBookCopy = controller.getAllBookCopy();

    System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");
    System.out.printf("| %-20s | %-20s | %-10s | %-10s | %-10s | %-10s |\n", "Book Title", "Catalog Number", "Copy Number", "Book Status", "Due Date", "Patron ID");
    System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");

    for(BookCopy b : listBookCopy) {
            System.out.printf("| %-20s | %-20s | %-10s | %-10s | %-10s | %-10d |\n",
                    b.getTitle(), b.getCatalogNumber(), b.getCopyNumber(), b.getBookStatus().toString(), b.getDueDate() == null ? "": b.getDueDate().toString(), b.getPatronId() == null ? 0 : b.getPatronId());
    }
    
}
}
