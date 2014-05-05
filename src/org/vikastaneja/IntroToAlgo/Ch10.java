package org.vikastaneja.IntroToAlgo;


import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Given a binary tree, traverse the tree with O(n) time and O(1) space <br/>
 * Solution: Keep two pointers - previous and current. If current was previously at parent, move to left. <br/>
 * if current was previously at left, move to right.<br/>
 * if current was previouslt at right, move to parent<br/>
 * Created by vikastaneja on 4/7/14.
 */
public class Ch10 {
    public static List<Integer> visitNodes_10_4_4(final NodeWithParent tree) {
        if (tree == null) {
            return new ArrayList<Integer>();
        }

        NodeWithParent p = null;
        NodeWithParent c = tree;
        List<Integer> list = new ArrayList<Integer>();
        while (c != null) {
            if (p == c.parent) {
                list.add(c.value);
                p = c;
                c = c.left != null ? c.left :
                        c.right != null ? c.right :
                                c.parent;

            } else if (p == c.left && c.right != null) {
                p = c;
                c = c.right;
            } else {
                p = c;
                c = c.parent;
            }
        }

        return list;
    }
}
