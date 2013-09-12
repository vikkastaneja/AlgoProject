package org.vikastaneja.examples;

import com.google.common.base.Preconditions;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: vttaneja
 * Date: 9/12/13
 * Time: 11:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class MinStack <T extends Integer>{
    private Stack<T> stack = new Stack<T>();
    private Stack<T> minStack = new Stack<T>();

    public void push(final T t) {
        Preconditions.checkNotNull(t);

        this.stack.push(t);

        if (this.minStack.isEmpty() || (Integer)this.minStack.peek() > (Integer)t) {
            this.minStack.push(t);
            return;
        }
    }

    public T pop() {
        if(this.stack.size() == 0) {
            return null;
        }

        if (minStack.peek() == stack.peek()) {
            this.minStack.pop();
        }

        return this.stack.pop();
    }

    public T minPop() {
        if(this.stack.size() == 0) {
            return null;
        }

        if (minStack.peek() == stack.peek()) {
            this.stack.pop();
        }

        return this.minStack.pop();
    }

    public T peek() {
        return this.stack.peek();
    }

    public T peekMin() {
        return this.minStack.peek();
    }
}
