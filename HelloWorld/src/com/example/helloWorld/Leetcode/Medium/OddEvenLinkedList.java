package com.example.helloWorld.Leetcode.Medium;
//https://leetcode.com/problems/odd-even-linked-list/ Q.328
import com.example.helloWorld.Leetcode.ListNode;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)
            return head;

        ListNode odd=head, even=head.next, evenhead=even;

        while(even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenhead;
        return head;
    }
}
