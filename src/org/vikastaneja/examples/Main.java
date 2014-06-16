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

        char[][]arr111 = {{'a','b','c'},
                       {'b','e','f'},
                       {'g','h','i'}};
        String str111 = "abe";
        int retValue = MiscPrograms.timesFound(arr111, str111);

        System.out.println(MiscProblems.instanceCompare("", ""));
        System.out.println(MiscProblems.instanceCompare("abc", "aa"));
        System.out.println(MiscProblems.instanceCompare("aa", "abc"));
        System.out.println(MiscProblems.instanceCompare("abc", "abc"));
        System.out.println(MiscProblems.instanceCompare("aaabbddddd", "ddcccccccb"));



        String tstr = "a?bc?cb?";
        MiscProblems.replaceMarkWith0and1(tstr);

        String s = "1 0 1 0 0 1 0 1";
        boolean[] barray = MaxNumberBits.stringToBitarray(s);
        //{true,false,true,false,false,true,false,true};

        MiscProblems.printCombinationsOfZeroAndOne(-1);
        MiscProblems.printCombinationsOfZeroAndOne(0);

        MiscProblems.printCombinationsOfZeroAndOne(1);

        MiscProblems.printCombinationsOfZeroAndOne(2);
        MiscProblems.printCombinationsOfZeroAndOne(3);
        MiscProblems.printCombinationsOfZeroAndOne(4);

        //1, 0, 1, 0, 0, 1, 0, 1
        System.out.println(MaxNumberBits.FindMax(barray));

        List<Intervals> lister = new ArrayList<Intervals>();
        lister.addAll(Arrays.asList(new Intervals(1,7), new Intervals(3,6), new Intervals(8,10)));

        MiscProblems.mergeIntervals(lister);
        byte[]b1 = {1,3,5,0,6,7,8,9};
        byte[]b2 = {-1,0,-45,4,2,5,0};
        MiscPrograms.printDuplicates(null, new byte[]{});

        int[][]array = {{0,0,0},{0,1,1},{0,0,1}};
        System.out.println(IslandProblem.isIslandPresent(array,3,3));

        List<Pair>list1 = new ArrayList<Pair>();
        Pair p1 = new Pair();
        p1.x = 1;
        p1.y = 3;
        Pair p2 = new Pair();
        p2.x = 2;
        p2.y = 5;
        Pair p3 = new Pair();
        p3.x = 6;
        p3.y = 9;
        Pair p4 = new Pair();
        p4.x = 5;
        p4.y = 11;
        list1.addAll(Arrays.asList(p1, p2, p3, p4));
        List<Pair> retList1 = MergePairs.merge(list1);

        System.out.println(3 & ~2);
        BinaryTreeNode a = new BinaryTreeNode();
        a.setValue(1);
        BinaryTreeNode b = new BinaryTreeNode();
        b.setValue(2);
        BinaryTreeNode c = new BinaryTreeNode();
        c.setValue(3);
        BinaryTreeNode d = new BinaryTreeNode();
        d.setValue(4);
        BinaryTreeNode e = new BinaryTreeNode();
        e.setValue(5);
        BinaryTreeNode f = new BinaryTreeNode();
        f.setValue(6);
        BinaryTreeNode g = new BinaryTreeNode();
        g.setValue(7);

        e.setLeft(g);
        c.setLeft(f);
        b.setLeft(d);
        b.setRight(e);
        a.setLeft(b);
        a.setRight(c);

        System.out.println("=====>>> " + BinaryTreeProblems.isBalanced(a));
        int[] arr = {1,2,3,4,5,6,1,5};
        int[] a1 = {1,2,3};
        Recursive.printSubsets(a1);
        MiscPrograms.printPairsWithSum(arr, 5);

        MiscPrograms.rotateArray(arr, 3);
        String str = "This%20is";
        StringProcessing.decodeUrl(str);

        System.out.println("Length of longest palindrome string: " + StringProcessing.lengthOfLongestPalidrome("dcabbac"));

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
