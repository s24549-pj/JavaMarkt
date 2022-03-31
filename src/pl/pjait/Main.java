package pl.pjait;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Product product = new Product();

        product.setName("cukier");
        product.setCode("12344");
        product.setPrice(350.00);
        product.setDiscountPrice(40.00);


        Product product2 = new Product("232", "mleko", 10.00, 5.0);
        Product product3 = new Product("234", "kawa", 5.0, 2.0);

        List<Product> productList = new ArrayList<>();
                productList.add(product);
                productList.add(product2);
                productList.add(product3);
                productList.add(new Product("111", "woda", 2.0, 1.0));
                productList.add(new Product("125", "piwo", 3.0, 2.0));



        Cart cart = new Cart();
        cart.setProducts(productList);


        System.out.println("Cart after discount: ");
        ICanCalculateSpecialOffer discount300Plus = new Discount300Plus();
        ICanCalculateSpecialOffer thirdForFree = new ApplyDiscountThirdForFree();
        ICanCalculateSpecialOffer freeCup = new ApplyFreeCup();
        cart.applyDiscount(discount300Plus);
        cart.applyDiscount(thirdForFree);
        cart.applyDiscount(freeCup);

        System.out.println(cart.toString());



        System.out.println("---------------------------");
        System.out.println("Before sorting by price:");
        System.out.println(cart.toString());

        CartService cartService = new CartService();
        cartService.sortProductsByPrice(productList);

        System.out.println("After sorting by price:");
        System.out.println(cart.toString());

        System.out.println("---------------------------");
        System.out.println("Before sorting by name:");
        System.out.println(cart.toString());

        cartService.sortProductsByName(productList);

        System.out.println("After sorting by name:");
        System.out.println(cart.toString());

    }
}
