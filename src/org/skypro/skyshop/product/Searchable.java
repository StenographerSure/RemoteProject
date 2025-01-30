package org.skypro.skyshop.product;

public interface Searchable {

    String searchTerm();

    String getContentType();

    String getSearchableName();

    default String getStringRepresentation() {
        return getSearchableName() + " - " + getContentType();
    }

}
