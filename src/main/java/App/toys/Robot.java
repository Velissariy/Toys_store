package App.toys;
import App.ToyTypes;
public class Robot extends Toy implements HandsLegs {
    public Robot() {
        super(30, ToyTypes.Robot);
    }
}