package org.vikastaneja.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vikastaneja on 3/17/14.
 */
public class MergePairs {
    static List<Integer> list = new ArrayList<Integer>();

    private static void insertEnd(List<Integer> list, Integer y) {

        if (y == null)
            throw new RuntimeException("y can't be null");

        if (list == null)
            throw new RuntimeException("List can't be null");

        if (list.size() == 0) {
            list.add(y);
            list.add(null);
            return;
        }

        List<Integer> ret = new ArrayList<Integer>();

        for (int i = 0; i < list.size();) {
            while(i < list.size() && list.get(i) < y) {
                ret.add(list.get(i++));
            }

            ret.add(y);
            ret.add(null);

            while (i < list.size()) {
                ret.add((list.get(i++)));
            }
        }

        list = ret;
        return;

    }

    public static List<Pair> merge(List<Pair> pairs) {
        if (pairs == null) throw new RuntimeException("List of pairs can't be null");

        if (pairs.size() <= 1) return pairs;

        List<Integer> list = new ArrayList<Integer>();

        for (Pair p : pairs) {
            list.add(p.x);
        }

        for (Pair p : pairs) {
            insertEnd(list, p.y);
        }

        List<Pair> retPairs = new ArrayList<Pair>();
        Object[] arr = pairs.toArray();
        Pair p = null;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i+1] != null && p == null) {
                p = new Pair();
                p.x = (Integer) arr[i];
                continue;
            }

            if (arr[i+1] == null && ((i + 3 < arr.length && arr[i + 3] != null) || i+2 >= arr.length)) {
                p.y = (Integer) arr[i];
                retPairs.add(p);
                i+=1;
                p = null;
                continue;
            }
        }

        return retPairs;
    }
}
