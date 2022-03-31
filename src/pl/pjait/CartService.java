package pl.pjait;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CartService {

    public Product getCheapestOne(List<Product> products){
        Product temporaryProduct = new Product();
        temporaryProduct.setPrice(99999);

        for (Product product : products) {
            if(product.getPrice() < temporaryProduct.getPrice()){
                temporaryProduct = product;
            }
        }
        return temporaryProduct;
    }

    public Product getExpensiveOne(List<Product> products){
        Product temporaryProduct = new Product();
        temporaryProduct.setPrice(0);

        for (Product product : products) {
            if(product.getPrice() >= temporaryProduct.getPrice()){
                temporaryProduct = product;
            }
        }
        return temporaryProduct;
    }

    public List<Product> sortProductsByName(List<Product> products){
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
//                Ciekawie wyglada ale sortuje tylko po 1 literze, nie patrzy na pozostale litery (np. kUbek > kAwa)
//                return Integer.valueOf((int) o1.getName().toLowerCase().charAt(0)).compareTo((int) o2.getName().toLowerCase().charAt(0));
                return (o1.getName()).compareTo(o2.getName());
            }
        });
        return products;
    }

    public List<Product> sortProductsByPrice(List<Product> products){
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Integer.valueOf((int) o1.getPrice()).compareTo((int) o2.getPrice());
            }
        });
        return products;
    }

    public double getSumOfCart(Cart cart){
        double totalPrice = 0;

        for (Product product : cart.getProducts()){
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
