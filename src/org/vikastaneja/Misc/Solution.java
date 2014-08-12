package org.vikastaneja.Misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by vikastaneja on 8/5/14.
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n = b.read();
        int N = Integer.parseInt(b.readLine());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nums = br.readLine();
        String[] ints = nums.split(" ");

        int K = Integer.parseInt(ints[0]);
        int L = Integer.parseInt(ints[1]);
        int M = Integer.parseInt(ints[2]);


        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        String str = br1.readLine();

        List<Integer> o = new ArrayList<Integer>();
        for (int i = K; i <= L; i++) {
            o.add(numOfTime(str.substring(0, N), i));
        }

        Collections.sort(o);
        System.out.print(o.get(o.size() - 1));
    }

    private static List<String> findAllSubstring(String s, int n) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<String>();
        }

        if (n < 0 || n > s.length()) {
            throw new IllegalArgumentException("Argument n has illegal value");
        }

        if (n == s.length()) {
            List<String> temp = new ArrayList<String>();
            temp.add(s);
            return temp;
        }

        List<String> temp = new ArrayList<String>();

        for (int i = 0; i <= s.length() - n; i++) {
            temp.add(s.substring(i, i + n));
        }

        return temp;
    }

    private static Map<String, Integer> getStringMap(List<String> s) {
        if (s == null) {
            return null;
        }

        if (s.size() == 0) {
            return new HashMap<String, Integer>();
        }

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String t: s) {
            if (!map.containsKey(t)) {
                map.put(t, 1);
            } else {
                map.put(t, map.get(t) + 1);
            }
        }

        return map;
    }

    private static Integer numOfDistinct(String t) {
        if (t == null || t.length() == 0) {
            return 0;
        }

        Map<Character, Integer> distinct = new HashMap<Character, Integer>();
        int count = 0;
        for (Character ch : t.toCharArray()) {
            if (!distinct.containsKey(ch)) {
                distinct.put(ch, 1);
                count++;
            }
        }

        return count;
    }

    private static int numOfTime(String s, int size) {
        List<String> str = findAllSubstring(s, size);
        Map<String, Integer> map = getStringMap(str);
        int max = 1;
        for (int value : map.values()) {
            if (value > max) max = value;
        }

        return max;
    }
}
