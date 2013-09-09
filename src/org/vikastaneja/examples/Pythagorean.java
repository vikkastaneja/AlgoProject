package org.vikastaneja.examples;

import com.google.common.base.Preconditions;
import sun.jvm.hotspot.jdi.IntegerTypeImpl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: vikastaneja
 * Date: 9/5/13
 * Time: 1:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class Pythagorean {
    Set <Set<Integer>> getPythagorean(final Set<Integer> set) {
        Preconditions.checkNotNull(set);
        Preconditions.checkArgument(set.size() > 2);

        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        Set<Set<Integer>> soriginal = new HashSet<Set<Integer>>();
        Integer[] iarr = new Integer[set.size()];
        Integer i = 0;
        for (Integer ii : set) {
            m.put(ii*ii, ii);
            iarr[i++] = ii * ii;
        }

        for (int j = 0; j  < m.size() - 1; j++) {
            for (int k = j+1; k < m.size(); k++) {
                if (m.containsKey(iarr[j] + iarr[k])) {
                    Set<Integer> temp = new HashSet<Integer>();
                    temp.add(m.get(iarr[j]));
                    temp.add(m.get(iarr[k]));
                    temp.add(m.get(iarr[j] + iarr[k]));
                    soriginal.add(temp);
                }
            }

        }
        return soriginal;
    }
}
