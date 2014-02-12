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

    }
}
