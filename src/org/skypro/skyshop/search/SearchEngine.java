package org.skypro.skyshop.search;

import com.sun.source.tree.Tree;
import org.skypro.skyshop.comparator.SearchableComparator;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.Product;

import java.util.*;

public class SearchEngine {

    //private final List<Searchable> searchables = new ArrayList<>();
    private final Set<Searchable> searchablesSet = new HashSet<>();


    public Set<Searchable> search(String SearchTerm) {


        SearchableComparator searchableComparator = new SearchableComparator();
        Set<Searchable> results = new TreeSet<Searchable>(searchableComparator);

        Iterator<Searchable> iterator = searchablesSet.iterator();
        while (iterator.hasNext()) {
            Searchable element = iterator.next();
            if (element != null && element.toString().contains(SearchTerm)) {
                results.add(element);
            }
        }

        return results;
    }

    public Searchable searchPrecise(String SearchTerm) throws BestResultNotFound {

        List<Searchable> results = new LinkedList<>();
        Iterator<Searchable> iterator = searchablesSet.iterator();

        int preciseSearchableID = -1;
        int tempQuantity = 0;
        Searchable bestmatch = null;

        while (iterator.hasNext()) {
            int quantity = 0;
            Searchable element = iterator.next();

            if (element != null && !element.toString().isBlank()) {
                for (int index = 0; (index = element.toString().indexOf(SearchTerm, index)) != -1; index += SearchTerm.length())
                    quantity++;
            }

            if (quantity > tempQuantity) {

                bestmatch = element;
                tempQuantity = quantity;
            }
        }
        if (bestmatch != null) {
            //System.out.println(tempQuantity);
            return bestmatch;
        } else {
            throw new BestResultNotFound("Can't find objects with set string");
        }

    }


    public void add(Searchable searchable) {
        searchablesSet.add(searchable);

    }
}
