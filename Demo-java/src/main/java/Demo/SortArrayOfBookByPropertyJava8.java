package Demo;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @see https://code.i-harness.com/fr/q/bdf7e6
 * @see https://www.baeldung.com/java-8-comparator-comparing
 * @author dell
 */
public class SortArrayOfBookByPropertyJava8 {
    public static void main(String[] args) {
	Library1 library = new Library1(new Book1[] { new Book1("1984", 123), new Book1("I, Robot", 152),
		new Book1("Harry Potter and the Philosopher's Stone", 267),
		new Book1("Harry Potter and the Goblet of Fire", 759), new Book1("The Bible", 1623) });

	library.sortAscTitle();
	System.out.println(Arrays.toString(library.getBooks()));

	library.sortDescPageNumber();
	System.out.println(Arrays.toString(library.getBooks()));
    }
}

class Book1 {
    String title;
    int pageNumber;

    public Book1(String title, int pageNumber) {
	this.title = title;
	this.pageNumber = pageNumber;
    }

    String getTitle() {
	return title;
    }

    int getPageNumber() {
	return pageNumber;
    }

    public String toString() {
	return "(" + title + ", " + pageNumber + " pages)";
    }
}

class Library1 {

    private Book1[] books;

    public Library1(Book1[] books) {
	this.books = books;
    }

    public Book1[] getBooks() {
	return books;
    }

    public void sortAscTitle() {
	Arrays.sort(books, Comparator.comparing(Book1::getTitle));
    }

    public void sortDescPageNumber() {
	Arrays.sort(books, Comparator.comparing(Book1::getPageNumber, (s1, s2) -> {
	    return s2.compareTo(s1);
	}));
    }

}