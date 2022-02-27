package car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    public static final String DELIMITER = ",";

    private final List<Car> cars;

    public Cars(String carNames) {
        cars = divideNames(carNames, DELIMITER).stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public static List<String> divideNames(String carNames, String delimiter) {
        if (carNames == null || carNames.isEmpty())
            throw new RuntimeException("차 이름 문자열이 존재하지 않습니다.");

        return Arrays.stream(carNames.split(delimiter)).collect(Collectors.toList());
    }

    public int size() {
        return cars.size();
    }

    public void move(int index, boolean canMove) {
        if (canMove)
            get(index).move();
    }

    public Car get(int index) {
        return cars.get(index);
    }
}
