public class ListDemonstration
{
    public static void main(String[] args) throws Exception {
        Person person1, person2, person3;
        person1 = person2 = person3 = null;

        try {
            person1 = new Person("firstName1", "lastName1", "000000001");
            person2 = new Person("firstName2", "lastName2", "000000002");
            person3 = new Person("firstName3", "lastName3", "000000003");
        } catch (InvalidIDException e) {
            System.err.println("And invalid ID was used when creating the Persons");
        }

        DLinkedList<Person> linkedList = new DLinkedList<>();

        linkedList.addLast(person1);
        linkedList.addFirst(person2);
        linkedList.add(person3, 1);

        linkedList.delete(1);
        linkedList.deleteFirst();

        System.out.println(linkedList.getFirst().getFirstName()); 

        linkedList.clear();

        linkedList.addFirst(person2);
        linkedList.addFirst(person1);

        linkedList.set(1, person3);

        System.out.println(linkedList.contains(person1));
        System.out.println(linkedList.contains(person2));
        System.out.println(linkedList.contains(person3));
        System.out.println(linkedList.size());
    }
}
