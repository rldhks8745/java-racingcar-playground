# 2️⃣ 자동차 경주 게임 구현
## 기능 요구사항
1. 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- [ ✔ ] private final CarName name;
- [ ✔ ] private final CarPosition position;
- [ ✔ ] CarName.validate();
- [ ✔ ] CarName.validateLength();

2. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [ ✔ ] public String Car.toString()

3. 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- private final List<Car> cars;
- public static final String Cars.DELIMITER = ",";
- static List<String> Cars.divideNames(String carNames, String delimiter);

4. 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- [ ✔ ] public CarStatus Car.move();
~~- Cars.move(List<Boolean> canMoveList);~~
- [ ✔ ] public void Cars.move(int index, boolean canMove)

5. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.
- [ ✔ ] public void showWinners();

## 실행 결과
위 요구사항에 따라 3대의 자동차가 5번 움직였을 경우 프로그램을 실행한 결과는 다음과 같다.

```
경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
pobi,crong,honux
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
crong : -
honux : -

pobi : --
crong : -
honux : --

pobi : ---
crong : --
honux : ---

pobi : ----
crong : ---
honux : ----

pobi : -----
crong : ----
honux : -----

pobi : -----
crong : ----
honux : -----

pobi, honux가 최종 우승했습니다.
```

## 힌트
자동차는 자동차 이름과 위치 정보를 가지는 Car 객체를 추가해 구현한다.