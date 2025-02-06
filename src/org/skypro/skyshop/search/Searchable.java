package org.skypro.skyshop.search;

public interface Searchable {

    String searchTerm();

    String getContentType();

    //String getSearchableName();

    default String getStringRepresentation() {
        return  "имя Searchable -объекта — тип Searchable -объекта";
    }

}
