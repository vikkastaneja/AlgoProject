package org.vikastaneja.ppearls;

/**
 * Created by vikastaneja on 1/5/16.
 */
public class MainClass {
    public static void main(String[] args) {
        C1Q3BitSort c1Q3BitSort = new C1Q3BitSort(10000000);
        c1Q3BitSort.add(1000000);
        c1Q3BitSort.add(400000);
        c1Q3BitSort.add(30000);
        c1Q3BitSort.add(1000000);
        c1Q3BitSort.add(60000);
        c1Q3BitSort.printSorted();
    }
}
