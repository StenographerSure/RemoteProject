package org.skypro.skyshop.product;

public abstract class Product implements Searchable {
    private final String name;


    public Product(String name) {
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
    public String getSearchableName() {
        return this.name;
    }


}
