package car;

public class Car {

    private static final int MOVE_COUNT = 1;

    private final CarName name;
    private final CarPosition position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = new CarPosition(position);
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name.toString(), position.toString());
    }

    public void move() {
        this.position.move(MOVE_COUNT);
    }

    public boolean isGoal(int goalPosition) {
        return position.equals(goalPosition);
    }
}
