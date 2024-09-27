public class RacingRule {

    RacingRule(){};

    public boolean isMove(){
        if( (int)(Math.random()*9) >=4 ){
            return true;
        }
        return false;
    }

}
