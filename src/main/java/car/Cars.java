package car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        cars.forEach(car -> {
            sb.append(car);
            sb.append('\n');
        });
        return sb.toString();
    }

    public String showWinners() {
        StringBuilder sb = new StringBuilder();
        Car winnerPositionCar = cars.stream().max(Car::compareTo).get();
        List<Car> winnerList = cars.stream()
                .filter(winnerPositionCar::isSamePosition)
                .collect(Collectors.toList());

        for (int i=0; i<winnerList.size(); i++) {
            sb.append(winnerList.get(i).getName());
            sb.append(appendDelimiter(isLastWinner(i, winnerList.size())));
        }

        return sb.append("가 최종 우승했습니다.").toString();
    }

    private boolean isLastWinner(int index, int size) {
        return index < size - 1;
    }

    private String appendDelimiter(boolean hasDelimiter) {
        if (hasDelimiter)
            return ", ";

        return "";
    }
}
