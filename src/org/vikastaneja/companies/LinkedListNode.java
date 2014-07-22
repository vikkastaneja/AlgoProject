package org.vikastaneja.companies;

/**
 * Created by vikastaneja on 7/22/14.
 */
public class LinkedListNode {
    public LinkedListNode Next;
    public LinkedListNode Other;
    public int Data;

    public LinkedListNode(int data) {
        this.Data = data;
        this.Next = null;
        this.Other = null;
    }
}
