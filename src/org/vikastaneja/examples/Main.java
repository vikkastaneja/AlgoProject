/**
 * Created with IntelliJ IDEA.
 * User: vikastaneja
 * Date: 9/5/13
 * Time: 1:32 AM
 * To change this template use File | Settings | File Templates.
 */
package org.vikastaneja.examples;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Arr arr1 = new Arr();
        Arr arr2 = new Arr();
        arr1.array = new Integer[]{0,2};
        arr1.min = 0;
        arr1.max = 1;

        arr2.array = new Integer[] {1,3};
        arr2.min = 0;
        arr2.max = 1;

        System.out.println(MiscPrograms.findKth(arr1, arr2, 2));
        String original = "aaaabc";
        String pattern = "abc";
        Boolean isMatching = StringProcessing.naiveStringMatchingOptimized(original, pattern);

        LinkedList linkedList = new LinkedList();
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        linkedList.addNode(5);
        linkedList.addNode(6);
        linkedList.addNode(7);
        linkedList.modifyList();

        List<Integer> list = new ArrayList<Integer>();
        list.addAll(Arrays.asList(1,1,1,2,3,5,3,2,1,3,4,5,6,3,5,67,3,2,2,4,65,7,8,4,32));

        List<Integer> retList = new GetOddCountFromList().getOddCountNumbers(list);
        for (int i : retList) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Hello World");
        HashSet<Integer> tset = new HashSet<Integer>();

        for (int i = 1; i < 100; i++) {
            tset.add(i);
        }

        /*Pythagorean py = new Pythagorean();
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
        }*/

        System.out.println(StringProcessing.hasAllUniqueCharacters(""));
        System.out.println(StringProcessing.hasAllUniqueCharacters("a"));
        System.out.println(StringProcessing.hasAllUniqueCharacters("abcdefgh"));
        System.out.println(StringProcessing.hasAllUniqueCharacters("abcdeflk w[ "));

        System.out.println("****Now validating Anagrams*****");
        System.out.println(StringProcessing.areAnagrams("", ""));
        System.out.println(StringProcessing.areAnagrams("abc","abcd"));
        System.out.println(StringProcessing.areAnagrams("anagrams", "naagsmra"));
        System.out.println(StringProcessing.areAnagrams("anagrams ", " naagsmra"));
        System.out.println(StringProcessing.areAnagrams("anagramas", "naagsmras"));
    }
}
