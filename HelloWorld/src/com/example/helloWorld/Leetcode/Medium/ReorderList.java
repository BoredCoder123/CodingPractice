package com.example.helloWorld.Leetcode.Medium;

import com.example.helloWorld.Leetcode.ListNode;

import java.util.Stack;

//https://leetcode.com/problems/reorder-list/ Q.143
public class ReorderList {
    public void reorderList(ListNode head) {
        int cnt=0;
        ListNode temp=head, prev=head;
        while(temp!=null){
            cnt++;
            temp=temp.next;
        }
        cnt=(cnt+1)/2;
        temp=head;
        while(cnt>0){
            prev=temp;
            cnt--;
            temp=temp.next;
        }
        prev.next=null;
        Stack<ListNode> q= new Stack<>();
        while(temp!=null){
            q.push(temp);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null && !q.isEmpty()){
            ListNode t= temp.next, t2=q.pop();
            temp.next=t2;
            t2.next=t;
            temp=t;
        }
    }
}
