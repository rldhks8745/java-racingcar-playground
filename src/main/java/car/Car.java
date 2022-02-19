package car;

public class Car {

    private static final int MOVE_COUNT = 1;

    private final CarName name;
    private final CarPosition position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new CarPosition(0);
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, position);
    }

    public void move() {
        this.position.move(MOVE_COUNT);
    }

    public boolean isGoal(int goalPosition) {
        return position.equals(goalPosition);
    }
}
