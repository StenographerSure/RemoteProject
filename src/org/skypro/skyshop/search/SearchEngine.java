package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

public class SearchEngine {

    private final Searchable[] searchables;

    public SearchEngine(int size) {
        searchables = new Searchable[size];
    }

    public Searchable[] search(String SearchTerm) {
        int count = 0;
        Searchable[] results = new Searchable[5];
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getStringRepresentation().contains(SearchTerm)) {
                results[count] = searchable;
                if (count < 5) {
                    count++;
                } else break;
            }

        }
        return results;
    }

    public Searchable searchPrecise(String SearchTerm) throws BestResultNotFound {

        int preciseSearchableID = -1;
        int tempQuantity = 0;
        for (int i = 0; i < searchables.length; i++) {
            int quantity = 0;
            if (searchables[i] != null && !searchables[i].toString().isBlank()) {
                for (int index = 0; (index = searchables[i].toString().indexOf(SearchTerm, index)) != -1; index += SearchTerm.length())
                    quantity++;
            }


            if (quantity > tempQuantity) {
                preciseSearchableID = i;
                tempQuantity = quantity;
            }
        }

        if (preciseSearchableID > -1) {
            //System.out.println(tempQuantity);
            return searchables[preciseSearchableID];
        } else {
            throw new BestResultNotFound("Can't find objects with set string");
        }


    }

    public void add(Searchable searchable) {
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i] = searchable;
                break;
            }
        }
    }
}
