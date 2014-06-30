package org.vikastaneja.crackingcodinginterviews;


/**
 * Created by vikastaneja on 2/11/14.
 */
public class MainClass {
    public static void main(String []args) {
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
