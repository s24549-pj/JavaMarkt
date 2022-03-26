package pl.pjait;

import java.util.Arrays;
import java.util.List;

public class Cart {

    private List<Product> products;

    public Cart() {
    }

    public Cart(List<Product> products) {

        this.products = products;
    }

    public List<Product> getProducts() {

        return products;
    }

    public void setProducts(List<Product> products) {

        this.products = products;
    }

    public void addNewProductToCart(Product product){

        products.add(product);
    }

    public void applyDiscount(ICanCalculateSpecialOffer disount){
        if (disount.canCalculate(this)){
            disount.calculateOffer(this);
        }
    }


    @Override
    public String toString() {
        return "Cart{" +
                "products=" + products +
                '}';
    }
}
