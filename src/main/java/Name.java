public class Name {
    final String name;

    Name(String name) throws Exception{
        if(name.length() > 5){
            throw new RuntimeException("자동차 이름이 5자를 초과하였습니다.");
        }
        if(name.isBlank() || name.isEmpty()){
            throw new RuntimeException("자동차 이름은 최소 1자 이상입니다.");
        }
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name = (Name) o;
        return this.name.equals(name.name);
    }    
}
