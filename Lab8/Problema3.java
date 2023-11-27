package Lab8;

import java.text.CollationElementIterator;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problema3 {
    public static void main(String[] args)
    {
        List<Integer> numbers = List.of(6, 3, 7, 1, 2, 8, 4, 9);

        List<Integer> sortedAsc = sortList(numbers, true);
            System.out.println("Sortat Crescator: " +sortedAsc);
        List<Integer> sortedDesc = sortList(numbers, true);
            System.out.println("Sortat Descrescator: " +sortedDesc);
    }

    public static <T extends Comparable<T>> List<T> sortList(List<T> list, boolean ascending) {
        return list.stream()
                .sorted(ascending ? Comparator.naturalOrder() :
                                    Comparator.reverseOrder())
        .collect(Collectors.toList());
    }
}
