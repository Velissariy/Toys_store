package toys;

import toys.Toy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Shop {
    private Queue<Toy> prizeLine;
    public final String name;
    private ArrayList<Showcase> showcases;
    private int lastToyId;

    public Shop(String name) {
        prizeLine = new LinkedList<>();
        this.name = name;
        showcases = new ArrayList<>();
    }

    public void addShowcase(ToyTypes type, int size) {
        showcases.add(new Showcase(type, size));
    }

    public void delShowcase(Showcase showcase) {
        if (showcase.getToyQuantity() == 0) {
            showcases.remove(showcase);
        }
    }

    public Showcase getShowcaseByIndex(int index) {
        return showcases.get(index);
    }

    public ArrayList<Showcase> getShowcases() {
        return showcases;
    }

    public boolean checkFullShowcases() {
        for (Showcase showcase : showcases) {
            if (showcase.getToyQuantity() != showcase.getSize()) return false;
        }
        return true;
    }

    public boolean checkEmptyShowcases() {
        for (Showcase showcase : showcases) {
            if (showcase.getToyQuantity() > 0) return false;
        }
        return true;
    }

    //    public void addToy(Toy toy) {
//        showcase.addToy(toy);
//    }

    /**
     * Проводит розыгрыш игрушек и добавляет в очередь на выдачу
     */
    public void holdALottery() {
        // создаем колесо
        WheelFortune wheelOfFortune = new WheelFortune();

        // добавляем шары
        for (Showcase showcase : showcases) {
            for (Toy toy : showcase.getToys()) {
                wheelOfFortune.addNubmer(toy.getId(), toy.getWeight());
            }
        }

        // крутим колесо пока есть шары
        while (wheelOfFortune.getNumberOfBalls() > 0) {
            int prizeToyId = wheelOfFortune.run();

            // сектор ПРИЗ на барабане ;)
            prizeLine.add(getToyById(prizeToyId));
        }
    }

    public Toy getAPrizeToy() {
        Toy toy = prizeLine.poll();
        for (Showcase showcase : showcases) {
            if (showcase.contains(toy)) showcase.delToy(toy);
        }

        // записать в файл

        return toy;
    }

    public Queue<Toy> getPrizeLine() {
        return prizeLine;
    }

    public int getPrizeLineSize() {
        return prizeLine.size();
    }

    public Toy getToyById(int id) {
        for (Showcase showcase : showcases) {
            for (Toy toy : showcase.getToys()) {
                if (toy.getId() == id) return toy;
            }
        }

        return null;
    }
}
