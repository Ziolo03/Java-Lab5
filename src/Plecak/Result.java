package Plecak;

import java.util.*;

public class Result {

    public static class Wpis {
        public Przedmiot przedmiot;
        public int index;
        public int ilosc;

        public Wpis(Przedmiot przedmiot, int index, int ilosc) {
            this.przedmiot = przedmiot;
            this.index = index;
            this.ilosc = ilosc;
        }
    }

    public List<Wpis> wpisy = new ArrayList<>();
    public int sumaWartosci = 0;
    public int sumaWag = 0;

    public void dodaj(Przedmiot p, int index, int ilosc) {
        wpisy.add(new Wpis(p, index, ilosc));
        sumaWartosci += ilosc * p.wartosc;
        sumaWag += ilosc * p.waga;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rozwiązanie:\n");
        for (Wpis wpis : wpisy) {
            sb.append("Przedmiot ").append(wpis.index)
                    .append(" (waga=").append(wpis.przedmiot.waga)
                    .append(", wartość=").append(wpis.przedmiot.wartosc)
                    .append(") x ").append(wpis.ilosc).append("\n");
        }
        sb.append("Suma wartości: ").append(sumaWartosci).append("\n");
        sb.append("Suma wag: ").append(sumaWag);
        return sb.toString();
    }
}
