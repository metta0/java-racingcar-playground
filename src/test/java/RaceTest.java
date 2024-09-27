import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RaceTest {

    Race race;
    Cars cars;

    @BeforeEach
    public void beforeTest() throws Exception {
        ArrayList<Car> carsArrayList = new ArrayList<>();

        carsArrayList.add(new Car("a"));
        carsArrayList.add(new Car("b"));
        carsArrayList.add(new Car("c"));

        cars = new Cars(carsArrayList);
    }

    @Test
    public void makerCarsAndGetResultTest() throws Exception {
        String[] carNames = { "a", "b", "c" };
        race = new Race();
        race.registerNameOfCars(carNames);

        CarInfo[] answer = cars.getNameAndDistance();
        CarInfo[] testResult = race.getCurrentResult();

        for (int i = 0; i > answer.length; i++) {
            assertEquals(answer[i].getName(), testResult[i].getName());
            assertEquals(answer[i].getDistance(), testResult[i].getDistance());
        }
    }

    @Test
    public void getFinalResult() throws Exception {
        
        List<Car> carsArrayList = Stream.of(new Car("a"), new Car("b"), new Car("c"))
                .peek(car -> {
                    if (car.getName().equals("a") || car.getName().equals("c")) {
                        car.move();
                        car.move();
                    } else if (car.getName().equals("b")) {
                        car.move();
                    }
                })
                .collect(Collectors.toList());

        cars = new Cars(new ArrayList<>(carsArrayList));
        Race race = new Race(cars);
        assertThat(race.getWinner()).contains("a", "c");
    }
}
