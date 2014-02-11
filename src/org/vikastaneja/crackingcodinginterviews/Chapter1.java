package org.vikastaneja.crackingcodinginterviews;

import com.google.common.base.Preconditions;

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
}
