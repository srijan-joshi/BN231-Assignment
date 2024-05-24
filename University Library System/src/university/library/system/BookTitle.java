/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university.library.system;

/**
 *
 * @author DELL
 */
public class BookTitle {
    private String title;
    private String author;
    private String publisher;
    private String catalogNumber;

    // Default constructor
    public BookTitle() {
        this.title = "";
        this.author = "";
        this.publisher = "";
        this.catalogNumber = "";
    }
    
    // General Constructor
    public BookTitle(String title, String author, String publisher, String catalogNumber) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.catalogNumber = catalogNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(String catalogNumber) {
        this.catalogNumber = catalogNumber;
    }
    
    @Override
    public String toString() {
        return "Title: " + title + "\nAuthor: " + author + "\nPublisher: " + publisher + "\nCatalog Number: " + catalogNumber;
    }
}
