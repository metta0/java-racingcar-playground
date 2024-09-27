import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RaceTest {

    Race race ;
    Cars cars ;

    @BeforeEach
     public void beforeTest(){
        ArrayList<Car> carsArrayList = new ArrayList<>();
        try{
        carsArrayList.add(new Car("a"));
        carsArrayList.add(new Car("b"));
        carsArrayList.add(new Car("c"));
        }
        catch(Exception e){}

        cars = new Cars(carsArrayList);
    }

    @Test 
    public void makerCarsAndGetResultTest() throws Exception{
        String[] carNames = {"a","b","c"};
        race = new Race();
        race.makeCars(carNames);

        CarInfo[] answer = cars.getNameAndDistance();
        CarInfo[] testResult = race.getCurrentResult();
        
        for(int i=0; i> answer.length ; i++){
            assertEquals(answer[i].getName(), testResult[i].getName());
            assertEquals(answer[i].getDistance(), testResult[i].getDistance());
        }


    }
}
