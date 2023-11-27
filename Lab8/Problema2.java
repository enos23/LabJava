package Lab8;

import java.util.List;
import java.util.stream.Collectors;

public class Problema2 {
    public static void main(String[] args) {
        List<String> strings = List.of("hello", "masina", "iarna", "mere", "masa");
        char startingLetter = 'a';

        long count = countStringStartingWith(strings, startingLetter);
        System.out.println("'Numarul de cuvinte care incep cu '" + startingLetter + "': " + count);
        }

        public static long
    countStringStartingWith(List<String> strings, char letter) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .count();
        }

    }