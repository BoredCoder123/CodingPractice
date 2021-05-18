package com.example.helloWorld.GeeksForGeeks.LinkedList;
//https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1/#

import java.util.*;

public class IntersectionPoint {

    public static void main(String args[])
    {


        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        while(t>0)
        {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            LinkedList_Intersection llist1 = new LinkedList_Intersection();
            LinkedList_Intersection llist2 = new LinkedList_Intersection();
            LinkedList_Intersection llist3 = new LinkedList_Intersection();

            int a1=sc.nextInt();
            Node head1= new Node(a1);
            Node tail1= head1;

            for (int i = 1; i < n1; i++)
            {
                int a = sc.nextInt();
                tail1.next = (new Node(a));
                tail1= tail1.next;
            }


            int b1=sc.nextInt();
            Node head2 = new Node(b1);
            Node tail2 = head2;
            for (int i = 1; i < n2; i++)
            {
                int b = sc.nextInt();
                tail2.next = (new Node(b));
                tail2= tail2.next;
            }

            int c1=sc.nextInt();
            Node head3= new Node(c1);
            tail1.next = head3;
            tail2.next = head3;
            Node tail3=head3;
            for (int i = 1; i < n3; i++)
            {
                int c = sc.nextInt();
                tail3.next = (new Node(c));
                tail3= tail3.next;
            }

            System.out.println(intersectPoint(head1, head2));
            t--;
        }
    }

    Node head = null;
    Node tail = null;

    public void addToTheLast(Node node)
    {

        if (head == null) {
            head = node;
            tail = head;
        } else {
            //Node temp = head;
            //while (temp.next != null)
            //temp = temp.next;

            //temp.next = node;
            tail.next=node;
            tail = node;
        }
    }

    private static int intersectPoint(Node head1, Node head2)
    {
        Node curr1=head1;
        Node curr2=head2;
        HashMap<Node, Integer> map=new HashMap<>();
        while(curr1!=null){
            map.put(curr1, curr1.data);
            curr1=curr1.next;
        }
        while(curr2!=null){
            if(map.containsKey(curr2))
                return map.get(curr2).intValue();
            else
                curr2=curr2.next;
        }
        return -1;
    }
}

class LinkedList_Intersection {
    Node head = null;
    Node tail = null;

    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            tail = head;
        } else {
            //Node temp = head;
            //while (temp.next != null)
            //temp = temp.next;

            //temp.next = node;
            tail.next = node;
            tail = node;
        }
    }
}