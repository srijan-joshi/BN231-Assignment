/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package university.library.system;

/**
 *
 * @author DELL
 */


public class BookTitleTest {
    public static void main(String[] args) {
        // Test default constructor
        BookTitle defaultBook = new BookTitle();
        System.out.println("Testing Default Constructor:");
        System.out.println(defaultBook);
        System.out.println();

        // Test parameterized constructor
        BookTitle specificBook = new BookTitle("Effective Java", "Joshua Bloch", "Addison-Wesley", "12345");
        System.out.println("Testing Parameterized Constructor:");
        System.out.println(specificBook);
        System.out.println();

        // Test getters and setters
        System.out.println("Testing Getters and Setters:");
        specificBook.setTitle("Clean Code");
        specificBook.setAuthor("Robert C. Martin");
        specificBook.setPublisher("Prentice Hall");
        specificBook.setCatalogNumber("67890");
        
        System.out.println("Updated Book Information:");
        System.out.println("Title: " + specificBook.getTitle());
        System.out.println("Author: " + specificBook.getAuthor());
        System.out.println("Publisher: " + specificBook.getPublisher());
        System.out.println("Catalog Number: " + specificBook.getCatalogNumber());
        System.out.println();

        // Test toString method
        System.out.println("Testing toString Method:");
        System.out.println(specificBook.toString());
    }
}
