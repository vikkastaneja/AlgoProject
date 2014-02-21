package org.vikastaneja.crackingcodinginterviews;

/**
 * Created by vikastaneja on 2/11/14.
 */
public class MainClass {
    public static void main(String []args) {
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

    }
}
