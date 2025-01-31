package org.skypro.skyshop.search;

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

    public void add(Searchable searchable) {
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i] = searchable;
                break;
            }
        }
    }
}
