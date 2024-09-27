import java.util.ArrayList;

public class Cars {
    ArrayList<Car> cars;
    
    Cars(ArrayList<Car> cars){
        this.cars = cars;
    }

    public CarInfo[] getNameAndDistance(){
        CarInfo[] result = cars.stream()
                               .map(car -> new CarInfo(car.getName(), car.getDistance()))
                               .toArray(CarInfo[]::new);

        return result;
    }

}
