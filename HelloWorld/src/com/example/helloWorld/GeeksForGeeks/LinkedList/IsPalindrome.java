package com.example.helloWorld.GeeksForGeeks.LinkedList;
//https://practice.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1
import java.util.*;

public class IsPalindrome {

    private static Node head;
    private static Node tail;

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
        int t = sc.nextInt();

        while(t>0)
        {
            int n = sc.nextInt();
            int a1=sc.nextInt();
            Node head= new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }

            if(isPalindrome(head) == true)
                System.out.println(1);
            else
                System.out.println(0);
            t--;
        }

    }

    private static Node reverse(Node head){

        Node newList=null, t=head;
        while(t!=null){
            Node te=new Node(t.data);
            if(newList==null){
                newList=te;
            }else{
                Node temp=newList;
                while(temp.next!=null)
                    temp=temp.next;
                temp.next=te;
            }
            t=t.next;
        }

        Node out=null, current=newList;
        while(current!=null){
            Node next=current.next;
            current.next=out;
            out=current;
            current=next;
        }
        return out;
    }

    private static boolean isPalindrome(Node head)
    {
        Node revHead=reverse(head);
        Node cur=head, revCur=revHead;
        cur=head;
        revCur=revHead;
        while(cur!=null){
            if(cur.data!=revCur.data)
                return false;
            cur=cur.next;
            revCur=revCur.next;
        }
        return true;
    }
}