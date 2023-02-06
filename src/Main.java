import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        numbers(List.of(5,3,8,11,2,6));
        findMinMax(Stream.of(5,1,6,-8), Integer::compareTo, (min, max) -> System.out.println("Min " + min + ". Max " + max));

    }
    public static <T> void findMinMax (Stream<? extends T> stream,
                                       Comparator<? super T> order,
                                       BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<? extends T> list = stream.sorted(order).collect(Collectors.toList());
        minMaxConsumer.accept(list.get(0), list.get(list.size()- 1));
    }

    public static void numbers (List<Integer> list){
      long count = list.stream().filter(x -> x % 2 == 0).count();
        System.out.println("Количество четных чисел " + count);
    }
}