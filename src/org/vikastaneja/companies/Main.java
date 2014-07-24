package org.vikastaneja.companies;

import java.util.*;

/**
 * Created by vikastaneja on 7/23/14.
 */
public class Main {
    public static void main(String []args) {
        String s = "abc";
        Expedia.permutation(s);
        Expedia.parentesis(3);

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Expedia.printSubsets(list);
    }
}
