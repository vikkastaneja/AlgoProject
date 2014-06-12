package org.vikastaneja.examples;

import java.util.*;

/**
 * Created by vikastaneja on 5/5/14.
 */
public class MiscProblems {

	public static void mergeIntervals(List<Intervals> intervals) {
		if (intervals == null) {
			throw new RuntimeException("List of intervals can't be null");
		}

		if (intervals.size() <= 1) {
			System.out.println("No need for processing the list");
			return;
		}

		// Commenting this until sort is available for Interval class
		// Collections.sort(intervals);

		Stack<Intervals> stack = new Stack<Intervals>();
		for (Intervals interval : intervals) {
			if (stack.empty()) {
				stack.push(interval);
				continue;
			}

			Intervals temp = stack.pop();
			if (temp.end < interval.start) {
				stack.push(temp);
				stack.push(interval);
			} else {
				temp.end = (interval.end > temp.end) ? interval.end : temp.end;
				stack.push(temp);
			}
		}

		// Now stack contain all merged intervals
		intervals.clear();
		while(!stack.empty()) {
			intervals.add(0, stack.pop());
		}
	}

    /**
     * Print combinations of zero and ones, given that number of digits are known. <br/>
     * For example, given 2, combinations are 00, 01, 10, and 11
     * @param digits - number of digits
     */
    public static void printCombinationsOfZeroAndOne(int digits) {
        if (digits <= 0) {
            System.out.println("Nothing to print");
            return;
        }

        int []a = new int[digits];
        fill (a, 0, 0, digits - 1);
        fill (a, 1, 0, digits - 1);
    }

    /**
     * Helper method to print the combination in {@link org.vikastaneja.examples.MiscProblems#printCombinationsOfZeroAndOne(int)}
     * @param a - array to be filled into
     * @param digit - digit to be filled in start position;
     * @param start - begin position to be filled in
     * @param end - end position in the array. In ideal conditions, the start <= end
     */
    private static void fill (int []a, int digit, int start, int end) {
        if (a == null) {
            throw new RuntimeException("Array is null");
        }

        a[start] = digit;
        if (start == end) {
            for (int i : a) {
                System.out.print(i);
            }
            System.out.println();
            return;
        }

        fill(a, 0, start + 1, end);
        fill(a, 1, start + 1, end);
    }

    /**
     * Given a string (for example: "a?bc?def?g"), write a program to generate all the possible strings by replacing ? with 0 and 1 <br/>
     * Logic is to replace the array's element with '?' and then recurse
     * @param str input string
     */
    public static void replaceMarkWith0and1(String str) {
        if (str == null) {
            throw new NullPointerException("Parameter passed is null");
        }

        if (str.isEmpty()) {
            System.out.println("String is empty");
            return;
        }

        char[] carray = str.toCharArray();
        printWithMark(carray, 0);
    }

    /**
     * Private function that actually performs the task of replacement and then recursion in {@link org.vikastaneja.examples.MiscProblems#replaceMarkWith0and1(String)}
     * @param str input string
     * @param current current index
     */
    private static void printWithMark(char[] str, int current) {
        if (str == null) {
            throw new NullPointerException("Parameter str is null");
        }

        if (current == str.length) {
            System.out.println(new String(str));
            return;
        }

        if (str[current] == '?') {
            str[current] = '0';
            printWithMark(str, current + 1);
            str[current] = '1';
            printWithMark(str, current + 1);
            str[current] = '?';
        } else {
            current++;
            printWithMark(str, current);
        }
    }

    /**
     * From the input, return the string that has most number of common characters <br/>
     * "aaabbddddd", "ddcccccccb" will return "aaabbddddd" <br/>
     * "", "" will return ""
     * @param str1 First input string
     * @param str2 Second input string
     * @return Resulting string
     */
    public static String instanceCompare(String str1, String str2) {
        if (str1 == null || str2 == null) {
            throw new NullPointerException("Either str1 or str2 is null");
        }

        if (str1.isEmpty() || str2.isEmpty()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Map<Character, Integer> map1 = new HashMap<Character, Integer>();

        for (Character c : str1.toCharArray()) {
            int count = 1;
            if (map.containsKey(c)) {
                count += map.get(c) + 1;
            }
            map.put(c, count);
        }

        for (Character c : str2.toCharArray()) {
            int count = 1;
            if (map1.containsKey(c)) {
                count += map1.get(c) + 1;
            }
            map1.put(c, count);
        }

        int max = 0;
        boolean isPresent = false;
        Set<Character> list = map1.keySet();
        for (Character c  :list) {
           if (map.containsKey(c)) {
               max += map.get(c);
               max -= map1.get(c);
               if (!isPresent) isPresent = true;
           }
        }

        if (max < 0) return str2;
        if (max > 0) return str1;
        return (isPresent ? (str1.length() > str2.length() ? str1 : str2) : "");
    }
}