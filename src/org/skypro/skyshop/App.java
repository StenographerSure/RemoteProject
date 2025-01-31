package org.skypro.skyshop;

import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.product.*;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        SearchEngine searchEngine = new SearchEngine(10);

        Product apple = new SimpleProduct("apple", 5);
        Product banana = new DiscountedProduct("Banana", 20, 35);
        Product sausage = new DiscountedProduct("Sausage", 50, 5);
        searchEngine.add(apple);
        searchEngine.add(banana);
        searchEngine.add(sausage);
        searchEngine.add(new SimpleProduct("applesauce", 15));
        searchEngine.add(new SimpleProduct("applejam", 15));
        searchEngine.add(new Article("New apples", "delicious beginning"));
        searchEngine.add(new Article("New dawn", "It began"));


        System.out.println(Arrays.toString(searchEngine.search("apple")));


    }
}