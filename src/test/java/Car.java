
public class Car {
    String name;
    int position;

    Car(String name) throws Exception{
        if(name.length() > 5){
            throw new RuntimeException("자동차 이름이 5자를 초과하였습니다.");
        }
        this.name = name;
    }

    public void move(){
        this.position +=1;
    }

    public String getName(){
        return this.name;
    }

    public int getPosition(){
        return this.position;
    }
}
