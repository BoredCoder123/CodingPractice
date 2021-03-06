package com.example.helloWorld.Leetcode.Medium;
//https://leetcode.com/problems/reverse-linked-list-ii/ Q.92
import com.example.helloWorld.Leetcode.ListNode;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null)
            return null;
        ListNode cur=head, prev=null;
        while(m>1){
            prev=cur;
            cur=cur.next;
            m--;n--;
        }

        ListNode con=prev, tail=cur, third=null;
        while(n>0){
            third=cur.next;
            cur.next=prev;
            prev=cur;
            cur=third;
            n--;
        }

        if(con!=null){
            con.next=prev;
        }else{
            head=prev;
        }

        tail.next=cur;
        return head;
    }
}
