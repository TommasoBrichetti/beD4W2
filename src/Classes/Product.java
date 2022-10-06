package Classes;

import java.util.Locale;

public class Product {
    long id;
    String name;
    category category;
    Double price;
    static private long key = 0;

    public Product(String  _name, category _category, Double _price){
        id = key++;
        name = _name;
        category = _category;
        price = _price;
    }

    public Classes.category getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public void sale(double v){
        price = price - price*v/100;
    }
    @Override
    public String toString(){
        return name +  ", " + category + ", " + price;
    }
}
