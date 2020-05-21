package com.darx.linkedlist;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    LinkedList list1 = new LinkedList();

    @Before
    public void setUp() throws Exception {
        list1.head = new ListNode(100);  // 0
        list1.head.next = new ListNode(200); // 1
        list1.head.next.next = new ListNode(300); // 2
        list1.head.next.next.next = new ListNode(400); // 3

    }

    @After
    public void tearDown() throws Exception {
        list1.head = null;
    }

    @Test
    public void get() {
        Assert.assertEquals(-1, list1.get(1001));
        Assert.assertEquals(-1, list1.get(-100));
        Assert.assertEquals(400, list1.get(3));
        Assert.assertEquals(300, list1.get(2));
        Assert.assertEquals(-1, list1.get(17));
        Assert.assertEquals(-1, list1.get(-1));
    }

    @Test
    public void addAtHead() {
        list1.addAtHead(1000);
        Assert.assertEquals(1000, list1.get(0));
    }

    @Test
    public void addAtTail() {
        list1.addAtTail(9999); //
        Assert.assertEquals(9999, list1.get(4));
        Assert.assertNotEquals(6666, list1.get(4));
        Assert.assertNotEquals(9999, list1.get(-1));
    }

    @Test
    public void addAtIndex() {
        list1.addAtIndex(1, 777);
        Assert.assertEquals(777, list1.get(1));
    }

    @Test
    public void deleteAtIndex() {
        list1.deleteAtIndex(1);
        Assert.assertEquals(300, list1.get(1));
    }
}