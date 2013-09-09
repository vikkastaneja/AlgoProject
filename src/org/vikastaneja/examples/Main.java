/**
 * Created with IntelliJ IDEA.
 * User: vikastaneja
 * Date: 9/5/13
 * Time: 1:32 AM
 * To change this template use File | Settings | File Templates.
 */
package org.vikastaneja.examples;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        HashSet<Integer> tset = new HashSet<Integer>();

        for (int i = 1; i < 100; i++) {
            tset.add(i);
        }

        Pythagorean py = new Pythagorean();
        Set<Set<Integer>> temp = py.getPythagorean(tset);
        Iterator<Set<Integer>> iter = temp.iterator();
        while(iter.hasNext()) {
            System.out.println();
            Set<Integer> set = iter.next();
            Iterator<Integer> iset = set.iterator();
            while (iset.hasNext()) {
                System.out.print(iset);
                System.out.print("\t");
            }

            System.out.println();
        }
    }
}
