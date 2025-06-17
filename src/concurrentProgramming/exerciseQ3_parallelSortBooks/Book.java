package concurrentProgramming.exerciseQ3_parallelSortBooks;

/* @author Yvan Pannatier */

/**
 * Simple class representing a book. It implements Comparable to be able to define
 * how to compare two books. Please have a look at the compareTo method below.
 */
public class Book implements Comparable<Book>{
    private long isbn;
    private Author author;
    private int year;
    private String title;

    public Book(long isbn, Author author, int year, String title) {
        this.isbn = isbn;
        this.author = author;
        this.year = year;
        this.title = title;
    }

    @Override
    public int compareTo(Book o) {

        int titleComparisonResult = this.getTitle().compareTo(o.getTitle());
        if(titleComparisonResult != 0) {
            return titleComparisonResult;
        }

        int authorComparisonResult = this.getAuthor().compareTo(o.getAuthor());
        if(authorComparisonResult != 0) {
            return authorComparisonResult;
        }

        int yearComparisonResult = this.getYear() - o.getYear();
        if(yearComparisonResult != 0) {
            return yearComparisonResult;
        }

        long isbnComparisonResult = this.getIsbn() - o.getIsbn();
        if(isbnComparisonResult != 0) {
            return isbnComparisonResult < 0 ? -1 : 1;
        }
        return 0;
    }

    public long getIsbn() {
        return isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + " from " + author.getFirstname() + " " + author.getLastname() + " published in " + year + " with ISBN: " + isbn;
    }

}
