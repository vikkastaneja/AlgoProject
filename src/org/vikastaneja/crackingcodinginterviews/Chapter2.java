package org.vikastaneja.crackingcodinginterviews;

/**
 * Created by vikastaneja on 2/25/14.
 */
public class Chapter2 {

    /**
     * Single Linked list node
     */
    public class LinkedListNode {
        public Integer value;
        public LinkedListNode next;

    }

    /**
     * Find out if the linked list makes a palindrome
     * @param node
     * @return
     */
    public static boolean isPalindrome(LinkedListNode node) {
        if (node == null || node.next == null) {
            return true;
        }

        LinkedListNode fast = node, slow = node;
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        LinkedListNode temp = slow.next;
        fast = node;

        while (temp != null || fast != slow) {
            if (temp.value != fast.value) {
                return false;
            }

            temp = temp.next;
            fast = fast.next;
        }

        return true;
    }
}
