package org.vikastaneja.Revision;

/**
 * Created by vikastaneja on 8/1/14.
 */
public class Permutation {
    public static void print(String s) {
        if (s == null) {
            throw new NullPointerException("String is null");
        }

        if (s.length() == 0) {
            System.out.println("No permutation is possible for empty string");
            return;
        }

        permute(s, "");
    }

    private static void permute(String s, String s1) {
        if (s.length() == 0) {
            System.out.println(s1);
            return;
        } else {

            for (int j = 0; j < s.length(); j++) {
                permute(s.substring(0, j) + s.substring(j + 1, s.length()), s1 + s.charAt(j));
            }
        }
    }
}
