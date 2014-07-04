package org.vikastaneja.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vikastaneja
 * Date: 9/8/13
 * Time: 11:49 PM
 * To change this template use File | Settings | File Templates.
 */
public final class MergeTwoSortedLists<T extends Integer> {

    /**
     * Merge two sorted lists.
     * @param list1
     * @param list2
     * @return
     */
    public List<T> mergeLists(final List<T> list1, final List<T> list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        int len1 = list1.size();
        int len2 = list2.size();
        List<T> list3 = new ArrayList<T>();
        int i = 0, j = 0;
        while(i < len1 && j < len2) {
            int i1 = (Integer)list1.get(i);
            int i2 = (Integer)list2.get(j);

            if (i1 <= i2) {
                list3.add(list1.get(i++));

                if (i1 == i2) {
                    j++;
                }
            }
            else {
                list3.add(list2.get(j++));
            }
        }

        while (i < len1) {
            list3.add(list1.get(i++));
        }

        while (j < len2) {
            list3.add(list2.get(j++));
        }

        return list3;
    }
}
