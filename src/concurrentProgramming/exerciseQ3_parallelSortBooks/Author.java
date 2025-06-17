package concurrentProgramming.exerciseQ3_parallelSortBooks;

/* @author Yvan Pannatier */

/**
 * Simple class representing a book author. It implements Comparable to be able to define
 * how to compare two authors. Please have a look at the compareTo method below.
 */
public class Author implements Comparable<Author>{

    private String firstname;
    private String lastname;

    public Author(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public int compareTo(Author o) {
        int firstnameComparisonResult = this.getFirstname().compareTo(o.getFirstname());

        if(firstnameComparisonResult != 0)
        {
            return firstnameComparisonResult;
        }

        return this.getLastname().compareTo(o.getLastname());
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }

}
