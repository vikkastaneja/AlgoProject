package org.vikastaneja.examples;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by vikastaneja on 3/18/14.
 */
public class StackProblems {

    /**
     * Reverse a stack.
     * @param s
     */
    public static void reverse(final Stack<Integer> s) {
        if (s == null) throw new RuntimeException("Stack is null");
        if (s.size() <= 1) return;
        Stack<Integer> t = new Stack<Integer>();
        Integer v;
        int s_len = s.size();
        for (int i = 0; i < s_len - 1; i++) {
            int pops = s_len -i - 1;
            v = s.pop();
            while (pops > 0) {
                t.push(s.pop());
                pops--;
            }

            s.push(v);
            while (!t.empty()) {
                s.push(t.pop());
            }
        }
    }
}
