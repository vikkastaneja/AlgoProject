package org.vikastaneja.examples;

import com.google.common.base.Preconditions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: vttaneja
 * Date: 9/12/13
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringProcessing {
    public static boolean hasAllUniqueCharacters(final String str) {
        Preconditions.checkNotNull(str);
        if (str.length() <= 1) {
            return true;
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                return false;
            }

            map.put(c, 1);
        }

        return true;
    }

    public static boolean areAnagrams(final String s1, final String s2) {
        Preconditions.checkNotNull(s1);
        Preconditions.checkNotNull(s2);

        if (s1.length() == 0 && s2.length() == 0) {
            return true;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (char c : s1.toCharArray()) {
            if (map.containsKey(c)) {
                Integer i = map.get(c);
                i++;
                map.put(c, i);
            }
            else {
                map.put(c, 1);
            }
        }

        for (char c : s2.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }

            if (map.get(c) <= 0) {
                return false;
            }

            Integer i = map.get(c);
            i--;
            map.put(c,i);
        }

        for(Integer i : map.values()) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
