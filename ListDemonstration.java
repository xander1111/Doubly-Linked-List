import java.nio.file.*;
import java.util.*;

public class ListDemonstration
{
    public static void main(String[] args) throws Exception {
        String filename = "demonstration.txt";

        ArrayList<Person> personList = new ArrayList<>();

        try (Scanner scanner = new Scanner(Paths.get(filename).toAbsolutePath())) {
            while (scanner.hasNext()) {
                String firstName = scanner.next();
                String lastName = scanner.next();
                String id = scanner.next();

                personList.add(new Person(firstName, lastName, id));
            }
        } 
        catch (Exception e) {
            throw e;
        }

        DLinkedList<Person> linkedList = new DLinkedList<>();

        linkedList.addLast(personList.get(1));
        linkedList.addFirst(personList.get(2));
        linkedList.add(personList.get(3), 1);

        linkedList.delete(1);
        linkedList.deleteFirst();

        System.out.println(linkedList.getFirst().getFirstName()); 

        linkedList.clear();

        linkedList.addFirst(personList.get(2));
        linkedList.addFirst(personList.get(1));

        linkedList.set(1, personList.get(3));

        System.out.println(linkedList.contains(personList.get(1)));
        System.out.println(linkedList.contains(personList.get(2)));
        System.out.println(linkedList.contains(personList.get(3)));
        System.out.println(linkedList.size());
    }
}
