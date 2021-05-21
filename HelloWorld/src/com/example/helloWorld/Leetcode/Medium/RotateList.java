package com.example.helloWorld.Leetcode.Medium;
//https://leetcode.com/problems/rotate-list/ Q.61
import com.example.helloWorld.Leetcode.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        int cnt=0;
        ListNode temp =head;
        if(head==null || head.next==null)
            return head;
        while(temp!=null){
            cnt++;
            temp=temp.next;
        }
        k%=cnt;
        if(k==0)
            return head;
        cnt-=k;
        temp=head;
        ListNode prev=null;
        while(cnt>0){
            prev=temp;
            temp=temp.next;
            cnt--;
        }
        ListNode end=temp;
        while(end.next!=null){
            end=end.next;
        }
        end.next=head;
        head=temp;
        prev.next=null;
        return head;
    }
}
