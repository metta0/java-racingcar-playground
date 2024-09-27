import java.util.ArrayList;

public class Race {

    Cars cars;
    RacingRule racingRule;

    Race(){}

    public void makeCars(String[] carNames) throws Exception{
        ArrayList<Car> carList = new ArrayList<>();
        
        for(String carName : carNames){
            carList.add(new Car(carName));
        }
        cars = new Cars(carList);
    }

    public CarInfo[] getCurrentResult(){
        return cars.getNameAndDistance();
    }

    public void runSingleRound(){
        racingRule = new RacingRule();
        cars.moveCars(racingRule);
    }

}
