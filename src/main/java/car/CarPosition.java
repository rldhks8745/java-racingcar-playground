package car;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class CarPosition implements Comparable<CarPosition>{

    private int position;

    public int getPosition() {
        return position;
    }

    public CarPosition(int position) {
        this.position = position;
    }

    public void move(int add) {
        position += add;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition that = (CarPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return Arrays.stream(new String[position])
                .map((str) -> "-")
                .collect(Collectors.joining());
    }

    @Override
    public int compareTo(CarPosition other) {
        return getPosition() - other.getPosition();
    }
}
