package App;

import App.toys.Toy;
import java.util.ArrayList;

public class Showcase {

    private final ArrayList<Toy> toys;
    private final int size;

    private ToyTypes type;

    public Showcase(ToyTypes type, int size) {
        this.toys = new ArrayList<>();
        this.size = size;
        this.type = type;
    }

    public void addToy(Toy toy) {
        if (toy.getId() != 0) {
            toys.add(toy);
        }
    }

    public Toy getToy(int toyId) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                return toy;
            }
        }

        return null;
    }

    public Toy getToyByIndex(int index) {
        return toys.get(index);
    }

    public void delToy(Toy toy) {
        toys.remove(toy);
    }

    public ArrayList<Toy> getToys() {
        return toys;
    }

    public int getQuantity(Toy toy) {
        int quantity = 0;
        for (Toy tmpToy : toys) {
            if (toy.getClass() == tmpToy.getClass()) {
                quantity++;
            }
        }

        return quantity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (toys.size() > 0) {
            for (Toy toy : toys) {
                sb.append(toy.toString()).append("\n");
            }
        } else {
            sb.append("Пусто");
        }

        return sb.toString();
    }

    public int getToyQuantity() {
        return toys.size();
    }

    public int getSize() {
        return size;
    }

    public ToyTypes getType() {
        return type;
    }

    public void setType(ToyTypes type) {
        if (toys.size() == 0) {
            this.type = type;
        }
    }

    public boolean contains(Toy toy) {
        for (Toy tmpToy : toys) {
            if (tmpToy.equals(toy)) return true;
        }
        return false;
    }

    public boolean checkFullShowcase() {
        return this.getToyQuantity() == this.getSize();
    }

    public boolean checkEmptyShowcase() {
        return this.getToyQuantity() <= 0;
    }
}
