package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {

        ProductBasket productBasket = new ProductBasket();
        Product apple = new Product("Apple", 5);
        Product banana = new Product("Banana", 9);

        productBasket.addProduct(apple);
        productBasket.addProduct(banana);
        productBasket.addProduct(new Product("Egg", 15));
        productBasket.addProduct(banana);
        productBasket.addProduct(apple);

        productBasket.addProduct(banana);

        productBasket.displayBasket();

        System.out.println(productBasket.getTotal());

        System.out.println(productBasket.checkProduct("Egg"));

        System.out.println(productBasket.checkProduct("Pineapple"));

        productBasket.clear();

        productBasket.displayBasket();

        System.out.println(productBasket.getTotal());

        System.out.println(productBasket.checkProduct("Egg"));


    }
}