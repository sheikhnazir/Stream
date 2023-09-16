import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class streamMain1 {
    public static void main(String[] args) {

        // CREATING STREAM
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream = Arrays.stream(arr);
        stream = Stream.of("a", "b", "c");

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

        //Now using Stream to print numbers greater than 100
        List<Integer> integerList = list.stream().filter(i -> i>100).collect(Collectors.toList());
        System.out.println(integerList);

        //Array, Object and Collection, Using forEach loop on stream1 to access each element...
        String []names = {"shiekh", "Nauman", "Sahil", "Imran", "Gabru"};

        Stream<String> stream1 = Stream.of(names);
        stream1.forEach(e-> {
            System.out.println(e);
        });

        //We should use the empty() method in case of the creation of an empty stream:
        Stream<String> emptyStream = Stream.empty();
        //  We often use the empty() method upon creation to avoid returning null for streams with no element:


//         Stream of Collection
//        We can also create a stream of any type of Collection (Collection, List, Set):

        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();

        //An array can also be the source of a stream:
        //We can also create a stream out of an existing array or of part of an array:

        String[] arr3 = new String[]{"a", "b", "c", "ga", "gb", "hc"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
        System.out.println("Full Array:");
        streamOfArrayFull.forEach(System.out::println);

        System.out.println("Partial Array:");
        streamOfArrayPart.forEach(System.out::println);

        // STREAM BUILDER
        Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();
        List<String> list2 = streamBuilder.collect(Collectors.toList());
        System.out.println(list2);
        for (String str : list2) {
            System.out.print(str+" ");
        }

        //STREAM.GENERATE :-> The code BELOW creates a sequence of 10 strings with the value “BACKEND-|DEVELOPER.”
        Stream<String> streamGenerated = Stream.generate(() -> "BACKEND DEVELOPER").limit(10);
        List<String> stringList = streamGenerated.collect(Collectors.toList());
        System.out.println(stringList);

        //STREAM PIPELINE :-> Intermediate operations return a new modified stream as- learn more about this method
        Stream<String> modifiedStream = Stream.of("abcd", "bbcd", "cbcd").skip(1);
        List<String> modifiedList = modifiedStream.collect(Collectors.toList());
        System.out.println(modifiedList);


//        Stream<String> twiceModifiedStream =
//                Stream.skip(1).map(element -> element.Substring(0, 3));

        //THE REDUCED METHOD
        OptionalInt reduced = IntStream.range(1, 4).reduce((a, b) -> a+b);
        System.out.println(reduced);  // (1 + 2+ 3) = 6

        //We can also do in this way to include some another element
        int reduced2 = IntStream.range(1, 5). reduce(10, (a,b) -> a+b);
        System.out.println(reduced2);  //  (10 + 1 + 2 + 3 + 4) = 20

//        int reducedParams = Stream.of(1, 2, 3)
//                .reduce(10, (a, b) -> a + b, (a, b) -> {
//                    log.info("combiner was called");
//                    return a + b;
//                });

        //PARALLEL STREAMS
        //MAP FUNCTION :-. It applies a given function to each element of the stream and
        //                 returns a new stream containing the results of the function.

        List<Integer> numbers = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10);
        List<Integer> doubleNumbers = numbers.stream().map(n -> n*2).collect(Collectors.toList());
        System.out.println("The original numbers are : " + numbers);
        System.out.println("The doubled numbers are : " + doubleNumbers);

        //MATCHING FUNCTION :- Matching Stream API gives a handy set of instruments to validate elements of a
        //                     sequence according to some predicate. To do this, one of the following methods can be
        //                     used: anyMatch(), allMatch(), noneMatch().



        // Create a list of numbers
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 11);

        // Example of allMatch() , THIS WILL RETURN BOOLEAN WHETHER ALL ELEMENTS ARE EVEN IF YES THAN TRUE RETURN ELSE FALSE

        boolean allEven = numbers.stream().allMatch(n -> n % 2 == 0);
        System.out.println("All numbers are even: " + allEven);

        // Example of anyMatch()
        boolean anyEven = numbers.stream().anyMatch(n -> n % 2 == 0);
        System.out.println("Any number is even: " + anyEven);

        // Example of noneMatch()
        boolean noneNegative = numbers.stream().noneMatch(n -> n < 0);
        System.out.println("None of the numbers are negative: " + noneNegative);

        //Example of noneGreaterThan10
        boolean noneGreaterTen = numbers1.stream().noneMatch(n -> n>10);
        System.out.println("None of the numbers are greater than 10 : " + noneGreaterTen);


    }
}
