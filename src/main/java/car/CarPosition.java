package car;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class CarPosition {

    private int position;

    public CarPosition(int position) {
        this.position = position;
    }

    public void move(int add) {
        position += add;
    }

    public boolean equals(int position) {
        return position == this.position;
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
}
