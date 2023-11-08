package lab3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Probleme {

    public static void afiseazaNumerePrime(int[] sir) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti lungimea sirului de numere: ");
        int lungime = scanner.nextInt();
        int[] numere = new int[lungime];
        System.out.println("Introduceti numerele: ");
        for (int i = 0; i < lungime; i++) {
            numere[i] = scanner.nextInt();
        }
        scanner.close();

        System.out.println("Numerele prime din sir sunt: ");
        for (int numar : numere) {
            if (estePrim(numar)) {
                System.out.print(numar + " ");
            }
        }
    }

    public static boolean estePrim(int numar) {
        if (numar <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numar); i++) {
            if (numar % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void afiseazaSirFibonacci(int N) {
        int a = 0, b = 1;
        System.out.print("Sirul Fibonacci pana la " + N + " este: ");
        while (a <= N) {
            System.out.print(a + " ");
            int sum = a + b;
            a = b;
            b = sum;
        }
        System.out.println();
    }

    public static boolean estePalindrom(String cuvant) {
        int i = 0, j = cuvant.length() - 1;
        while (i < j) {
            if (cuvant.charAt(i) != cuvant.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void gasesteElementeComune(String[] a, String[] b) {
        List<String> commonElements = new ArrayList<>();
        for (String s1 : a) {
            for (String s2 : b) {
                if (s1.equals(s2)) {
                    commonElements.add(s1);
                    break;
                }
            }
        }
        System.out.println("Elementele comune sunt: " + commonElements);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceti elementele primului sir, separate prin virgula: ");
        String input1 = scanner.nextLine();
        String[] sir1 = input1.split(",");

        System.out.println("Introduceti elementele celui de-al doilea sir, separate prin virgula: ");
        String input2 = scanner.nextLine();
        String[] sir2 = input2.split(",");

        gasesteElementeComune(sir1, sir2);
    }
}