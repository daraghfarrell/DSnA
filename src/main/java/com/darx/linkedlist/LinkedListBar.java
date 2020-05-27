package com.darx.linkedlist;

import java.util.ArrayList;

public class LinkedListBar {

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast) {
            if(fast == null || fast.next == null) {
                return false;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return true;
    }

    public ListNode detectCycle2(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }

        ListNode intersect = getIntersect(head);
        if (intersect == null) return null;

        // find entry point to cycle
        ListNode p1 = head;
        ListNode p2 = intersect;
        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    private ListNode getIntersect(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;

        // A fast pointer will either loop around a cycle and meet the slow
        // pointer or reach the `null` at the end of a non-cyclic list.
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                return tortoise;
            }
        }
        return null;
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return head;
        ListNode slow = head, fast = head, prev = null;

        // wind fast forward n steps
        for(int i=0;i<n;i++) {
            fast = fast.next;
        }

        // walk to end
        while(fast!=null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        // short list
        if(prev==null) return head.next;

        // normal list
        prev.next = slow.next;
        return head;
    }

    /**
     * Time: O(n)
     * SPace O(n)
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head == null || head.next == null) return null;

        ArrayList<ListNode> list = new ArrayList<>();
        ListNode next = head.next;
        list.add(head);

        while(next != null) {
            list.add(next);
            next = next.next;
        }

        int indexOfNth = list.size() - n;

        if (n == 1) { // tail
            list.get(list.size() - 2).next = null;
        } else if(indexOfNth == 0)  { // head
            return list.get(1);
        } else { // rest
            ListNode beforeNth = list.get(indexOfNth - 1);
            ListNode afterNth = list.get(indexOfNth + 1);
            beforeNth.next = afterNth;
        }

        return head;
    }

    /**
     * Two pointer technique for detecting cycles or intersections
     */
    public boolean TwoPointer(ListNode head) {
        // Initialize slow & fast pointers
        ListNode slow = head;
        ListNode fast = head;
        /**
         * Change this condition to fit specific problem.
         * Attention: remember to avoid null-pointer error
         **/
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;           // move slow pointer one step each time
            fast = fast.next.next;      // move fast pointer two steps each time
            if (slow == fast) {         // change this condition to fit specific problem
                return true;
            }
        }
        return false;   // change return value to fit specific problem
    }

    /**
     *  Reverse linked list
     *  Each node points back to previous and tail becomes head
     *  Prev and curr slide along
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // initial condition
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }

    /**
     * DF soluton - 2 pointer
     * Time O(N)
     * Space O(1)
     * More
     */
    public ListNode removeElements1(ListNode head, int val) {
        if(head == null) return null;

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {

            // if val then remove
            if(curr.val == val) {
                if(prev != null) { // not head of list
                    curr = curr.next;
                    prev.next = curr;
                } else { // head of list
                    ListNode temp = curr;
                    curr = curr.next;
                    head = curr;
                    temp.next = null;
                }
            }

            else {
                prev = curr;
                curr = curr.next;
            }
        }

        return head;
    }

    /**
     * Take2 using Sentinel Node - one pointer plus sentinel
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            }
            else {
                prev = curr;
            }
            curr = curr.next;
        }
        return sentinel.next;
    }


    public ListNode oddEvenList(ListNode head) {
        ListNode even = new ListNode(0);
        ListNode pEven = even;

        ListNode odd = new ListNode(0);
        ListNode pOdd = odd;

        ListNode curr = head;
        int count = 1;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = null;

            // even
            if(count % 2 == 0) {
                pEven.next = curr;
                pEven = pEven.next;
            }

            // odds
            else {
                pOdd.next = curr;
                pOdd = pOdd.next;
            }

            count++;
            curr = next;
        }

        pOdd.next = even.next;
        return odd.next;
    }
}

