package com.example.helloWorld.GeeksForGeeks.LinkedList;
//https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1
import java.util.*;
import java.io.*;
import java.lang.*;

public class DetectLoop {

    public static void makeLoop(Node head, Node tail, int x){
        if (x == 0) return;

        Node curr = head;
        for(int i=1; i<x; i++)
            curr = curr.next;

        tail.next = curr;
    }

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t--> 0)
        {
            int n = sc.nextInt();

            int num = sc.nextInt();
            Node head = new Node(num);
            Node tail = head;

            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = new Node(num);
                tail = tail.next;
            }

            int pos = sc.nextInt();
            makeLoop(head, tail, pos);

            if(detectLoop(head) )
                System.out.println("True");
            else
                System.out.println("False");
        }
    }

    public static boolean detectLoop(Node head){
        HashSet<Node> set= new HashSet<>();
        Node curr=head;
        while(curr!=null){
            if(set.contains(curr))
                return true;
            set.add(curr);
            curr=curr.next;
        }
        return false;
    }
}
