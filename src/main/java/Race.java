import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Race {

    Cars cars;
    RacingRule racingRule;

    Race(){}

    Race(Cars cars){
        this.cars = cars;
    }

    public void registerNameOfCars(String[] carNames) throws Exception{
        ArrayList<Car> carList = new ArrayList<>();
        
        for(String carName : carNames){
            carList.add(new Car(carName));
        }
        cars = new Cars(carList);
    }
    
    public void runSingleRound(){
        racingRule = new RacingRule();
        
        cars.moveCars(racingRule);
    }

    public CarInfo[] getCurrentResult(){

        return cars.getNameAndDistance();
    }

    public String[] getWinner(){
        CarInfo[] infos = cars.getNameAndDistance();
        
        int maxDistance = Arrays.stream(infos)
                                .mapToInt(CarInfo::getDistance)
                                .max()
                                .getAsInt();
        
        String[] Winner = Stream.of(infos)
                                .filter(info -> info.getDistance() == maxDistance)
                                .map(CarInfo::getName)
                                .toArray(String[]::new);
        
        return Winner;                                
                                
    }

}
