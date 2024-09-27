
public class CarInfo {
    String carName;
    int carDistance;
    
    CarInfo(String carName,int carDistance){
        this.carName = carName;
        this.carDistance = carDistance;
    }

    public String getName(){
        return this.carName;
    }

    public int getDistance(){
        return this.carDistance;
    }
}
