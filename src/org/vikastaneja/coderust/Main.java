package org.vikastaneja.coderust;

import org.vikastaneja.crackingcodinginterviews.Node;

/**
 * Created by vikastaneja on 4/8/14.
 */
public class Main {
    public static void main(String[] args) {

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
