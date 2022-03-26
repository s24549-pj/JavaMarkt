package pl.pjait;

import javax.swing.*;
import java.util.Arrays;
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
//          do domu
//
//    public Product[] sortProductsByName(Product[] products){
//
//    }
//
//    public Product[] sortProductsByPrice(Product[] products){
//
//    }

    public double getSumOfCart(Cart cart){
        double totalPrice = 0;

        for (Product product : cart.getProducts()){
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
