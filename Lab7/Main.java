package Lab7;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        problema1_var1();

    } // calculati media aritmetica a numerelor intregi dintr-o lista
    public static void problema1_var1() {
        List<Integer> numereIntregi = Arrays.asList(3, 6, 8, 43, 65, 23, 76);
        AtomicReference<Integer> sum = new AtomicReference<>(0);

        numereIntregi.forEach(n -> sum.set(sum.get() + n));

        System.out.println(sum.get() / numereIntregi.size());
    }

    public static void  problema1_var2() {
        List<Integer> numereIntregi = Arrays.asList(3, 6, 8, 43, 65, 23, 76);

        double v = numereIntregi.stream()
                .mapToDouble(i -> i.doubleValue())
                .average()
                .orElse(0.0);
        System.out.println(v);
    }


    public static void problema2_var1() {
        List<String> lista = Arrays.asList("mere", "pere", "banane", "struguri");
        lista.forEach(s -> {
            lista.set(lista.indexOf(s), s.toUpperCase());
        });
        System.out.println(lista);
    }

    public static void problema2_var2() {
        List<String> lista = Arrays.asList("mere", "pere", "banane", "struguri");
        lista = lista.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(lista);

    }
}
