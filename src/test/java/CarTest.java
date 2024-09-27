import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CarTest {
    Car car;

    @Test
    public void checkCarNameAndPositionTest() throws Exception{
        try{
            car = new Car("Jihoo");
            car.move();
            car.move();
            assertEquals(car.getName(),"Jihoo");
            assertEquals(car.getPosition(), 2);
        }
        catch(Exception e){
            throw e;
        }
    }

    @Test 
    public void checkCarNameExceed5(){
        try{
            car = new Car("Jihoon");
        }
        catch(Exception e){
            assertThat(e).isInstanceOf(RuntimeException.class);
        }
    }

}
