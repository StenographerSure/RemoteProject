package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;


public class ProductBasket {
    private final Product[] products = new Product[5];
    private boolean isEmpty;

    public void addProduct(Product product) {
        if (products[products.length-1] != null) {
            System.out.println("Невозможно добавить продукт");
            return;
        }

        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                break;
            }
        }
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
            for (Product product : products) {
                System.out.println(product.getName() + ": " + product.getPrice());
            }
            System.out.println("Итого: " + getTotal());
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
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        isEmpty = true;
    }

}
