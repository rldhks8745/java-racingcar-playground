package car;

public class CarName {
    private String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private static void validate(String name) {
        if (name == null || name.isEmpty())
            throw new RuntimeException("이름이 존재하지 않습니다.");

        if (!validateLength(name))
            throw new RuntimeException("이름의 길이가 5글자를 초과합니다.");
    }

    private static boolean validateLength(String name) {
        return name.length() <= 5;
    }

    @Override
    public String toString() {
        return name;
    }
}
