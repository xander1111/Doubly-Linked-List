

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest
{
    /**
     * Default constructor for test class PersonTest
     */
    public PersonTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testFields()
    {   
        Person person1 = null;
        try {
            person1 = new Person("First Name", "Last Name", "123456789");
        }
        catch (InvalidIDException e) {
            fail("The person object could not be created");
        }
        
        assertEquals("First Name", person1.getFirstName());
        assertEquals("Last Name", person1.getLastName());
        assertEquals("123456789", person1.getId());
    }

    @Test
    public void testIdFail()
    {
        Person person1 = null;
        try {
            person1 = new Person("First Name", "Last Name", "123");
        }
        catch (InvalidIDException e) {
            return;
        }
        fail("The method didn't throw an error");
    }
}


