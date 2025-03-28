package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.product.*;


public class App {
    public static void main(String[] args) throws BestResultNotFound {

        ProductBasket productBasket = new ProductBasket();

        SearchEngine searchEngine = new SearchEngine();

        Product apple = new SimpleProduct("apple", 5);
        Product banana = new DiscountedProduct("Banana", 20, 35);
        Product sausage = new DiscountedProduct("Sausage", 50, 5);

        productBasket.addProduct(apple);
        productBasket.addProduct(banana);
        productBasket.addProduct(sausage);

        searchEngine.add(apple);
        searchEngine.add(banana);
        searchEngine.add(sausage);

        searchEngine.add(new SimpleProduct("applesauce", 15));
        searchEngine.add(new SimpleProduct("applejam", 15));

        searchEngine.add(new Article("A New app", "delicious applications beginning"));
        searchEngine.add(new Article("New app", "appappapp"));




        //demo

        productBasket.displayBasket();

        System.out.println("\n");

        System.out.println(productBasket.deleteItem("apple"));

        if (productBasket.deleteItem("Snake").isEmpty())
            System.out.println("\n" + "Список пуст" + "\n");

        productBasket.displayBasket();

        System.out.println("\n");

        System.out.println(searchEngine.search("app"));



    }
}