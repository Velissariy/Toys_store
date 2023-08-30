package toys;

import org.example.toyShop.toys.Constructor;
import org.example.toyShop.toys.Doll;
import org.example.toyShop.toys.Robot;
import org.example.toyShop.toys.Toy;

public class Stock {
    int lastToyId;

    public Stock() {
        this.lastToyId = 0;
    }

    public Toy takeFromWarehouse(ToyTypes type) {
        Toy toy = null;

        switch (type) {
            case Doll: {
                toy = new Doll();
                break;
            }
            case Robot: {
                toy = new Robot();
                break;
            }
            case Constructor: {
                toy = new Constructor();
                break;
            }
        }

        toy.setId(this.getNewID());
        return toy;
    }

    public int getNewID() {
        this.lastToyId++;
        return this.lastToyId;
    }
}
