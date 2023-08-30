import App.*;
import App.toys.Toy;

import java.io.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // создаем магазин
        Shop shop = new Shop("Магазин игрушек");

        // создаем склад
        Stock stock = new Stock();

        // добавляем витрины
        shop.addShowcase(ToyTypes.Constructor, 10);
        shop.addShowcase(ToyTypes.Doll, 10);
        shop.addShowcase(ToyTypes.Robot, 10);

        View view = new View();
        view.showGreeting(shop);

        while (true) {
            view.showMenu();
            String num = view.input("Выберите пункт меню: ");
            int numb = Integer.parseInt(num);
            if (numb == 5) {
                break;
            } else if (numb == 1) {
                view.shopInspection(shop);
            } else if (numb == 2) {
                if (shop.checkFullShowcases()) {
                    view.errorFullShowcase();
                } else {
                    // заполняем витрины
                    for (Showcase showcase : shop.getShowcases()) {
                        while (!showcase.checkFullShowcase()) {
                            showcase.addToy(stock.takeFromWarehouse(showcase.getType()));
                        }
                    }
                    view.showMessage("Витрины заполнены.");
                }
            } else if (numb == 3) {
                if (shop.checkEmptyShowcases()) {
                    view.errorEmptyShowcase();
                } else {
                    if (shop.getPrizeLine().size() != 0) {
                        view.errorNotEmptyQueue();
                    } else {
                        shop.holdALottery();
                        view.showMessage("Розыгрыш проведен.");
                    }
                }
            } else if (numb == 4) {
                if (shop.getPrizeLineSize() == 0) {
                    view.errorEmptyPrizeLine();
                } else {
                    while (shop.getPrizeLineSize() > 0) {
                        // берем игрушку
                        Toy toy = shop.getAPrizeToy();

                        // выбираем ребенка
                        int index = new Random().nextInt(ChildNames.values().length);
                        ChildNames[] childs = ChildNames.values();
                        ChildNames child = childs[index];

                        // вручаем игрушку
                        view.showMessage(child.toString() + " получил(а) " + toy.getType() + " " + toy.getName());

                        // записать в файл
                        String file_path = "log.txt";
                        saveInLog(file_path, toy, child);
                    }
                    view.showMessage("Игрушки розданы!");
                }
            }
        }
    }

    private static void saveInLog(String file_path, Toy toy, ChildNames child) {
        File file = new File(file_path);
        FileWriter fr = null;
        BufferedWriter br = null;
        try {
            fr = new FileWriter(file, true);
            br = new BufferedWriter(fr);
//            br.newLine();
            br.write(child.toString() + " получил(а) " + toy.getType() + " " + toy.getName() + "\n");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
