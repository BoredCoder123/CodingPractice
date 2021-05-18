package com.example.helloWorld.GeeksForGeeks.LinkedList;
//https://practice.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1
import java.util.*;

public class MergeSortedLinkedList {

    private static Node head;

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        while(t>0)
        {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            Node head1 = new Node(sc.nextInt());
            Node tail1 = head1;
            for(int i=0; i<n1-1; i++)
            {
                tail1.next = new Node(sc.nextInt());
                tail1 = tail1.next;
            }
            Node head2 = new Node(sc.nextInt());
            Node tail2 = head2;
            for(int i=0; i<n2-1; i++)
            {
                tail2.next = new Node(sc.nextInt());
                tail2 = tail2.next;
            }

            Node head = sortedMerge(head1,head2);
            Node.printList(head);

            t--;

        }
    }

    private static Node sortedMerge(Node head1, Node head2) {
        if(head1==null)
            return head2;
        if(head2==null)
            return head1;
        Node result;
        if(head1.data<head2.data){
            result=head1;
            result.next=sortedMerge(head1.next,head2);
        }else{
            result=head2;
            result.next=sortedMerge(head1,head2.next);
        }
        return result;
    }
}