package Plecak;

import java.util.*;

public class Problem {
    private int n;
    private int seed;
    private int lowerBound;
    private int upperBound;
    private List<Przedmiot> przedmioty = new ArrayList<>();

    public Problem(int n, int seed, int lowerBound, int upperBound) {
        this.n = n;
        this.seed = seed;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;

        Random rand = new Random(seed);
        for (int i = 0; i < n; i++) {
            int wartosc = rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int waga = rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
            przedmioty.add(new Przedmiot(wartosc, waga));
        }
    }

    public Result solve(int capacity) {
        List<ItemWrapper> items = new ArrayList<>();
        for (int i = 0; i < przedmioty.size(); i++) {
            items.add(new ItemWrapper(i, przedmioty.get(i)));
        }

        items.sort((a, b) -> Double.compare(b.stosunek(), a.stosunek()));

        Result result = new Result();
        int remainingCapacity = capacity;

        for (ItemWrapper item : items) {
            int maxCount = remainingCapacity / item.przedmiot.waga;
            if (maxCount > 0) {
                result.dodaj(item.przedmiot, item.index, maxCount);
                remainingCapacity -= maxCount * item.przedmiot.waga;
            }
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Instancja problemu:\n");
        for (int i = 0; i < przedmioty.size(); i++) {
            sb.append("Przedmiot ").append(i).append(": ")
                    .append(przedmioty.get(i)).append("\n");
        }
        return sb.toString();
    }

    private static class ItemWrapper {
        int index;
        Przedmiot przedmiot;

        ItemWrapper(int index, Przedmiot przedmiot) {
            this.index = index;
            this.przedmiot = przedmiot;
        }

        double stosunek() {
            return przedmiot.stosunek();
        }
    }
}
