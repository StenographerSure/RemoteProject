package org.skypro.skyshop.search;

public interface Searchable {

    String searchTerm();

    String getContentType();

    default String getStringRepresentation() {
        return  "имя Searchable -объекта — тип Searchable -объекта";
    }

}
