package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {

        ProductBasket productBasket = new ProductBasket();
        Product apple = new Product("Apple", 5);
        Product banana = new Product("Banana", 9);

        productBasket.AddProduct(apple);
        productBasket.AddProduct(banana);
        productBasket.AddProduct(new Product("Egg", 15));
        productBasket.AddProduct(banana);
        productBasket.AddProduct(apple);

        productBasket.AddProduct(banana);

        productBasket.DisplayBasket();

        System.out.println(productBasket.GetTotal());

        System.out.println(productBasket.CheckProduct("Egg"));

        System.out.println(productBasket.CheckProduct("Pineapple"));

        productBasket.Clear();

        productBasket.DisplayBasket();

        System.out.println(productBasket.GetTotal());

        System.out.println(productBasket.CheckProduct("Egg"));


    }
}