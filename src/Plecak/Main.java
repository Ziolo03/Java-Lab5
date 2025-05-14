package Plecak;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj liczbę rodzajów przedmiotów: ");
        int liczbaPrzedmiotow = scanner.nextInt();

        System.out.print("Podaj ziarno generatora (seed): ");
        int seed = scanner.nextInt();

        System.out.print("Podaj pojemność plecaka: ");
        int pojemnoscPlecaka = scanner.nextInt();

        int dolnyZakres = 1;
        int gornyZakres = 10;

        Problem problem = new Problem(liczbaPrzedmiotow, seed, dolnyZakres, gornyZakres);
        System.out.println("\n" + problem);

        Result wynik = problem.solve(pojemnoscPlecaka);
        System.out.println("\n" + wynik);
    }
}
