package com.example.helloWorld.GeeksForGeeks.LinkedList;

import java.io.*;
import java.util.*;

public class ReversingLinkedList {
    public static void main(String args[]) throws IOException {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){

            int n = sc.nextInt();

            Node head = new Node(sc.nextInt());
            Node tail = head;

            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }

            head = reverseList(head);
            Node.printList(head);
            t--;
        }
    }

    private static Node reverseList(Node head)
    {
        Node prev=null, curr=head, nextNode=null;
        if(head.next==null || head==null)
            return head;
        else{
            while(curr!=null){
                if(curr==head){
                    prev=curr;
                    nextNode=curr.next;
                    curr.next=null;
                    curr=nextNode;
                }else if(curr.next==null){
                    head=curr;
                    head.next=prev;
                    curr=null;
                }
                else{
                    nextNode=curr.next;
                    curr.next=prev;
                    prev=curr;
                    curr=nextNode;
                }
            }
        }
        return head;
    }
}