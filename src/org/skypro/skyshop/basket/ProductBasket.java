package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    private final LinkedList<Product> products = new LinkedList<>();
    private boolean isEmpty;

    public void addProduct(Product product) {
        products.add(product);
        isEmpty = false;
    }

    public int getTotal() {
        int sum = 0;

        if (!isEmpty) {
            for (Product product : products) {
                sum = sum + product.getPrice();
            }
        }
        return sum;
    }

    public void displayBasket() {

        if (isEmpty) {
            System.out.println("в корзине пусто");
        } else {
            int specialProducts = 0;
            for (Product product : products) {
                System.out.println(product.toString());
                if (product.isSpecial()) {
                    specialProducts++;
                }

            }
            System.out.println("Итого: " + getTotal());
            System.out.println("Специальных товаров: " + specialProducts);
        }

    }

    public boolean checkProduct(String productName) {
        boolean isPresent = false;
        if (!isEmpty) {
            for (Product product : products) {
                if (product.getName().equals(productName)) {
                    isPresent = true;
                    break;
                }
            }
        }
        return isPresent;

    }

    public void clear() {
        products.clear();
        isEmpty = true;
    }
    public List<Product> deleteItem(String name){
        List<Product> productList = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();
        while(iterator.hasNext()){
            Product element = iterator.next();
            if(Objects.equals(element.getName(), name)){
                productList.add(element);
                iterator.remove();
            }
        }
        return productList;
    }

}
