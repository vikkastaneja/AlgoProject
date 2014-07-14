package org.vikastaneja.examples;

import com.google.common.base.Preconditions;
import java.util.Stack;

/**
 * Created by vikastaneja on 2/7/14.
 */
public class LinkedList {
    public class Node {
        public int value;
        public Node next;

        public Node() {

        }
    }

    public Node head;

    public void addNode(int value) {
        if(head == null) {
            head = new Node();
            head.value = value;
            head.next = null;
        }
        else {
            Node temp = new Node();
            temp.next = null;
            temp.value = value;

            Node temp1 = head;
            while (temp1.next != null) {
                temp1 = temp1.next;
            }

            temp1.next = temp;
        }
    }

    /**
     * Makes the list from a-b-c-d-e-f to a-c-e-f-d-b
     */
    public void modifyList() {
        Preconditions.checkNotNull(head);

        if (head.next == null || head.next.next == null)  {
            return;
        }


        Stack<Node> stack = new Stack();
        Node temp = head;
        while (temp != null && temp.next != null) {
            Node temp1 = temp.next;
            temp.next = temp.next.next;
            temp1.next = null;
            stack.push(temp1);
            temp = temp.next;
        }

        while (stack.empty() == false) {
            Node temp1 = stack.pop();
            temp.next = temp1;
            temp = temp.next;
        }
    }
}
