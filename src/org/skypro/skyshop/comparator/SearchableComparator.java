package org.skypro.skyshop.comparator;


import org.skypro.skyshop.search.Searchable;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {


    @Override
    public int compare(Searchable o1, Searchable o2) {

        if (o1.searchTerm().length() == o2.searchTerm().length()) {
            return o2.searchTerm().compareTo(o1.searchTerm());
        } else {
            return Integer.compare(o2.searchTerm().length(), o1.searchTerm().length());
        }

    }
}
