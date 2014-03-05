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
    private static int maxPalindromeLength(final String s, int current) {
        Preconditions.checkNotNull(s);
        Preconditions.checkArgument(current >= 0);
        int left = current;
        int right = current;
              if (left > 0 && right < s.length() - 1 && s.charAt(left - 1) == s.charAt(right + 1)) {
                  left--;
                  right++;
              } else if (right < s.length() - 1 && s.charAt(left) == s.charAt(right + 1)) {
                  right++;
              } else if (left > 0 && s.charAt(left - 1) == s.charAt(right))  {
                  left--;
              } else return 1;

              while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                  left--;
                  right++;
              }

              return ((right - left) > s.length() ? s.length() : (right - left));
    }

    public static int lengthOfLongestPalidrome(final String str) {

        Preconditions.checkNotNull(str);
        if (str.length() == 0) return 0;
        if (str.length() == 1) return 1;
        int max = 0;
        int current_index = 0;

        for (int i = 0;i < str.length(); i++) {
            int length = maxPalindromeLength(str, i);
            if (max < length) {
                max = length;
                current_index = i;
            }
        }

        return max;
    }

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


    /**
     * Optimized Naive String Matching algorithm as mentioned in the problem 32.1-2 in "Introduction to Algorithm"
     * @param originalString    the original string to find pattern in.
     * @param patternToSearch   the pattern to look for.
     * @return  true of the pattern is matched, false otherwise
     */
    public static Boolean naiveStringMatchingOptimized(final String originalString, final String patternToSearch) {
        Preconditions.checkNotNull(originalString);
        Preconditions.checkNotNull(patternToSearch);

        if (patternToSearch.isEmpty()) {

            // returns true since empty string is valid substring of all strings
            return true;
        }

        // Assuming all characters in pattern string are different
        int oLength = originalString.length();
        int pLength = patternToSearch.length();
        for (int i = 0; i <= oLength - pLength;) {
            int j = 0;
            int k = i;
            while (j < pLength
                    && originalString.charAt(k) == patternToSearch.charAt(j)) {
                k++;
                j++;
            }

            if (j == pLength) {
                return true;
            }

            i += (j == 0 ? 1 : j);
        }

        return false;
    }

    public static void decodeUrl(String str) {
        if (str == null) throw new RuntimeException();
        if (str.length() <= 2) return;
        char[] ch = str.toCharArray();
        int current = 0;
        int actual = 0;
        Map<String, Character> map = new HashMap<String, Character>();
        map.put("%20", ' ');
        map.put("%3A", '?');
        map.put("%3D", ':');
        while (current <= str.length() - 3) {
            while(ch[current] != '%') {
                ch[actual++] = ch[current++];
            }

            char newCh = '\0';
            String temp = ((Character)ch[current]).toString() + ((Character)ch[current + 1]).toString() + ((Character)ch[current + 2]).toString();
            if (map.containsKey(temp)) {
                newCh = map.get(temp);
            }

            if (newCh != '\0') {
                ch[actual++] = newCh;
                current += 3;
                newCh = '\0';
            }
            else {
                current++;
                actual++;
            }

        }

        while (current < str.length()) {
            ch[actual++] = ch[current++];
        }

        ch[actual] = 0;
        str = new String (ch);
        return;
    }
}
