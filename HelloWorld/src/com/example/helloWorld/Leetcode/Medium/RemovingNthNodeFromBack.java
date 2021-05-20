package com.example.helloWorld.Leetcode.Medium;
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/ Q.19
import com.example.helloWorld.Leetcode.ListNode;

public class RemovingNthNodeFromBack {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt=0;
        if(head==null || (head.next==null && n==1) )
            return null;
        ListNode temp=head, prev=head;
        while(temp!=null){
            temp=temp.next;
            cnt++;
        }
        if(n==cnt)
            head=head.next;
        cnt-=n;
        temp=head;
        while(cnt>0){
            prev=temp;
            temp=temp.next;
            cnt--;
        }
        prev.next=temp.next;
        return head;
    }
}
