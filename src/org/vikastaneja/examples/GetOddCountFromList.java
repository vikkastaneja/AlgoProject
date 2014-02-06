package org.vikastaneja.examples;

import com.google.common.base.Preconditions;

import java.util.*;
import java.util.HashMap;

/**
 * Problem: Find numbers from a list that are present odd number of times. Preferably O(n) in time complexity
 * Created with IntelliJ IDEA.
 * User: vttaneja
 * Date: 2/5/14
 * Time: 8:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class GetOddCountFromList {
    List<Integer> getOddCountNumbers(final List<Integer> list) {
        Preconditions.checkArgument(list != null);
        Preconditions.checkArgument(list.size() != 0);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : list) {
            if (map.containsKey(i)) {
                int temp = map.get(i);
                temp ++;
                map.put (i, temp);
            }
            else {
                map.put(i, 1);
            }
        }

        List<Integer> returnList = new ArrayList<Integer>();
        for (int i : map.keySet()) {
            int temp = map.get(i);
            if (temp % 2 != 0) {
                returnList.add(i);
            }
        }

        return returnList;
    }
}
