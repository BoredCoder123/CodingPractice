package com.example.helloWorld.Leetcode.Medium;

import com.example.helloWorld.Leetcode.ListNode;
//https://leetcode.com/problems/linked-list-cycle-ii/ Q142
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return null;
        ListNode slow=head.next, fast=head.next.next;
        while(fast!=null && fast.next!=null){
            if(slow==fast)
                break;
            slow=slow.next;
            fast=fast.next.next;
        }
        if(slow!=fast)
            return null;
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }

        return slow;
    }
}
