package Plecak;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProblemTest {

    @Test
    public void testCoNajmniejJedenElementJestWynikiem() {
        Problem problem = new Problem(5, 123, 1, 10);
        int capacity = 15;

        Result result = problem.solve(capacity);
        String resultText = result.toString();
        assertTrue(resultText.contains("x "), "Powinien być przynajmniej jeden przedmiot w plecaku");
    }

    @Test
    public void testPusteRozwiazanieGdyZadneNiePasuje() {
        Problem problem = new Problem(5, 999, 10, 10);
        int capacity = 5;

        Result result = problem.solve(capacity);
        String output = result.toString();
        assertTrue(output.contains("Suma wartości: 0"), "Wartość powinna być 0");
        assertTrue(output.contains("Suma wag: 0"), "Waga powinna być 0");
    }

    @Test
    public void testZakresyPrzedmiotowStringiem() {
        Problem problem = new Problem(10, 456, 1, 10);
        String opis = problem.toString();

        String[] linie = opis.split("\n");
        for (String linia : linie) {
            if (linia.contains("Przedmiot") && linia.contains("waga=")) {
                String[] parts = linia.replaceAll("[^0-9]+", " ").trim().split("\\s+");
                if (parts.length >= 3) {
                    int wartosc = Integer.parseInt(parts[1]);
                    int waga = Integer.parseInt(parts[2]);
                    assertTrue(wartosc >= 1 && wartosc <= 10, "Wartość poza zakresem: " + wartosc);
                    assertTrue(waga >= 1 && waga <= 10, "Waga poza zakresem: " + waga);
                }
            }
        }
    }

    @Test
    public void testPoprawneSumyDlaKonkretnychDanych() {
        Problem problem = new Problem(3, 42, 1, 10);
        int capacity = 10;
        Result result = problem.solve(capacity);
        String output = result.toString();

        String[] linie = output.split("\n");
        int sumaWartosci = Integer.parseInt(linie[linie.length - 2].replaceAll("[^0-9]", ""));
        int sumaWag = Integer.parseInt(linie[linie.length - 1].replaceAll("[^0-9]", ""));

        assertTrue(sumaWag <= capacity, "Suma wag przekracza pojemność plecaka");
        assertTrue(sumaWartosci >= 0, "Wartość powinna być nieujemna");
    }
}
