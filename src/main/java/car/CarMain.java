package car;

import java.util.Random;
import java.util.stream.IntStream;

public class CarMain {

    public static void main(String[] args) {
        Cars cars = new Cars("pobi,crong,honux");
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < 5; i++) {
            IntStream.range(0, cars.size())
                    .forEach(index -> cars.move(index, random.nextInt(10) >= 4));

            System.out.println(cars);
        }

        System.out.println(cars.showWinners());
    }
}
