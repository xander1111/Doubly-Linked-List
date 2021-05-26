public class Node<E>
{
    private E data;
    private Node<E> next;
    private Node<E> prev;

    /**
     * Constructs a Node containing the specified data.
     */
    public Node(E data)
    {
        this.data = data;
        next = null;
        prev = null;
    }

    /**
     * Returns the data held in this Node.
     */
    public E getData() {
        return data;
    }

    /**
     * Gets the next Node in the list.
     */
    public Node<E> getNext() {
        return next;
    }

    /**
     * Gets the previous Node in the list.
     */
    public Node<E> getPrev() {
        return prev;
    }

    /**
     * Sets the next Node in the list.
     */
    public void setNext(Node<E> node) {
        next = node;
    }

    /**
     * Gets the previous Node in the list.
     */
    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    /**
     * Clears all instance fields.
     */
    public void clear()
    {
        data = null;
        next = null;
        prev = null;
    }

    /**
     * Sets this nodes data.
     */
    public void setData(E data)
    {
        this.data = data;
    }
}
