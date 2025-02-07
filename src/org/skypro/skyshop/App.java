package org.skypro.skyshop;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.product.*;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws BestResultNotFound {

        SearchEngine searchEngine = new SearchEngine(10);

        Product apple = new SimpleProduct("apple", 5);
        Product banana = new DiscountedProduct("Banana", 20, 35);
        Product sausage = new DiscountedProduct("Sausage", 50, 5);
        searchEngine.add(apple);
        searchEngine.add(banana);
        searchEngine.add(sausage);
        searchEngine.add(new SimpleProduct("applesauce", 15));
        searchEngine.add(new SimpleProduct("applejam", 15));
        searchEngine.add(new Article("New app", "delicious applications beginning"));
        searchEngine.add(new Article("New app", "appappapp"));

        try {
            Product product = new SimpleProduct("new", 0);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Product product = new DiscountedProduct("   ", 0, 105);
        } catch (Exception e) {
            System.out.println(e);
        }

        //System.out.println(Arrays.toString(searchEngine.search("apple")));

        try {
            System.out.println(searchEngine.searchPrecise("app"));
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            System.out.println(searchEngine.searchPrecise("JOB"));
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}