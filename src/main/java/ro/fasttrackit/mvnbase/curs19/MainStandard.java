package ro.fasttrackit.mvnbase.curs19;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MainStandard {
    public static void main(String[] args) {
        arrayOperation(elem -> "element: " + elem);
        arrayOperation(elem -> elem + " hello");
        System.out.println("Pare");
        filterOperation(a -> a % 2 == 0);
        System.out.println("Impare");
        filterOperation(a -> a % 2 != 0);
        System.out.println("<3");
        filterOperation(x -> x < 3);

        consumeElements(x -> System.out.println(x));
        consumeElements(x -> System.out.println("$" + x));

        supplyString(() -> List.of("a", "b", "c"));
    }

    public static void supplyString(Supplier<List<String>> supply) {
        for (String elem : supply.get()) {
            System.out.println(elem);
        }
    }

    public static void consumeElements(Consumer<Integer> consumer) {
        int[] ints = {1, 2, 3, 4, 5};
        for (int elem : ints) {
            consumer.accept(elem);
        }
    }

    public static void arrayOperation(Function<Integer, String> transformer) {
        int[] ints = {1, 2, 3, 4, 5};
        for (int elem : ints) {
            System.out.println(transformer.apply(elem));
        }
    }

    public static void filterOperation(Predicate<Integer> filter) {
        int[] ints = {1, 2, 3, 4, 5};
        for (int elem : ints) {
            if (filter.test(elem)) {
                System.out.println(elem);
            }
        }
    }
}
