import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

public class DLinkedList<E> implements ListInterface<E>, Iterable<E>
{
    // The first Node in the list.
    private Node<E> first;
    // The last Node in the list.
    private Node<E> last;
    // The amount of Nodes in the list.
    private int size;

    /**
     * Constructs an empty list.
     */
    public DLinkedList()
    {
        first = null;
        size = 0;
    }

    /**
     * Adds an item at the end of the list.
     */
    @Override
    public void add(E e)
    {
        addLast(e);
    }
    
    /**
     * Adds an item at the start of the list.
     */
    @Override
    public void addFirst(E item)
    {
        add(item, 0);
    }

    /**
     * Adds an item at the end of the list.
     */
    @Override
    public void addLast(E item)
    {
        add(item, size());
    }

    /**
     * Adds an item at the specified index.
     */
    @Override
    public void add(E item, int index) 
    {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index +  " out of bounds for size " + size());
        }

        Node<E> shiftNode = null; // The node that will be after the new node in the list.
        Node<E> prevNode = null; // The node that comes before the new node in the list.
        Node<E> newNode = new Node<E>(item);

        if (size() == 0 && index == 0) { // If the list is empty and we are requesting to add at the start, don't assign values to shiftNode and prevNode.
            shiftNode = null;
            prevNode = null;
        }
        else if (index == size()) { // If adding to the end of the list, the shiftNode will also be null
            shiftNode = null;
            prevNode = getNode(index - 1, true);
        }
        else {
            shiftNode = getNode(index, true); 
            prevNode = shiftNode.getPrev();
        }
        
        if (size() != 0) { // If this isn't the first item added, first item passes over and simply get assigned to first and last.
            if (shiftNode != null) shiftNode.setPrev(newNode);
            prevNode.setNext(newNode);

            newNode.setNext(shiftNode);
            newNode.setPrev(prevNode);
        }

        // If inserting at the start of the list
        if (index == 0) first = newNode; 

        // If inserting at the end of the list, note that this isnt an else if because the first item inserted would be both.
        if (index == size()) last = newNode; 

        // Ensure the first and last fields are set correctly, even if they didn't change.
        if (first != null) first.setPrev(last);
        if (last != null) last.setNext(first);

        size++;
    }

    /**
     * Returns the number of items in the list.
     */
    @Override
    public int size()
    {
        return size;
    }

    /**
     * Removes the item at the specified index.
     * @return The item that was removed.
     */
    @Override
    public E delete(int index)
    {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index +  " out of bounds for size " + size());
        }
        
        Node<E> toDelete = getNode(index, true);
        Node<E> prevNode = toDelete.getPrev();
        Node<E> nextNode = toDelete.getNext();
        E data = toDelete.getData();

        if (index == 0) { // If removing the first or last item, make sure to assign first/last to the new first/last Node.
            first = nextNode;
        }
        else if (index == size() - 1) {
            last = prevNode;
        }

        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);

        toDelete.clear();

        size--;
        return data;
    }

    /**
     * Removes the first item in the list.
     * @return The first item.
     */
    @Override
    public E deleteFirst()
    {
        return delete(0);
    }

    /**
     * Removes the last item in the list.
     * @return The last item in the list.
     */
    @Override
    public E deleteLast()
    {
        return delete(size() - 1);
    }

    /**
     * Removes all items from the list.
     */
    @Override
    public void clear() 
    {
        // I looked at the implementation of LinkedList as I wasn't sure if i 
        // needed to clear all the nodes. There was a comment saying it's not 
        // required but is still usefull.

        Node<E> currentNode = first;
        while (currentNode != null) {
            Node<E> nextNode = currentNode.getNext();
            currentNode.clear();
            currentNode = nextNode;
        }

        first = null;
        size = 0;
    }

    /**
     * Gets the item at a specified index.
     * @deprecated Use the {@code getFast(int index)} method instead.
     */
    @Override
    @Deprecated 
    public E get(int index)
    {
        return getNode(index, false).getData();
    }

    /**
     * Gets the item at a specified index.
     */
    public E getFast(int index)
    {
        return getNode(index, true).getData();
    }

    /**
     * Gets the first item in the list.
     */
    @Override
    public E getFirst() {
        return first.getData();
    }

    /**
     * Gets the last item in the list.
     */
    @Override
    public E getLast() {
        return last.getData();
    }

    /**
     * Sets a specified items value.
     * @param index The index of the item to set.
     * @param value The new value.
     */
    @Override
    public void set(int index, E value)
    {
        Node<E> toChange = getNode(index, true);
        toChange.setData(value);
    }

    /**
     * Returns true if and only if this list has an item that {@code .equals()} {@code item},
     * or if {@code item} is null, returns true if this list contains a null element.
     */
    @Override
    public boolean contains(E item)
    {
        if (item == null) { // If item is null, check for a null element.
            for (int i = 0; i < size; i++) {
                if (get(i) == null) return true;
            } 
        }
        else { // If item is not null, check for .equals()
            for (int i = 0; i < size; i++) {
                if (item.equals(get(i))) return true;
            } 
        }

        return false;
    }    

    /**
     * Gets the node at a specified index.
     */
    private Node<E> getNode(int index, boolean fastMode)
    {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index +  " out of bounds for size " + size());
        }

        if (fastMode && index > size() / 2.0 ) { // fastMode will go from the back of the list if it would be faster.
            Node<E> tmp = last;
            int backIndex = size() - 1 - index; // Max index - index = how many from the back needed to go.

            for (int i = 0; i < backIndex; i++) {
                tmp = tmp.getPrev();
            }

            return tmp;
        }
        else {
            Node<E> tmp = first;

            for (int i = 0; i < index; i++) {
                tmp = tmp.getNext();
            }

            return tmp;
        }
    }
    
    /**
     * Provides a string of each item with a space inbetween.
     * @return A string with each items toString seperated by a space.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> tmp = first;
        while (tmp != null) {
            sb.append(tmp.getData() + " ");
            tmp = tmp.getNext();
        }

        return sb.toString().strip();
    }

    /**
     * Returns an iterator of each element in this list in order.
     */
    @Override
    public Iterator<E> iterator()
    {
        return new Iterator<E>(){
            private Node<E> next = first;
            private boolean usedNext = false;

            public boolean hasNext()
            {
                return next != null && (next != first || !usedNext);
            }

            public E next()
            {
                E data = next.getData();
                next = next.getNext();
                usedNext = true;
                return data;
            }
        };
    }

    /**
     * Preforms the given action on every item in the list in order of index.
     */
    public void forEach(Consumer<? super E> action)
    {
        Objects.requireNonNull(action);
        Node<E> current = first;
        for (int i = 0; i < size(); i++) {
            action.accept(current.getData());
            current = current.getNext();
        }
    }
}
