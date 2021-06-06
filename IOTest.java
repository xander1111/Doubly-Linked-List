import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class IOTest {
    public static void main(String[] args) {
        DLinkedList<Integer> testList = new DLinkedList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("IO.txt"))) {
            List<Integer> ints = reader.lines()
                .map(s -> s.trim())
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

            ints.forEach(num -> testList.add(num * 2));

            //testList.forEach(System.out::println);
            Iterator<Integer> it = testList.iterator();
            Integer num = it.next();
            while (it.hasNext()) {
                System.out.println(num / 2);
                num = it.next();
            }
        } 
        catch (IOException e) {
            System.err.println("Something went wrong while reading the file:");
            System.err.println(e);
        }
    }
}
