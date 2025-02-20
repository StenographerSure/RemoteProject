package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {

    private final Map<String, List<Product>> map = new HashMap<>();
    private final LinkedList<Product> products = new LinkedList<>();
    private boolean isEmpty;

    public void addProduct(Product product) {

        if (!map.containsKey(product.getName())) {
            LinkedList<Product> products1 = new LinkedList<>();
            products1.add(product);
            map.put(product.getName(), products1);
        } else {
            map.get(product.getName()).add(product);
        }
        isEmpty = false;
    }

    public int getTotal() {
        int sum = 0;

        if (!isEmpty) {
            for (List<Product> productList : map.values()) {
                for (Product product : productList) {
                    sum = sum + product.getPrice();
                }
            }
        }
        return sum;
    }

    public void displayBasket() {

        if (isEmpty) {
            System.out.println("в корзине пусто");
        } else {
            int specialProducts = 0;
            for (List<Product> productList : map.values()) {
                for (Product product : productList) {
                    System.out.println(product.toString());
                    if (product.isSpecial()) {
                        specialProducts++;
                    }
                }
            }
            System.out.println("Итого: " + getTotal());
            System.out.println("Специальных товаров: " + specialProducts);
        }
    }

    public boolean checkProduct(String productName) {
        boolean isPresent = false;
        if (!isEmpty) {
            for (List<Product> productList : map.values()) {
                for (Product product : productList) {
                    if (product.getName().equals(productName)) {
                        isPresent = true;
                        break;
                    }
                }
            }
        }
        return isPresent;
    }

    public void clear() {
        map.clear();
        isEmpty = true;
    }

    public List<Product> deleteItem(String name) {

        List<Product> productList = new LinkedList<>();

        if (map.containsKey(name)) {
            productList = map.get(name);
            map.remove(name);
        }
        return productList;
    }

}
