package Plecak;

public class Przedmiot {
    public int wartosc;
    public int waga;

    public Przedmiot(int wartosc, int waga) {
        this.wartosc = wartosc;
        this.waga = waga;
    }

    public double stosunek() {
        return (double) wartosc / waga;
    }

    @Override
    public String toString() {
        return "Przedmiot{wartość=" + wartosc + ", waga=" + waga + "}";
    }
}
