package Classes;

import java.time.LocalDate;
import java.util.List;

public class Order {
    Long id;
    Status status;
    LocalDate orderDate;
    LocalDate deliveryDate;
    List<Product> products;
    Customer customer;
    static private long key = 0;

    public Order(List<Product> _products, Customer _customer){
        id = key++;
        status = Status.CONFERMATO;
        orderDate = LocalDate.now();
        products = _products;
        customer = _customer;
    }

    public void orderShipped(){
        if (status == Status.CONFERMATO){
            status = Status.SPEDITO;
            deliveryDate = LocalDate.now();
        }else{
            System.out.println("questo ordine è stato già spedito, consegnato o cancellato");
        }
    }
    public Customer getCustomer(){
        return customer;
    }
    @Override
    public String toString(){
        return status +  ", " + orderDate + ", " + customer.toString();
    }
}
