import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streamMain1 {
    public static void main(String[] args) {

        List<Integer> list = List.of(2, 4, 3, 53, 54 ,22, 556, 22); // Unmodifiable Type list

        ArrayList<Integer> list1 = new ArrayList<>();

        list1.add(2);
        list1.add(3);
        list1.add(5);
        list1.add(22);
        list1.add(988);

        //Old Way ---> Without Stream
        List<Integer> even = new ArrayList<>();
        for (int el : list) {
            if (el%2 == 0) {
                even.add(el);
            }
        }
        System.out.println(list);
        System.out.println(even);

        // Now Using Stream to print even numbers
        //STREAM IS AN INTERFACE
        // Stream <- ctrl+enter on this to check all the methods inside the stream interface
        List<Integer> streamedList =list.stream().filter(i -> i%2 == 0).collect(Collectors.toList());
        System.out.println(streamedList);

        //Now using Stream to print Odd Numbers
        List<Integer> oddNumbers = list.stream().filter(i -> i%2 == 1).collect(Collectors.toList());
        System.out.println(oddNumbers);

        //Now using Stream to print numbers greater than 10
        List<Integer> integerList = list.stream().filter(i -> i>100).collect(Collectors.toList());
        System.out.println(integerList);
    }
}
