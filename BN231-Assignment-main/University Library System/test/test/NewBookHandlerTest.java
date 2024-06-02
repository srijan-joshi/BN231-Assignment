/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import university.library.system.controller.NewBookController;
import university.library.system.model.BookCopy;
import university.library.system.model.BookStatus;
import university.library.system.model.BookTitle;

/**
 *
 * @author DELL
 */
public class NewBookHandlerTest {
    @Test
    public void testAddBook() {
    NewBookController controller = new NewBookController();
    BookTitle book = new BookTitle("Test Book", "Author", "Publisher", "1234");
    controller.addBook(book);
    assertEquals(1, controller.viewBooks().size());
    assertEquals("Test Book", controller.viewBooks().get(0).getTitle());
}
    
    @Test
    public void testLoanBook() {
    NewBookController controller = new NewBookController();
    BookTitle book = new BookTitle("Test Book", "Author", "Publisher", "1234");
    controller.addBook(book);
    BookCopy bookCopy = controller.getAllBookCopy().get(0);
    controller.loanBookCopy(bookCopy.getCatalogNumber(), bookCopy.getCopyNumber(), 1);
    assertEquals(BookStatus.LOAN, bookCopy.getBookStatus());
}
    @Test
    public void testReturnBook() {
    NewBookController controller = new NewBookController();
    BookTitle book = new BookTitle("Test Book", "Author", "Publisher", "1234");
    controller.addBook(book);
    BookCopy bookCopy = controller.getAllBookCopy().get(0);
    controller.loanBookCopy(bookCopy.getCatalogNumber(), bookCopy.getCopyNumber(), 1);
    controller.returnBookCopy(bookCopy.getCatalogNumber(), bookCopy.getCopyNumber(), 1);
    assertEquals(BookStatus.AVA, bookCopy.getBookStatus());
}
}
