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
//        int sum = 0;

//        if (!isEmpty) {
//            for (List<Product> productList : map.values()) {
//                for (Product product : productList) {
//                    sum = sum + product.getPrice();
//                }
//            }
//        }
        return map.values()
                .stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice).sum();
    }

    public void displayBasket() {

        if (isEmpty) {
            System.out.println("в корзине пусто");
        } else {
            map.values()
                    .stream()
                    .flatMap(Collection::stream)
                    .forEach(System.out::println);

            System.out.printf("Итого: %d%n", getTotal());
            System.out.printf("Специальных товаров: %d%n", getSpecialCount());
        }
    }

    public boolean checkProduct(String productName) {
        boolean isPresent = false;
        if (!isEmpty) {
            if (map.containsKey(productName)) {
                isPresent = true;
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

    private int getSpecialCount() {
        return (int) map.values()
                .stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

}
