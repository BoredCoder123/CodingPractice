package com.example.helloWorld.GeeksForGeeks.LinkedList;
//https://practice.geeksforgeeks.org/problems/pairwise-swap-elements-of-a-linked-list-by-swapping-data/1
import java.util.*;
import java.io.*;

public class PairwiseSwap {

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
            int n = sc.nextInt();

            Node head = new Node(sc.nextInt());
            Node tail = head;
            HashMap<Node, Integer> mp = new HashMap<Node, Integer>();
            mp.put(head, head.data);
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
                mp.put(tail, tail.data);
            }

            Node failure = new Node(-1);

            head = pairwiseSwap(head);

            Node temp = head;
            int f = 0;
            while (temp != null)
            {
                if(mp.get(temp) != temp.data){
                    f = 1;
                }
                temp = temp.next;
            }

            if(f==1){
                Node.printList(failure);
            }
            else{
                Node.printList(head);
            }
            t--;
        }
    }

    private static Node pairwiseSwap(Node head)
    {
        if(head==null || head.next==null)
            return head;
        Node temp=head;
        Node temp1=head.next.next;
        head=head.next;
        head.next=temp;
        temp.next=temp1;
        head.next.next=pairwiseSwap(head.next.next);
        return head;
    }
}