package org.vikastaneja.crackingcodinginterviews;


import java.util.Stack;

/**
 * Created by vikastaneja on 2/11/14.
 */
public class MainClass {
    public static void main(String []args) {

        Node n11 = new Node(); n11.value = 1;

        Node n12 = new Node(); n12.value = 6;

        Node n21 = new Node(); n21.value = 10;

        Node n22 = new Node(); n22.value = 11;

        Node n23 = new Node(); n23.value = -1;

        Node n24 = new Node(); n24.value = 5;

        Node n31 = new Node(); n31.value = 5;

        Node n32 = new Node(); n32.value = 1;
        n22.left = n31;
        n23.right = n32;

        n11.left = n21;
        n11.right = n22;

        n12.left = n23;
        n12.right = n24;

        Node r1 = new Node();
        r1.value = 5;
        r1.left = n11;
        r1.right = n12;

        Chapter4.printSumInBinaryTree(r1, 11);

        Node root = new Node();
        root.value = 1;
        root.left = new Node();
        root.right = new Node();
        root.left.value = 2;
        root.right.value = 3;
        root.left.left = new Node();
        root.left.right = new Node();
        root.left.left.value = 4;
        root.left.right.value = 5;

        root.right.left = new Node();
        root.right.right = new Node();
        root.right.left.value = 6;
        root.right.right.value = 7;

        Node n1 = root.left;
        Node n2 = root.right.right;

        Node t = Chapter4.findLca(root, n1, n2);
        if (t != root) {
            throw new AssertionError("t and root are not same");
        }

        Node t1 = Chapter4.findLca(root, root, n2);
        if (t1 != root) {
            throw new AssertionError("t1 and root are not same");
        }

        Node t2 = Chapter4.findLca(root, root.right.left, n2);
        if (t2 != root.right) {
            throw new AssertionError("t2 and root.right are not same");
        }

        try {
            Chapter4.findLca(null, n1, n2);
        } catch (NullPointerException ex) {
            if (!ex.getMessage().equals("Root in null")) {
                throw ex;
            }
        }

        if (Chapter4.findLca(root, null, n2) != null) {
            throw new AssertionError("Null is not returned");
        }
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(5);
        stack.push(2);
        stack.push(4);
        stack.push(3);
        Chapter3.sortStack(stack);

        Chapter3.sortStack(new Stack<Integer>());
        try {
            Chapter3.sortStack(null);
        } catch (NullPointerException ex) {
            if (!ex.getMessage().equals("Stack passed is empty")) throw ex;
        }

        stack = null;
        stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(4);

        Chapter3.sortStack(stack);

        stack = null;
        stack = new Stack<Integer>();
        stack.push(4);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(-1);
        stack.push(-100);

        Chapter3.sortStack(stack);

        int [][]a = {{0,2,3,4,5,6},
                    {2,3,4,5,6,7},
                    {8,9,0,1,2,3},
                    {4,5,0,1,2,6}};

        Chapter1.zeroRowsAndColumns(a);

        try {
            Chapter1.zeroRowsAndColumns(null);
        } catch (NullPointerException ex) {
            if (!ex.getMessage().equals(new String ("Passed array is either null or of zero length"))) {
                throw ex;
            }
        }

        Object obj = new Object();
        Object obj1 = new Object();

        System.out.println("**** First string problem ****");
        String noDuplicates = "LazyBrown";
        String duplicates = "Lazy Brown Fox";
        System.out.println(Chapter1.isDuplicatePresent(noDuplicates));
        System.out.println(Chapter1.isDuplicatePresent(duplicates));

        System.out.println("**** Second string problem ****");
        String str1 = "aaaabbbbcccc";
        String str2 = "cbacbacbacba";
        System.out.println(Chapter1.isAnagram(str1, str2));
        System.out.println(Chapter1.isAnagram("", str2));

        System.out.println("**** Third string problem ****");
        String space = "This is the fox.";
        char[] ch = new char[space.length() + 6];
        for (int i = 0; i < space.length(); i++) {
            ch[i] = space.charAt(i);
        }
        Chapter1.updateString(ch);
        System.out.println(new String(ch));

        System.out.println("**** First linkedlist problem ****");
        Chapter2 ch2 = new Chapter2();
        Chapter2.LinkedListNode head = ch2.new LinkedListNode();
        head.next = ch2.new LinkedListNode();
        head.value = 1;
        head.next.next = ch2.new LinkedListNode();
        head.next.value = 2;
        head.next.next.next = null;
        head.next.next.value = 1;

        System.out.println(Chapter2.isPalindrome(head));

    }
}
