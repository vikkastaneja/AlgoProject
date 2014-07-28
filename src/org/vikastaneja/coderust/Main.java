package org.vikastaneja.coderust;

import org.vikastaneja.crackingcodinginterviews.Node;

/**
 * Created by vikastaneja on 4/8/14.
 */
public class Main {
    public static void main(String[] args) {
        int []a111 = { 1, 3, 5, 7, 9};
        int []b111 = { 2, 6, 8, 20, 34};
        System.out.println("Kth largest element is: " + Arrays.returnKthInSortedArrays(a111, b111, 4));
        System.out.println(Arrays.returnKthInSortedArrays(a111, b111, 7));
        int[]array123 = {1,2,2,4,4,4,4,4,5,6,7};
        System.out.println(Arrays.count(array123,4));
        System.out.println(Arrays.count(array123,2));
        System.out.println(Arrays.count(array123,3));
        array123 = new int[0];
        System.out.println(Arrays.count(array123, 3));
        try {
            Arrays.count(null, 4);
        } catch(NullPointerException ex) {
            if (!ex.getMessage().equals("Array passed is null"))
                throw ex;
        }

        Node tree1 = new Node();
        tree1.value = 10;
        tree1.left = new Node();
        tree1.left.value = 5;
        tree1.right = new Node();
        tree1.right.value = 6;
        tree1.left.left = new Node();
        tree1.left.left.value = -3;
        tree1.left.right = new Node();
        tree1.left.right.value = -2;
        tree1.right.left = new Node();
        tree1.right.right = new Node();
        tree1.right.left.value = -4;
        tree1.right.right.value = -2;

        Trees.deleteSubtree(tree1, 0);

        tree1 = null;
        tree1 = new Node();
        tree1.value = 0;
        tree1.left = new Node();
        tree1.left.value = 4;
        tree1.right = new Node();
        tree1.right.value = 6;
        tree1.left.left = new Node();
        tree1.left.left.value = 1;
        tree1.left.right = new Node();
        tree1.left.right.value = -5;
        tree1.right.left = new Node();
        tree1.right.right = new Node();
        tree1.right.left.value = -4;
        tree1.right.right.value = -2;

        Trees.deleteSubtree(tree1, 0);

        try {
            Trees.deleteSubtree(null, 0);
        } catch (NullPointerException ex) {
            if (!ex.getMessage().equals("Root is null")) {
                throw ex;
            }
        }

        MyStack<Integer> st = new MyStack<Integer>();

        st.push(1);
        System.out.println(st.pop());

        st.push(2);
        st.push(3);
        System.out.println(st.pop());

        Node tree = new Node();
        tree.value = 20;
        tree.left = new Node();
        tree.left.value = 10;
        tree.right = new Node();
        tree.right.value = 35;
        tree.left.left = new Node();
        tree.left.left.value = 5;
        tree.left.right = new Node();
        tree.left.right.value = 15;
//        tree.left.right.left = new Node();
//        tree.left.right.left.value = 25;
//        tree.left.right.right = new Node();
//        tree.left.right.right.value = 40;

        Trees.printPerimeter(tree);

        Trees.levelOrderTraversal(tree);

        Trees.swapLeftRight(tree);

        Trees.printNth(tree, 5);
        
        Trees.deleteZeroSum(tree);
    }
}
