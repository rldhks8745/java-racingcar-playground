package car;

import car.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {

    @Test
    @DisplayName("차 이름은 5글자 초과하지 못함")
    void CarNameIsNotExceed5Length() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> new Car("tank12"));
    }

    @Test
    @DisplayName("차이름 toString")
    void CarToStringTest() {
        Car car = new Car("tank");
        car.move();
        assertThat(car.toString()).isEqualTo("tank : -");
        car.move();
        car.move();
        assertThat(car.toString()).isEqualTo("tank : ---");
    }

    @Test
    @DisplayName("차 isGoal 테스트")
    void CarMoveTest() {
        Car car = new Car("tank");
        car.move();
        assertThat(car.isGoal(1)).isTrue();
    }
}
