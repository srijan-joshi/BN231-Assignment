/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university.library.system.controller;

/**
 *
 * @author User
 */


import java.time.LocalDate;
import university.library.system.model.BookTitle;
import university.library.system.model.BookCopy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import university.library.system.model.BookStatus;
import university.library.system.model.Patron;

public class NewBookController {
    private ArrayList<BookTitle> bookCollection;
    private ArrayList<BookCopy> bookCopyList;
    private ArrayList<Patron> patronList;
    private Scanner scanner;
    private Integer patronCount = 0;

    public NewBookController() {
        bookCollection = new ArrayList<>();
        bookCopyList = new ArrayList<>();
        patronList = new ArrayList<>();
        scanner = new Scanner(System.in);
//        addTestData();
    }
    
//    private void addTestData() {
//        BookTitle b = new BookTitle("SCIENCE", "RAM", "jj PUBLICATION", "11");
//        BookTitle b1 = new BookTitle("MATHS", "RAM", "jj PUBLICATION", "11");
//
//        
//        bookCollection.add(b);
//        
//    }

    

    public void addBook(BookTitle newBook) {
        bookCollection.add(newBook);
    }

    public List<BookTitle> viewBooks() {
        return bookCollection;
    }

    public void updateBook() {
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

    public void deleteBook() {
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
    
//    public void addBookCopy() {
//        
//        if(!bookCollection.isEmpty()){
//            
//        System.out.println("Book Title     Catlogue Number");
//        for (BookTitle book : bookCollection) {
//            System.out.println(book.getTitle() +"       " + book.getCatalogNumber());
//        }
//        System.out.println("Please Enter catlogue number from above book list to create a Copy.");
//        
//        
//    System.out.print("Enter the catalog number of the book to add a copy: ");
//    String catalogNumber = scanner.nextLine();
//
//    for (BookTitle book : bookCollection) {
//        if (book.getCatalogNumber().equals(catalogNumber)) {
//            int copyNumber = getNextCopyNumber(catalogNumber);
//            System.out.print("Enter edition: ");
//            int edition;
//            try {
//                edition = Integer.parseInt(scanner.nextLine());
//            } catch (NumberFormatException e) {
//                System.out.println("Invalid input for edition. Please enter a valid integer.");
//                return;
//            }
//            System.out.print("Enter publication year: ");
//            int publicationYear;
//            try {
//                publicationYear = Integer.parseInt(scanner.nextLine());
//            } catch (NumberFormatException e) {
//                System.out.println("Invalid input for publication year. Please enter a valid integer.");
//                return;
//            }
//            System.out.print("Enter ISBN: ");
//            String ISBN = scanner.nextLine();
//
//            BookCopy newCopy = new BookCopy();
//            newCopy.setTitle(book.getTitle());
//            newCopy.setAuthor(book.getAuthor());
//            newCopy.setPublisher(book.getPublisher());
//            newCopy.setCatalogNumber(catalogNumber);
//            newCopy.setCopyNumber(copyNumber);
//            newCopy.setEdition(edition);
//            newCopy.setPublicationYear(publicationYear);
//            newCopy.setISBN(ISBN);
//            newCopy.setBookStatus(BookStatus.AVA);
//            bookCopyList.add(newCopy);
//            System.out.println("Book copy added successfully.");
//            return;
//        }
//    }
//    System.out.println("Book with catalog number " + catalogNumber + " not found.");
//}
//        else{
//            System.out.println("Please add book first to add its copy");
//        }
//}
    public void addBookCopy() {
        
    if(!bookCollection.isEmpty()){
        
    System.out.println("+-----------------------+-----------------------+");
    System.out.printf("| %-20s | %-20s |\n", "Book Title", "Catalogue Number");
    System.out.println("+-----------------------+-----------------------+");

    for (BookTitle book : bookCollection) {
        System.out.printf("| %-20s | %-20s |\n", book.getTitle(), book.getCatalogNumber());
    }
    System.out.println("+-----------------------+-----------------------+");
    System.out.println("Please Enter catalogue number from above book list to create a Copy.");
        
        
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

            BookCopy newCopy = new BookCopy();
            newCopy.setTitle(book.getTitle());
            newCopy.setAuthor(book.getAuthor());
            newCopy.setPublisher(book.getPublisher());
            newCopy.setCatalogNumber(catalogNumber);
            newCopy.setCopyNumber(copyNumber);
            newCopy.setEdition(edition);
            newCopy.setPublicationYear(publicationYear);
            newCopy.setISBN(ISBN);
            newCopy.setBookStatus(BookStatus.AVA);
            bookCopyList.add(newCopy);
            System.out.println("Book copy added successfully.");
            return;
        }
    }
    System.out.println("Book with catalog number " + catalogNumber + " not found.");
}
        else{
            System.out.println("Please add book first to add its copy");
        }
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
    
    public void addPatron(Patron patron){
        patronCount++;
        patron.setId(patronCount);
        patronList.add(patron);
    }
    
   public List<Patron> getAllPatrons() {
        return patronList;
    }
   
   public List<BookCopy> getAllBookCopy(){
       return bookCopyList;
   }

    public void loanBookCopy(String catologNumber, Integer copyNumber, Integer patronId) {
        
        BookCopy bookCopy = bookCopyList.stream().
                filter(b ->(
                        copyNumber == b.getCopyNumber()
                        && 
                        catologNumber.equals(b.getCatalogNumber()))
                ).findAny().orElse(null);
        if(bookCopy != null){
            bookCopy.setBookStatus(BookStatus.LOAN);
            bookCopy.setPatronId(patronId);//null for return
            bookCopy.setDueDate(LocalDate.now().plusDays(14));
            }
            
            else{
                    System.out.println("Book details invalid!!");
                    }
    }
    public void returnBookCopy(String catologNumber, Integer copyNumber, Integer patronId) {
        
        BookCopy bookCopy = bookCopyList.stream().
                filter(b ->(
                        copyNumber == b.getCopyNumber()
                        && 
                        catologNumber.equals(b.getCatalogNumber()))
                ).findAny().orElse(null);
        if(bookCopy != null){
            bookCopy.setBookStatus(BookStatus.AVA);
            bookCopy.setPatronId(null);//null for return
            bookCopy.setDueDate(null);
            }
            
            else{
                    System.out.println("Book details invalid!!");
                    }
    }
    
    public void cancelOrReserveBook(String catalogNumber, Integer copyNumber) {
    BookCopy bookCopy = bookCopyList.stream().
            filter(b -> (
                    copyNumber == b.getCopyNumber()
                            && 
                            catalogNumber.equals(b.getCatalogNumber()))
            ).findAny().orElse(null);
    if(bookCopy != null){
        if(bookCopy.getBookStatus() == BookStatus.RES){
            bookCopy.setBookStatus(BookStatus.AVA);
        } else if(bookCopy.getBookStatus() == BookStatus.AVA){
            bookCopy.setBookStatus(BookStatus.RES);
        } else {
            System.out.println("Book is not available for reservation or cancelation.");
        }
    } else{
        System.out.println("Book details invalid!!");
    }
}
    
    
}
