/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university.library.system;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class BookCopy extends BookTitle {
	private int copyNumber;
	private int edition;
	private int publicationYear;
	private String ISBN;
	private String bookStatus;
	private Date dueDate;

	// Constructor
	public BookCopy(String title, String author, String publisher, String catalogNumber, int copyNumber, int edition, int publicationYear, String ISBN, String bookStatus, Date dueDate) {
		super(title, author, publisher, catalogNumber);
		this.copyNumber = copyNumber;
		this.edition = edition;
		this.publicationYear = publicationYear;
		this.ISBN = ISBN;
		this.bookStatus = bookStatus;
		this.dueDate = dueDate;
	}

	// Getters
	public int getCopyNumber() {
		return copyNumber;
	}

	public int getEdition() {
		return edition;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public String getISBN() {
		return ISBN;
	}

	public String getBookStatus() {
		return bookStatus;
	}

	public Date getDueDate() {
		return dueDate;
	}

	// Setters
	public void setCopyNumber(int copyNumber) {
		this.copyNumber = copyNumber;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	// Override toString method
	@Override
	public String toString() {
		return super.toString()+
				"copyNumber=" + copyNumber +
				", edition=" + edition +
				", publicationYear=" + publicationYear +
				", ISBN='" + ISBN + '\'' +
				", bookStatus='" + bookStatus + '\'' +
				", dueDate=" + dueDate +
				'}';
	}
}
