package car;

import java.util.Objects;

public class Car implements Comparable<Car>{

    private static final int MOVE_COUNT = 1;

    private final CarName name;

    public CarName getName() {
        return name;
    }

    private final CarPosition position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new CarPosition(0);
    }

    public void move() {
        this.position.move(MOVE_COUNT);
    }

    public boolean isSamePosition(Car other) {
        return position.equals(other.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    public boolean isNotEquals(Object o) {
        return !equals(o);
    }

    @Override
    public int compareTo(Car other) {
        return position.compareTo(other.position);
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, position);
    }
}
