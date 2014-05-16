package org.vikastaneja.coderust;

/**
 * Created by vikastaneja on 5/16/14.
 */

import java.util.*;

/**
 * Implementation of Stack using Queues
 * @param <T> Object
 */
public class MyStack<T> {
    private Queue<T> current;
    private Queue<T> subs;

    private void swap() {
        Queue<T> temp = current;
        current = subs;
        subs = temp;
    }

    public T pop() {
        if (current.isEmpty()) {
            return null;
        }

        T temp;
        while (!current.isEmpty() && current.size() > 1) {
            temp = current.remove();
            subs.add(temp);
        }

        temp = current.remove();
        swap();
        return temp;
    }

    public void push (T t) {
        current.add(t);
    }

    public MyStack() {
        current = new java.util.LinkedList<T>();
        subs = new java.util.LinkedList<T>();
    }
}