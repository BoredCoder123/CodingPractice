package com.example.helloWorld.GeeksForGeeks.LinkedList;
//https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1#

import java.util.*;

public class Adding2Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();
            int val = sc.nextInt();

            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            int m = sc.nextInt();
            val = sc.nextInt();

            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            Node res = addTwoLists(first, second);
            Node.printList(res);
        }
    }

    private static Node reverse(Node head){
        Node out=null, current=head;
        while(current!=null){
            Node next=current.next;
            current.next=out;
            out=current;
            current=next;
        }
        return out;
    }

    static Node addTwoLists(Node first, Node second){
        Node res = null;
        Node prev = null;
        Node temp = null;
        int carry = 0, sum;

        first=reverse(first);
        second=reverse(second);

        while (first != null || second != null) {
            sum = carry + (first != null ? first.data : 0)
                    + (second != null ? second.data : 0);

            carry = (sum >= 10) ? 1 : 0;

            sum = sum % 10;

            temp = new Node(sum);

            if (res == null) {
                res = temp;
            }

            else {
                prev.next = temp;
            }

            prev = temp;

            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }

        if (carry > 0) {
            temp.next = new Node(carry);
        }

        res=reverse(res);

        return res;
    }
}
