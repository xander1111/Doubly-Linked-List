

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class NodeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NodeTest
{
    private Node<Integer> node1;
    private Node<Integer> node2;
    private Node<Integer> node3;

    

    /**
     * Default constructor for test class NodeTest
     */
    public NodeTest()
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
        node1 = new Node<Integer>(12);
        node2 = new Node<Integer>(23);
        node3 = new Node<Integer>(34);
        
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node1);
        
        node1.setPrev(node3);
        node2.setPrev(node1);
        node3.setPrev(node2);
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
    public void testGetNext()
    {
        assertEquals(node1.getNext(), node2);
        assertEquals(node2.getNext(), node3);
        assertEquals(node3.getNext(), node1);
    }
    
    @Test
    public void testGetPrev()
    {
        assertEquals(node1.getPrev(), node3);
        assertEquals(node2.getPrev(), node1);
        assertEquals(node3.getPrev(), node2);
    }
    
    @Test
    public void testSetNext()
    {
        node1.setNext(node3);
        node2.setNext(node1);
        node3.setNext(node2);
        
        assertEquals(node1.getNext(), node3);
        assertEquals(node2.getNext(), node1);
        assertEquals(node3.getNext(), node2);
    }
    
    @Test
    public void testSetPrev()
    {
        node1.setPrev(node2);
        node2.setPrev(node3);
        node3.setPrev(node1);
        
        assertEquals(node1.getPrev(), node2);
        assertEquals(node2.getPrev(), node3);
        assertEquals(node3.getPrev(), node1);
    }
    
    @Test
    public void testData()
    {  
        assertEquals(node1.getData(), 12);
        assertEquals(node2.getData(), 23);
        assertEquals(node3.getData(), 34);
    }
    
    @Test
    public void testClear()
    {
        node1.clear();
        node2.clear();
        node3.clear();
        
        assertEquals(node1.getPrev(), null);
        assertEquals(node2.getPrev(), null);
        assertEquals(node3.getPrev(), null);
        assertEquals(node1.getNext(), null);
        assertEquals(node2.getNext(), null);
        assertEquals(node3.getNext(), null);
        assertEquals(node1.getData(), null);
        assertEquals(node2.getData(), null);
        assertEquals(node3.getData(), null);
    }

    @Test
    public void testSetData()
    {
        node1.setData(11111);
        node2.setData(22222);
        node3.setData(33333);
        
        assertEquals(11111, node1.getData());
        assertEquals(22222, node2.getData());
        assertEquals(33333, node3.getData());
    }
}


    
