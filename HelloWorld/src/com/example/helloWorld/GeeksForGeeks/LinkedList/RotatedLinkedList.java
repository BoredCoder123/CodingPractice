package com.example.helloWorld.GeeksForGeeks.LinkedList;
//https://practice.geeksforgeeks.org/problems/rotate-a-linked-list/1
import java.util.*;

public class RotatedLinkedList {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int a = sc.nextInt();
            Node head = new Node(a);
            Node tail = head;

            for (int i=0; i<n-1; i++)
            {
                a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = sc.nextInt();

            head = rotate(head,k);
            Node.printList(head);
        }
    }

    private static  Node rotate(Node head, int k) {
        int len=0;
        if(head==null || head.next==null)
            return head;
        else{
            Node curr=head;
            while(curr!=null){
                len++;
                curr=curr.next;
            }
            if(len==k)
                return head;
            else{
                curr=head;
                for(int i=0;i<k-1;i++){
                    curr=curr.next;
                }
                Node end=curr;
                while(end.next!=null){
                    end=end.next;
                }
                end.next=head;
                Node temp=curr;
                head=curr.next;
                temp.next=null;
            }
        }
        return head;
    }
}