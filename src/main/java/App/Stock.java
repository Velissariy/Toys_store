package App;

import App.toys.Constructor;
import App.toys.Doll;
import App.toys.Robot;
import App.toys.Toy;

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
