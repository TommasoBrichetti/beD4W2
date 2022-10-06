import Classes.Customer;
import Classes.Order;
import Classes.Product;
import Classes.category;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Product> p1 = new ArrayList<>();
        List<Order> o1 = new ArrayList<>();
        List<Product> p3 = new ArrayList<>();
        List<Customer> c1 = new ArrayList<>();

        c1.add(new Customer("pippo", 2));
        c1.add(new Customer("strong", 2));
        c1.add(new Customer("pong", 2));
        c1.add(new Customer("song", 2));
        c1.add(new Customer("nung", 2));
        c1.add(new Customer("tang", 2));
        c1.add(new Customer("fang", 1));
        c1.add(new Customer("fango", 2));

        for (int i = 0; i < 100; i++) {
            p1.add(new Product("libro-"+i, category.BOOKS, Math.floor(Math.random()*200+1)));
            o1.add(new Order(p1, c1.get((int) Math.floor(Math.random()*8))));
            p3.add(new Product("boys-"+i, category.BOYS, Math.floor(Math.random()*40+1)));
        }

//        for (int i = 0; i < o1.size(); i++) {
//            System.out.println(o1.get(i).toString());
//        }

//        Stream os1 = o1.stream();
//
//        os1.forEach((e)->{
//            System.out.println(e);
//        });


        getDueInData(o1);
        fetBooksnotCheap(p1);
        babyfilter(p3);
        boysFilterForsale(p3);


    }
    public static void getDueInData(List<Order> arr){
        List<Order> searchedList = arr.stream()
                .filter(c -> c.getCustomer().getTier() == 2)
                .collect(Collectors.toList());

        AtomicInteger i= new AtomicInteger();
        searchedList.forEach((e)->{
            System.out.println(e);
            i.getAndIncrement();
        });

        System.out.println(i+ " Elementi Trovati");

    }
    public static void fetBooksnotCheap(List<Product> arr){
        List<Product> searchedList = arr.stream()
                .filter(c -> c.getCategory().equals(category.BOOKS) && c.getPrice() > 2)
                .collect(Collectors.toList());

        AtomicInteger i= new AtomicInteger();
        searchedList.forEach((e)->{
            System.out.println(e);
            i.getAndIncrement();
        });

        System.out.println(i+ " Elementi Trovati");

    }
    public static void babyfilter(List<Product> arr){
        List<Product> searchedList = arr.stream()
                .filter(c -> c.getCategory().equals(category.BABY))
                .collect(Collectors.toList());

        AtomicInteger i= new AtomicInteger();
        searchedList.forEach((e)->{
            System.out.println(e);
            i.getAndIncrement();
        });

        System.out.println(i+ " Elementi Trovati");

    }
    public static void boysFilterForsale(List<Product> arr){
        List<Product> searchedList = arr.stream()
                .filter(c -> c.getCategory().equals(category.BABY))
                .collect(Collectors.toList());

        AtomicInteger i= new AtomicInteger();
        searchedList.forEach((e)->{
            e.sale(10);
            System.out.println(e);
            i.getAndIncrement();
        });

        System.out.println(i+ " Elementi Trovati");

    }
}