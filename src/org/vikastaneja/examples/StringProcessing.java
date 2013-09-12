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
}
