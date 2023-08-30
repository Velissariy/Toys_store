import App.Shop;

import java.util.Scanner;

import App.Showcase;
import App.toys.Toy;

public class View {

    public void showGreeting(Shop shop) {
        System.out.println(shop.name + " салют, Старина)");
    }

    public void showMenu() {
        System.out.println("Главное меню: ");
        System.out.println("1. Осмотреть магазин");
        System.out.println("2. Пополнить витрины");
        System.out.println("3. Провести розыгрыш");
        System.out.println("4. Раздавать игрушки");
        System.out.println("5. Уйти");
    }

    public String input(String text) {
        System.out.println(text);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void errorFullShowcase() {
        System.out.println("Витрина переполнена");
    }

    public void errorEmptyShowcase() {
        System.out.println("Витрина пуста");
    }

    public void errorNotEmptyQueue() {
        System.out.println("Раздай предыдущие игрушки!");
    }

    public void errorEmptyPrizeLine() {
        System.out.println("Сначала разыгай игрушки!");
    }

    public void shopInspection(Shop shop) {
        for (Showcase showcase : shop.getShowcases()) {
            System.out.println("Витрина: ");
            System.out.println(showcase);
        }

        System.out.println("Очередь разыграных игрушек: ");

        if (shop.getPrizeLine().size() == 0) {
            System.out.println("Пусто");
        } else {
            for (Toy toy : shop.getPrizeLine()) {
                System.out.println(toy);
            }
        }

    }

    public void showMessage(String text) {
        System.out.println(text);
    }
}
