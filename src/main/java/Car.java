import java.util.Objects;
public class Car {
    String name;
    int position;

    Car(String name) throws Exception{
        if(name.length() > 5){
            throw new RuntimeException("자동차 이름이 5자를 초과하였습니다.");
        }
        this.name = name;
        this.position = 0;
    }

    Car(String name, int position) throws Exception{
        if(name.length() > 5){
            throw new RuntimeException("자동차 이름이 5자를 초과하였습니다.");
        }
        this.name = name;
        this.position = position;
    }


    public void move(){
        this.position +=1;
    }

    protected void letsMove(){
        if(isMovable())
            this.position +=1;
    }

    boolean isMovable(){
        
        if( (int)(Math.random()*9) >=4 ){
            return true;
        }
        return false;
    }

    public String getName(){
        return this.name;
    }

    public int getDistance(){
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return this.name == car.name
                && this.position == car.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name)+Objects.hash(this.position);
    }
}
