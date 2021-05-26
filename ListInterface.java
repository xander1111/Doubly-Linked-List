public interface ListInterface<E>
{
    void add(E item);

    void add(E item, int index);

    void addFirst(E item);

    void addLast(E item);

    E delete(int index);

    E deleteFirst();

    E deleteLast();

    void clear();

    E get(int index);

    E getFirst();

    E getLast();

    void set(int index, E item);

    boolean contains(E item);

    int size();
}
