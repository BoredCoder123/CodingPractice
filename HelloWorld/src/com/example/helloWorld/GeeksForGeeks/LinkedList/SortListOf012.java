package com.example.helloWorld.GeeksForGeeks.LinkedList;

import java.util.*;
import java.lang.*;
import java.io.*;

public class SortListOf012 {

    public static void main (String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }

            head = segregate(head);
            Node.printList(head);
            System.out.println();
        }
    }

    static Node segregate(Node head)
    {
        if(head==null || head.next==null)
            return head;
        int[] temp=new int[3];
        for(int i=0;i<3;i++){
            temp[i]=0;
        }
        Node tempNode=head;
        while(tempNode!=null){
            temp[tempNode.data]++;
            tempNode=tempNode.next;
        }

        Node newList=null;

        for(int i=0;i<3;i++){
            for(int j=0;j<temp[i];j++){
                Node tN=new Node(i);
                if(newList==null){
                    newList=tN;
                }else{
                    Node x=newList;
                    while(x.next!=null)
                        x=x.next;
                    x.next=tN;
                }
            }
        }
        return newList;
    }
}