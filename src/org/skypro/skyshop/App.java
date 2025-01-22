package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        ProductBasket productBasket = new ProductBasket();
        Product apple = new SimpleProduct("Apple", 5);
        Product banana = new DiscountedProduct("Banana", 20, 35);
        Product sausage = new DiscountedProduct("Sausage", 50, 5);

        productBasket.addProduct(apple);
        productBasket.addProduct(banana);
        productBasket.addProduct(new FixPriceProduct("Egg"));
        productBasket.addProduct(sausage);
        productBasket.addProduct(apple);

        productBasket.addProduct(banana);

        productBasket.displayBasket();


    }
}