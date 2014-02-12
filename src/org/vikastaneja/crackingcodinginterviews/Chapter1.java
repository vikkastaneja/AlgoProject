package org.vikastaneja.crackingcodinginterviews;

import com.google.common.base.Preconditions;

import java.util.HashMap;
import java.util.Map;

/**
 * In this file, I will solve all the problems of chapter1
 * Created by vikastaneja on 2/10/14.
 */
public class Chapter1 {
    /**
     * Question: To find if duplicate characters are present in a string.<br/>
     * Solution implementing: Assuming the range is small, keep an array of booleans of 256 characters initialized to false<br/>
     * Parse the string. If the index is set to false, set it to true. If it is set to true, return false.
     * @param str   String to be looked into.
     * @return true if the string has not duplicates. false otherwise.
     */
    public static final Boolean isDuplicatePresent(final String str) {
        Preconditions.checkArgument(str != null);
        if (str.length() <= 1) {
            return true;
        }

        Boolean []arr = new Boolean[256];
        for (int i = 0; i < 256; i++) {
            arr[i] = false;
        }

        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i);
            if (arr[value] == false) {
                arr[value] = true;
            }
            else {
                return false;
            }
        }

        return true;
    }

    /**
     * Problem: Given two string, find if one is permutation of other.
     * Solution: Out of different solution, I have selected to implement it using hashmap.
     * @param s1    First string
     * @param s2    Second string
     * @return  true if string are anagram, false otherwise
     */
    public static final Boolean isAnagram(final String s1, final String s2) {
        Preconditions.checkNotNull(s1);
        Preconditions.checkNotNull(s2);
        int s1Length = s1.length();
        int s2Length = s2.length();
        if (s1Length != s2Length) {
            return false;
        }

        if (s1Length == 0 && s2Length == 0) {
            return true;
        }

        if ((s1Length == 0 && s2Length != 0) || (s2Length == 0 && s1Length != 0)) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s1Length; i++) {
            Character ch = s1.charAt(i);
            if (map.containsKey(ch)) {
                Integer val = map.get(ch);
                val++;
                map.put(ch, val);
            }
            else {
                map.put(ch, 1);
            }
        }

        for (int i = 0; i < s2Length; i++) {
            Character ch = s2.charAt(i);
            if (!map.containsKey(ch)) {
                return false;
            }

            Integer val = map.get(ch);
            val--;
            if (val < 0) {
                return false;
            }

            map.put(ch, val);
        }

        return true;

    }
}
