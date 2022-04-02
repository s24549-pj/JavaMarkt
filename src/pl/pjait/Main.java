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

        System.out.println("---------------------------");
        int numberOfCheapest = 3;
        System.out.println("Get " + numberOfCheapest + " cheapest products");
        System.out.println(cartService.getNCheapestOne(productList, numberOfCheapest));

        System.out.println("---------------------------");
        int numberOfExpensive = 3;
        System.out.println("Get " + numberOfExpensive + " expensive products");
        System.out.println(cartService.getNExpensiveOne(productList, numberOfCheapest));

        System.out.println("---------------------------");
        System.out.println("Stawka VAT: " + InvoicePosition.TAX_5);
        System.out.println("Stawka VAT: " + InvoicePosition.TAX_8);
        System.out.println("Stawka VAT: " + InvoicePosition.TAX_23);

        System.out.println("---------------------------");
        InvoicePosition position = new InvoicePosition(product);
        InvoicePosition position2 = new InvoicePosition(product2);
        Invoice invoice = new Invoice();
        invoice.addPosition(position);
        invoice.addPosition(position2);
        invoice.addPosition(product2);
        invoice.addPosition(product3);
        invoice.addPosition(product3);
        invoice.addPosition(product3);


        printoutInvoice(invoice);

    }


    private static void printoutInvoice(Invoice invoice){
        System.out.println("|NAZWA\t|ILOSC\t|CENA NETTO\t|CENA BRUTTO\t|STAWKA VAT\t|PODATEK");
        System.out.println("******************************************************************");
        for(InvoicePosition p : invoice.getPositions()){
            System.out.print("|" + p.getProduct().getName() + "\t|");
            System.out.print(p.getCount() + "\t\t|");
            System.out.print(p.getNettoPrice() + "\t\t|");
            System.out.print(p.getGrossPrice() + "\t\t\t|");
            System.out.print(p.getTax() + "\t\t|");
            System.out.println(p.getTaxValue());
            System.out.println("-----------------------------------------------------------------");
        }

    }



}
