package com.darx.linkedlist;

import java.util.List;

public class LinkedList {

    ListNode head;

    public void LinkedList(ListNode x) {
        head = x;
    }

    public ListNode get(int index) {
        if(index < 0 || index > 1000)
            return null;

        ListNode current = head;

        // traverse until i equals index
        for(int i = 0; i < index && current != null; i++) {
            current = current.next;
        }

        return current;
    }

    public void addAtHead(int val) {
        ListNode oldHead = head;
        head = new ListNode(val);
        head.next = oldHead;
    }

    public void addAtTail(int val) {
        ListNode current = head;

        while(current.next != null) {
            current = current.next;
        }

        current.next = new ListNode(val);
    }

    public void addAtIndex(int index, int val) {
        if(index < 0)
            return;

        if(index == 0) {
            ListNode oldHead = head;
            head = new ListNode(val);
            head.next = oldHead;
            return;
        }

        ListNode current = head;
        ListNode previous = null;

        for(int i = 0; i < index; i++) {
            previous = current;
            current = current.next;
        }

        previous.next = new ListNode(val);
        previous.next.next = current;
    }

    public void deleteAtIndex(int index) {
        if (index < 0) {
            return;
        }

        if(index == 0) {
            head = head.next;
            return;
        }

        ListNode current = head;
        ListNode previous = null;

        for(int i = 0; i < index; i++) {
            previous = current;
            current = current.next;
        }

        if(previous != null && current != null ) {
            previous.next = current.next;
        }
    }
}
