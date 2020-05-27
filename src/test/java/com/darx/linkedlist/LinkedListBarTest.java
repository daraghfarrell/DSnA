package com.darx.linkedlist;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LinkedListBarTest {
    LinkedListBar linkedListBar = null;


    @Before
    public void setUp() throws Exception {
        linkedListBar = new LinkedListBar();
    }

    @After
    public void tearDown() throws Exception {
        linkedListBar = null;
    }

    @Test
    public void hasCycle() {
        LinkedList list = new LinkedList();
        list.addAtHead(1);
        list.addAtTail(2);

        Assert.assertFalse(linkedListBar.hasCycle(list.head));
    }

    @Test
    public void detectCycle2() {
//        [3,2,0,-4]
//        1

        LinkedList list = new LinkedList();
        list.addAtHead(3);
        list.addAtIndex(1, 2);
        list.addAtIndex(2, 0);
        list.addAtIndex(3, -4);

        list.get(3).next = list.get(1);

        ListNode node = linkedListBar.detectCycle2(list.head);
        Assert.assertNotNull(node);
        Assert.assertEquals(list.get(1).val, node.val);
    }

    @Test
    public void reverseList() {
        LinkedList input = new LinkedList();
        input.head = new ListNode(1);
        input.head.next = new ListNode(2);
        input.head.next.next = new ListNode(3);

        ListNode result = linkedListBar.reverseList(input.head);

        Assert.assertEquals(3, result.val);
        Assert.assertEquals(2, result.next.val);
        Assert.assertEquals(1, result.next.next.val);

    }


    @Test
//    Input:  1->2->6->3->4->5->6, val = 6
//    Output: 1->2->3->4->5
    public void removeElements1() {
        LinkedList input = new LinkedList();
        input.head = new ListNode(1);
        input.head.next = new ListNode(2);
        input.head.next.next = new ListNode(6);
        input.head.next.next.next = new ListNode(3);

        LinkedList expected = new LinkedList();
        expected.head = new ListNode(1);
        expected.head.next = new ListNode(2);
        expected.head.next.next = new ListNode(3);

        ListNode result = linkedListBar.removeElements1(input.head, 6);

        Assert.assertEquals(expected.get(0).val, result.val);
        Assert.assertEquals(expected.get(1).val, result.next.val);
        Assert.assertEquals(expected.get(2).val, result.next.next.val);
        Assert.assertNull(expected.get(3));
        Assert.assertNull(result.next.next.next);
    }

    @Test
//    Input:  1->2->6->3->4->5->6, val = 6
//    Output: 1->2->3->4->5
    public void removeElements2() {
        LinkedList input = new LinkedList();
        input.head = new ListNode(1);
        input.head.next = new ListNode(2);
        input.head.next.next = new ListNode(6);
        input.head.next.next.next = new ListNode(3);

        LinkedList expected = new LinkedList();
        expected.head = new ListNode(1);
        expected.head.next = new ListNode(2);
        expected.head.next.next = new ListNode(3);

        ListNode result = linkedListBar.removeElements2(input.head, 6);

        Assert.assertEquals(expected.get(0).val, result.val);
        Assert.assertEquals(expected.get(1).val, result.next.val);
        Assert.assertEquals(expected.get(2).val, result.next.next.val);
        Assert.assertNull(expected.get(3));
        Assert.assertNull(result.next.next.next);
    }

    @Test
    public void testRemainder() {
        Assert.assertEquals(0, 0 % 2);
        Assert.assertEquals(1, 1 % 2);
        Assert.assertEquals(0, 2 % 2);
        Assert.assertEquals(1, 3 % 2);
        Assert.assertEquals(0, 4 % 2);
    }

    @Test
    public void oddEvenList() {
        ListNode result = linkedListBar.oddEvenList(null);
    }
}