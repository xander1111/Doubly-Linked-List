

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DLinkedListTest
{
    private DLinkedList<Person> dLinkedL1;
    private Person person1, person2, person3, person4, person5, person6;
    

    

    /**
     * Default constructor for test class DLinkedListTest
     */
    public DLinkedListTest()
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
        dLinkedL1 = new DLinkedList<>();
        person1 = person2 = person3 = null;

        try {
            person1 = new Person("firstName1", "lastName1", "000000001");
            person2 = new Person("firstName2", "lastName2", "000000002");
            person3 = new Person("firstName3", "lastName3", "000000003");
            person4 = new Person("firstName4", "lastName4", "000000004");
            person5 = new Person("firstName5", "lastName5", "000000005");
            person6 = new Person("firstName6", "lastName6", "000000006");
        } catch (Exception e) {
            System.out.println(e);
        }

        dLinkedL1.addFirst(person1);
        dLinkedL1.addFirst(person2);
        dLinkedL1.addFirst(person3);
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
    public void testAddFirst()
    {
        dLinkedL1.addFirst(person4);
        dLinkedL1.addFirst(person5);
        dLinkedL1.addFirst(person6);
        
        assertEquals(person6, dLinkedL1.getFast(0));
        assertEquals(person5, dLinkedL1.getFast(1));
        assertEquals(person4, dLinkedL1.getFast(2));
        
        assertEquals(6, dLinkedL1.size());
    }

    @Test
    public void testAddLast()
    {
        dLinkedL1.addLast(person4);
        dLinkedL1.addLast(person5);
        dLinkedL1.addLast(person6);
        
        assertEquals(person4, dLinkedL1.getFast(3));
        assertEquals(person5, dLinkedL1.getFast(4));
        assertEquals(person6, dLinkedL1.getFast(5));
        
        assertEquals(6, dLinkedL1.size());
    }

    @Test
    public void testDeleteFirst()
    {
        assertEquals(person3, dLinkedL1.deleteFirst());
        
        assertEquals(person2, dLinkedL1.getFast(0));
        assertEquals(person1, dLinkedL1.getFast(1));
        
        assertEquals(2, dLinkedL1.size());
        
    }

    @Test
    public void testDeleteLast()
    {
        assertEquals(person1, dLinkedL1.deleteLast());
        
        assertEquals(person3, dLinkedL1.getFast(0));
        assertEquals(person2, dLinkedL1.getFast(1));
        
        assertEquals(2, dLinkedL1.size());
    }

    @Test
    public void testDeleteIndex()
    {
        assertEquals(person2, dLinkedL1.delete(1));
        
        assertEquals(person3, dLinkedL1.getFast(0));
        assertEquals(person1, dLinkedL1.getFast(1));
        
        assertEquals(2, dLinkedL1.size());
    }

    @Test
    public void testSize()
    {
        assertEquals(3, dLinkedL1.size());
    }

    @Test
    public void testClear()
    {
        dLinkedL1.clear();
        
        assertEquals(0, dLinkedL1.size());

        try {
            dLinkedL1.getFast(0);
        } catch (IndexOutOfBoundsException e) {
            return;
        }
        fail("The list didn't throw an error when trying to access the first item");
    }

    @Test
    public void testContains()
    {
        assertTrue(dLinkedL1.contains(person1));
        assertTrue(dLinkedL1.contains(person2));
        assertTrue(dLinkedL1.contains(person3));
        assertFalse(dLinkedL1.contains(person4));
        assertFalse(dLinkedL1.contains(person5));
        assertFalse(dLinkedL1.contains(person6));
    }
    

    @Test
    @SuppressWarnings("deprecation")
    public void testGetIndex()
    {
        assertEquals(person2, dLinkedL1.get(1));
    }

    @Test
    public void testGetFirst()
    {
        assertEquals(person3, dLinkedL1.getFirst());
    }

    @Test
    public void testGetLast()
    {
        assertEquals(person1, dLinkedL1.getLast());
    }

    @Test
    public void testSet()
    {
        dLinkedL1.set(2, person4);
        
        assertEquals(person4, dLinkedL1.getLast());
    }

    @Test
    public void testAddIndex()
    {
        dLinkedL1.add(person4, 1);
        
        assertEquals(person4, dLinkedL1.getFast(1));
    }

    @Test
    public void testGetFast()
    {
        dLinkedL1.clear();
        dLinkedL1.add(person1);
        dLinkedL1.add(person2);
        dLinkedL1.add(person3);
        dLinkedL1.add(person4);
        dLinkedL1.add(person5);
        dLinkedL1.add(person6);
        
        assertEquals(person3, dLinkedL1.getFast(2));
        assertEquals(person5, dLinkedL1.getFast(4));
    }
}











