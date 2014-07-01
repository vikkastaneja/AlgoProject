package org.vikastaneja.crackingcodinginterviews;

import java.util.Stack;

/**
 * Created by vikastaneja on 7/1/14.
 */
public class Chapter3 {

    /**
     * Sort an unsorted stack<br/>
     * The idea is to sort the stack using an additional data structure.<br/>
     * We can either chose a stack or chose a linked list to sort it. In both cases, the order will be quadratic.
     * @param st
     */
    public static void sortStack(Stack<Integer> st) {
        if (st == null)
            throw new NullPointerException("Stack passed is empty");

        if (st.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        Stack<Integer> t = new Stack<Integer>();
        while (!st.isEmpty()) {
            Integer i = st.pop();
            if (t.isEmpty() || i < t.peek()) {
                t.push(i);
            } else {
                int count = 0;
                while (!t.isEmpty() && i > t.peek()) {
                    st.push(t.pop());
                    count++;
                }

                t.push(i);
                while (count-- > 0) t.push(st.pop());
            }
        }

        while(!t.isEmpty())
            st.push(t.pop());
    }
}
