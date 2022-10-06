package Classes;

public class Customer {
    Long id;
    String name;
    Integer tier;
    static private long key = 0;

    public Customer(String _name, Integer _tier){
        id = key++;
        name = _name;
        tier = _tier;
    }
    public Integer getTier(){
        return tier;
    }
    @Override
    public String toString(){
        return name +  ", " + tier;
    }
}
