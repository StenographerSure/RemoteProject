package org.skypro.skyshop.search;

import com.sun.source.tree.Tree;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.Product;

import java.util.*;

public class SearchEngine {

    private final List<Searchable> searchables = new ArrayList<>();

    //private final Searchable[] searchables;


    public Map<String, Searchable> search(String SearchTerm) {
        //int count = 0;
        Map<String, Searchable> results = new TreeMap<>();
        Iterator<Searchable> iterator = searchables.iterator();
        while (iterator.hasNext()) {
            Searchable element = iterator.next();
            if (element != null && element.toString().contains(SearchTerm)) {
                results.put(element.getStringRepresentation(), element);
            }
        }

        return results;
    }

    public Searchable searchPrecise(String SearchTerm) throws BestResultNotFound {

        List<Searchable> results = new LinkedList<>();
        Iterator<Searchable> iterator = searchables.iterator();

        int preciseSearchableID = -1;
        int tempQuantity = 0;

        while (iterator.hasNext()) {
            int quantity = 0;
            Searchable element = iterator.next();

            if (element != null && !element.toString().isBlank()) {
                for (int index = 0; (index = element.toString().indexOf(SearchTerm, index)) != -1; index += SearchTerm.length())
                    quantity++;
            }

            if (quantity > tempQuantity) {
                preciseSearchableID = searchables.indexOf(element);
                tempQuantity = quantity;
            }
        }
        if (preciseSearchableID > -1) {
            //System.out.println(tempQuantity);
            return searchables.get(preciseSearchableID);
        } else {
            throw new BestResultNotFound("Can't find objects with set string");
        }

    }


    public void add(Searchable searchable) {
        searchables.add(searchable);

    }
}
