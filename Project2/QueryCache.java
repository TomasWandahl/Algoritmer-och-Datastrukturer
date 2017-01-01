package se.kth.vandahl.project2;

/**
 * Created by Tomas Wändahl on 2016-12-31.
 * All rights reserved.
 * Yeah.
 */

        import java.util.HashMap;

public class QueryCache <T> {
    HashMap<QueryExpression, T> cache = new HashMap<>();

    public void put (QueryExpression qe, T result) {
        cache.put(qe, result);
    }

    public T get (QueryExpression qe) {
        if (cache.containsKey(qe)) {
            return cache.get(qe);
        } else {
            return null;
        }
    }

    public boolean hasCachedResult (QueryExpression qe) {
        return this.get(qe) != null;
    }
}