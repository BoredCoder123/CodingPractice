package com.example.helloWorld.Leetcode.Medium;

import com.example.helloWorld.Leetcode.ListNode;

//https://leetcode.com/problems/add-two-numbers/ Q.2

public class Adding2Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;

        ListNode start=new ListNode((l1.val+l2.val)%10);
        ListNode c1=l1, c2=l2, c3=start;
        int tcarry=(l1.val+l2.val)/10;
        c1=c1.next;
        c2=c2.next;
        c3=start;
        while(c1!=null && c2!=null){
            ListNode temp = new ListNode((c2.val+c1.val+tcarry)%10);
            tcarry=(c1.val+c2.val+tcarry)/10;
            c3.next=temp;
            c1=c1.next;
            c2=c2.next;
            c3=c3.next;
        }
        while(c1!=null){
            ListNode temp = new ListNode((c1.val+tcarry)%10);
            tcarry=(c1.val+tcarry)/10;
            c3.next=temp;
            c1=c1.next;
            c3=c3.next;
        }
        while(c2!=null){
            ListNode temp = new ListNode((c2.val+tcarry)%10);
            tcarry=(c2.val+tcarry)/10;
            c3.next=temp;
            c2=c2.next;
            c3=c3.next;
        }
        if(tcarry==1){
            ListNode temp=new ListNode(1);
            c3.next=temp;
        }
        return start;
    }
}
