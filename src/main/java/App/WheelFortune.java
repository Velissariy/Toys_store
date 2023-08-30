package toys;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class WheelFortune {
    ArrayList<BallWheelOfFortune> balls = new ArrayList<>();

    public void addNubmer(int number, int weight) {
        balls.add(new BallWheelOfFortune(number, weight));
    }

    public static class BallWheelOfFortune {
        public final int number;

        public final int weight;

        public BallWheelOfFortune(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }
    }

    public int run() {

        // создаем массив шансов
        ArrayList<Integer> chance = new ArrayList<>();
        int count = 0;
        for (BallWheelOfFortune ball : balls) {
            chance.add(ball.weight);
            count += ball.weight;
        }

        int index = new Random().nextInt(count);

        BallWheelOfFortune randBall = null;
        // Генерация случайного числа
        for (int i = 0; i < chance.size(); i++) { // Ищем элемент, которому принадлежит этот индекс
            index -= chance.get(i);
            if (index < 0) {
                randBall = balls.get(i);
                break;
            }
        }

        // удаляем шар из колеса
        balls.remove(randBall);

        return randBall.number;
    }

    public int getNumberOfBalls() {
        return balls.size();
    }
}
