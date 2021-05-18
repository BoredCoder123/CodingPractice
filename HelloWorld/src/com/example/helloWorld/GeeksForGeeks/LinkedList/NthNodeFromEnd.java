package com.example.helloWorld.GeeksForGeeks.LinkedList;

import java.util.*;

public class NthNodeFromEnd {

    private static Node head;
    private static Node tail;
    /* Function to print linked list */
    void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }


    /* Inserts a new Node at front of the list. */
    private static void addToTheLast(Node node)
    {

        if (head == null)
        {
            head = node;
            tail = node;
        } else
        {
            tail.next = node;
            tail = node;
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        while(t>0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            //int n=Integer.parseInt(br.readLine());
            int a1=sc.nextInt();
            Node head= new Node(a1);
            addToTheLast(head);
            for (int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }

            System.out.println(getNthFromLast(head,k));

            t--;
        }
    }

    private static int getNthFromLast(Node head, int n)
    {
        int len=0;
        Node cur=head;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        if(len<n)
            return -1;
        if(len==n)
            return head.data;
        cur=head;
        len-=n;
        for(int i=0;i<len;i++){
            cur=cur.next;
        }
        return cur.data;
    }
}