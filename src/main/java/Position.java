public class Position {
    final int position;

    Position(int position){
        this.position = position;
    }

    public int getPosition(){
        return this.position;
    }

    public Position increasePostion(){
        return new Position(this.position +1);
        
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position pos = (Position) o;
        return this.position == pos.position;
    }

}
