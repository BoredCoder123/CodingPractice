package com.example.helloWorld.GeeksForGeeks.LinkedList;
//https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1
import java.util.*;
import java.io.*;

public class FlatteningLinkedList {

    private static Node head;

    private static void printList(Node node)
    {
        //Node temp = head;
        while (node != null)
        {
            System.out.print(node.data + " ");
            node =node.bottom;
        }
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int arr[] = new int[N];
            for(int i=0;i<N;i++)
                arr[i] = sc.nextInt();

            Node temp = null;
            Node tempB = null;
            Node pre = null;
            Node preB = null;
            int flag=1;
            int flag1=1;
            for(int i=0; i<N;i++)
            {
                int m = arr[i];
                m--;
                int a1 = sc.nextInt();
                temp = new Node(a1);
                if(flag == 1)
                {
                    head = temp;
                    pre = temp;
                    flag = 0;
                    flag1 = 1;
                }
                else
                {
                    pre.next = temp;
                    pre = temp;
                    flag1 = 1;
                }

                for(int j=0;j<m;j++)
                {
                    int a = sc.nextInt();
                    tempB = new Node(a);
                    if(flag1 == 1)
                    {
                        temp.bottom = tempB;
                        preB = tempB;
                        flag1 = 0;
                    }
                    else
                    {
                        preB.bottom = tempB;
                        preB = tempB;
                    }
                }

            }
            //list.printList()
            Node root = flatten(head);
            FlatteningLinkedList.printList(root);

            t--;
        }
    }

    private static Node flatten(Node root)
    {
        if(root==null ||  root.next==null)
            return root;

        root.next= flatten(root.next);

        root=merge(root,root.next);

        return root;
    }

    private static Node merge(Node a, Node b){
        if(a==null)
            return b;
        if(b==null)
            return a;

        Node result;

        if(a.data<b.data){
            result=a;
            result.bottom=merge(a.bottom, b);
        }else{
            result=b;
            result.bottom=merge(a,b.bottom);
        }
        result.next=null;
        return result;
    }
}