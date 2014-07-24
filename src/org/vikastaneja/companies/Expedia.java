package org.vikastaneja.companies;

import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vikastaneja on 7/22/14.
 * This class will have algorithm questions from http://www.careercup.com/page?pid=expedia-interview-questions
 */
public class Expedia {
    /**
     * You have a LinkList with each node having Next node and Other node and Data.
     i.e. Class Node
     {
     Node Next;
     Node Other;
     int Data;
     }

     Next pointer always points to next node and Other node can point to any other node in the list or can be pointing to null/nothing or can point to self.

     Write program to copy this link list to a new list with proper Next and Other pointers.
     * @param head
     * @return
     */
    public static LinkedListNode copyLinkedListWithOtherPointer(LinkedListNode head) {
        throw new NullPointerException("Method is not yet implemented");
    }

    /**
     * Given a string, print the character which appears the maximum number of times in the string.
     The string will contain only ascii characters. If there is a tie in the maximum number
     of times a character appears in the string, print the character which appears first in the string.

     Notes:
     1. The length of the string will be between 1 and 10000, inclusive.
     2. Make sure you don't print anything other than a single character in the function. Otherwise, your solution will be marked wrong.
     3. You only need to complete the function printMaximumOccurringCharacter.
     * @param sentence
     */
    public static void printMaximumOccurringCharacter(String sentence) {
        throw new NullPointerException("Method is not yet implemented");
    }

    /**
     * Print all permutations of a string
     * @param str
     */
    public static void permutation(String str) {
        permutation("", str);
    }

    /**
     * Helper method ofr {@link org.vikastaneja.companies.Expedia#permutation(String)}
     * @param prefix
     * @param str
     */
    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }

    /**
     * Helper function for {@link org.vikastaneja.companies.Expedia#parentesis(int)}
     * @param s
     * @param open
     * @param close
     */
    private static void validCombinations(String s, int open, int close) {
        if (open > close) {
            return;
        }

        if (open == 0 && close == 0) {
            System.out.println(s);
            return;
        }

        if (open < 0 || close < 0)
            return;

        validCombinations(s + "(", open - 1, close);
        validCombinations(s + ")", open, close - 1);
    }

    /**
     * Print all valid parenthesis
     * @param n
     */
    public static void parentesis(int n) {
        validCombinations("", n, n);
    }

    /**
     * Prints all subsets of a list
     * @param list
     */
    public static void printSubsets(List<Integer> list) {
        int max = (int)Math.pow(2, list.size());

        for (int i = 0; i < max; i++) {
            // Convert int to bitset
            BitSet bs = getConvertedBitSet(i, list.size());

            // Use bitset to print the subset
            printSubset(bs, list);
        }
    }

    /**
     * Helper function for {@link org.vikastaneja.companies.Expedia#printSubsets(java.util.List)}<br/>
     * This function prints the subsets for the bits that are set in bitset<br/>
     * @see <a href="http://stackoverflow.com/a/24927698/2464905">Link to stackoverflow</a>
     * @param bs
     * @param list
     */
    private static void printSubset(BitSet bs, List<Integer> list) {
        if (list == null) {
            throw new NullPointerException("Set is empty");
        }

        System.out.print("{ ");
        for (int i = 0; i < list.size();i++) {
            if (bs.get(i)) {
                System.out.print(list.get(i) + " ");
            }
        }

        System.out.print("}");

        System.out.println();
    }

    /**
     * Helper function for {@link org.vikastaneja.companies.Expedia#printSubsets(java.util.List)}<br/>
     * This function converts an integer to the bitset
     * @param value
     * @param size
     * @return
     */
    private static BitSet getConvertedBitSet(int value, int size) {
        BitSet bits = new BitSet(size);
        bits.set(0, size - 1, false);
        int index = 0;
        while (value != 0) {
            if (value % 2 != 0) {
                bits.set(index);
            }
            ++index;
            value = value >>> 1;
        }
        return bits;
    }
}
