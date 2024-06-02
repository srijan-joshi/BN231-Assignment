/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university.library.system.model;

import java.time.LocalDate;
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
	private BookStatus bookStatus;
	private LocalDate dueDate;
        private Integer patronId;

    public Integer getPatronId() {
        return patronId;
    }

    public void setPatronId(Integer patronId) {
        this.patronId = patronId;
    }

	// Constructor
	public BookCopy(String title, String author, String publisher, String catalogNumber, int copyNumber,
                BookStatus bookStatus,
                int edition, int publicationYear, String ISBN, LocalDate dueDate) {
		super(title, author, publisher, catalogNumber);
		this.copyNumber = copyNumber;
		this.edition = edition;
		this.publicationYear = publicationYear;
		this.ISBN = ISBN;
		this.bookStatus = bookStatus;
		this.dueDate = dueDate;
	}

    public BookCopy() {
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

	public BookStatus getBookStatus() {
		return bookStatus;
	}

	public LocalDate getDueDate() {
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

	public void setBookStatus(BookStatus bookStatus) {
		this.bookStatus = bookStatus;
	}

	public void setDueDate(LocalDate dueDate) {
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
				", bookStatus='" + String.valueOf(bookStatus) + '\'' +
				", dueDate=" + dueDate + " patronId:  " + patronId  +
				'}';
	}
}
