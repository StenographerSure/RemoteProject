package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private final String name;


    public Product(String name) {
        if (name.isBlank() || name == null){
            throw new IllegalArgumentException("Name of the product can't be blank or null");
        }
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getStringRepresentation() {
        return this.name;
    }


}
