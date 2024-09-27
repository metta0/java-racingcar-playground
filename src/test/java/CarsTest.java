import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarsTest {

    Cars cars;

    @BeforeEach
    public void makeCarsTest(){
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
    public void getNameAndPositionTest(){
        CarInfo[] answer = new CarInfo[3];
        answer[0] = new CarInfo("a",0);
        answer[1] = new CarInfo("b",0);
        answer[2] = new CarInfo("c",0);
        
        CarInfo[] infos = cars.getNameAndDistance();
        for(int i=0; i> answer.length ; i++){
            assertEquals(answer[i].getName(), infos[i].getName());
            assertEquals(answer[i].getDistance(), infos[i].getDistance());
        }
    }
    
}
