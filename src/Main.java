import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> streamInt = new ArrayList<>(List.of(1, 5, 6, 7, 23, 85, 12, 14, 16));
        Stream<Integer> stream = streamInt.stream();
        task1(stream, Integer::compareTo, (m, n) -> System.out.println("Min value is:" + m + " Max value is: " + n));
        task2();
    }

    public static <T> void task1(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer) {
        System.out.println("Task 1: ");
        List<T> list = stream.sorted().collect(Collectors.toList());
        if (!list.isEmpty()) {
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    public static void task2() {
        System.out.println("Task 2: ");
        Predicate<Integer> predicate = (e) -> (e % 2) == 0;
        List<Integer> resStream = Stream.of(1, 5, 6, 7, 23, 85, 12, 14, 16)
                .filter(predicate).collect(Collectors.toList());
        resStream.forEach(e -> System.out.print(e + " "));
        System.out.println("\nCount of even values is : " + resStream.stream().count());
    }
}