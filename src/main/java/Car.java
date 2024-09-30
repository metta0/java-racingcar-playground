import java.util.Objects;
public class Car {
    Name name;
    Position position;

    Car(String name) throws Exception{
        
        this.name = new Name(name);
        this.position = new Position(0);
    }

    Car(String name, int position) throws Exception{
        this.name = new Name(name);
        this.position = new Position(position);
    }


    public void move(){
        position = position.increasePostion();
    }

    protected void letsMove(){
        if(isMovable())
            position = position.increasePostion();
    }

    boolean isMovable(){
        
        if( (int)(Math.random()*9) >=4 ){
            return true;
        }
        return false;
    }

    public String getName(){
        return this.name.getName();
    }

    public int getDistance(){
        return this.position.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return this.name.equals(car.name)
                && this.position.equals(car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name)+Objects.hash(this.position);
    }
}
