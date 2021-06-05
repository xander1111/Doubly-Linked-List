import java.util.regex.*;

public class Person //implements Comparable<Person>
{
    private String firstName;
    private String lastName;
    private String id;

    /**
     * Constructor for objects of class Person
     */
    public Person(String firstName, String lastName, String id) throws InvalidIDException
    {
        String idRegex = "\\b\\d{9,9}\\b";

        if (!Pattern.matches(idRegex, id)) {
            throw new InvalidIDException("ID must be a String of 9 digits");  
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getId()
    {
        return id;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Person)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        else {
            Person other = ( Person ) obj;
            boolean sameFirstName = other.getFirstName().equals(this.getFirstName());
            boolean sameLastName = other.getLastName().equals(this.getLastName());
            boolean sameID = other.getId().equals(this.getId());

            if (!sameFirstName || !sameLastName || !sameID) {
                return false;
            }
        }

        return true;
    }

    /*@Override
    public int compareTo(Person o) {
        int result;
        result = firstName.compareTo(o.firstName);

        if (result == 0) { // If they have the same first name
            result = lastName.compareTo(o.lastName);
        }

        if (result == 0) { // If they have the same first and last name
            result = id.compareTo(o.id);
        }

        return result;
    }*/
}
