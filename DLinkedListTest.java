

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class DLinkedListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DLinkedListTest
{
    private DLinkedList<Integer> dLinkedL1;

    

    

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
        dLinkedL1 = new DLinkedList<Integer>();
        dLinkedL1.addFirst(12);
        dLinkedL1.addFirst(23);
        dLinkedL1.addFirst(34);
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
        dLinkedL1.addFirst(1);
        dLinkedL1.addFirst(2);
        dLinkedL1.addFirst(3);
        
        assertEquals(3, dLinkedL1.get(0));
        assertEquals(2, dLinkedL1.get(1));
        assertEquals(1, dLinkedL1.get(2));
        
    }

    @Test
    public void testAddLast()
    {
        dLinkedL1.addLast(1);
        dLinkedL1.addLast(2);
        dLinkedL1.addLast(3);
        
        assertEquals(1, dLinkedL1.get(3));
        assertEquals(2, dLinkedL1.get(4));
        assertEquals(3, dLinkedL1.get(5));
    }

    @Test
    public void testDeleteFirst()
    {
        assertEquals(34, dLinkedL1.deleteFirst());
        
        assertEquals(23, dLinkedL1.get(0));
        assertEquals(12, dLinkedL1.get(1));
        
    }

    @Test
    public void testDeleteLast()
    {
        assertEquals(12, dLinkedL1.deleteLast());
        
        assertEquals(34, dLinkedL1.get(0));
        assertEquals(23, dLinkedL1.get(1));
    }

    @Test
    public void testDeleteIndex()
    {
        assertEquals(23, dLinkedL1.delete(1));
        
        assertEquals(34, dLinkedL1.get(0));
        assertEquals(12, dLinkedL1.get(1));
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
    }

    @Test
    public void testContains()
    {
        assertTrue(dLinkedL1.contains(12));
        assertTrue(dLinkedL1.contains(23));
        assertTrue(dLinkedL1.contains(34));
        assertFalse(dLinkedL1.contains(742));
        assertFalse(dLinkedL1.contains(22));
        assertFalse(dLinkedL1.contains(33));
    }
    

    @Test
    public void testGetIndex()
    {
        assertEquals(23, dLinkedL1.get(1));
    }

    @Test
    public void testGetFirst()
    {
        assertEquals(34, dLinkedL1.getFirst());
    }

    @Test
    public void testGetLast()
    {
        assertEquals(12, dLinkedL1.getLast());
    }

    @Test
    public void testSet()
    {
        dLinkedL1.set(2, 12321);
        
        assertEquals(12321, dLinkedL1.getLast());
    }

    @Test
    public void testAddIndex()
    {
        dLinkedL1.add(45, 1);
        
        assertEquals(45, dLinkedL1.get(1));
    }

    @Test
    public void testGetFast()
    {
        dLinkedL1.clear();
        dLinkedL1.add(0);
        dLinkedL1.add(1);
        dLinkedL1.add(2);
        dLinkedL1.add(3);
        dLinkedL1.add(4);
        
        assertEquals(3, dLinkedL1.getFast(3));
        assertEquals(4, dLinkedL1.getFast(4));
    }
}











