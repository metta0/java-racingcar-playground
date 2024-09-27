import java.util.ArrayList;

public class Race {

    Race(){}

    Cars cars;

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

}
