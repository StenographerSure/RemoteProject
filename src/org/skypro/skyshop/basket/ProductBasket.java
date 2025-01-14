package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;


public class ProductBasket {
    private final Product[] products = new Product[5];
    private boolean isEmpty;

    public void AddProduct(Product product) {
        if (products[4] != null) {
            System.out.println("Невозможно добавить продукт");
            return;
        }

        for (int i = 0; i <= 4; i++) {
            if (products[i] == null) {
                products[i] = product;
                break;
            }
        }
        isEmpty = false;

    }

    public int GetTotal() {
        int sum = 0;

        if (!isEmpty) {
            for (Product product : products) {
                sum = sum + product.getPrice();
            }
        }
        return sum;
    }

    public void DisplayBasket() {

        if (isEmpty) {
            System.out.println("в корзине пусто");
        } else {
            for (Product product : products) {
                System.out.println(product.getName() + ": " + product.getPrice());
            }
            System.out.println("Итого: " + GetTotal());
        }

    }

    public boolean CheckProduct(String productName) {
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

    public void Clear() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        isEmpty = true;
    }

}
