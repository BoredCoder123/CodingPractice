package com.example.helloWorld.Leetcode.Medium;
//https://leetcode.com/problems/swap-nodes-in-pairs/ Q.24
import com.example.helloWorld.Leetcode.ListNode;

public class SwapNodesInPair {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode prev=head;
        ListNode next=head.next.next;
        ListNode t=head.next;
        t.next=head;
        head.next=next;
        head=t;
        // System.out.println(prev.val+" "+next.val);
        while(next!=null && next.next!=null){
            ListNode n1=next.next, n2=next.next.next;
            n1.next=next;
            next.next=n2;
            prev.next=n1;

            prev=next;
            next=prev.next;
        }
        return head;
    }
}
