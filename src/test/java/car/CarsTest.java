package car;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    static String carNames;

    @BeforeAll
    static void beforeAll() {
        carNames = "pobi,crong,honux";
    }

    @Test
    @DisplayName("String으로 넘어온 자동차 이름들 -> delimiter로 List<String> 생성 테스트")
    void CarsDivideNameTest() {
        assertThat(Cars.divideNames(carNames, Cars.DELIMITER).size()).isEqualTo(3);
    }

    @Test
    @DisplayName("String으로 넘어온 자동차 이름들 -> List<Car> 생성 테스트")
    void createCarsListTest() {
        Cars cars = new Cars(carNames);
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("canMoveArray에 해당하는 index 값이 true 일 경우 index에 맞는 car를 움직이는 테스트")
    void moveTest() {
        Cars cars = new Cars(carNames);
        cars.move(0, true);
        cars.move(1, false);
        cars.move(2, true);

        assertThat(cars.get(0).toString()).isEqualTo("pobi : -");
        assertThat(cars.get(1).toString()).isEqualTo("crong : ");
        assertThat(cars.get(2).toString()).isEqualTo("honux : -");
    }
}
