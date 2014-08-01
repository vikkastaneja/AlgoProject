package org.vikastaneja.Revision;

/**
 * Created by vikastaneja on 8/1/14.
 */
public class CombinationsOfParenthesis {
    public static void printParenthesis(int count) {
        if (count <= 0)
            return;

        print("", count, count);
    }

    private static void print(String s, int open, int close) {
        if (open < 0 || close < 0) return;
        if (open > close) return;

        if (open == 0 && close == 0)
            System.out.println(s);

        print(s + "{", open - 1, close);
        print(s + "}", open, close - 1);
    }
}
